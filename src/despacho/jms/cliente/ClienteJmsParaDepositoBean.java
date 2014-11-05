package despacho.jms.cliente;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import despacho.ejb.interfaces.remotas.ClienteJmsParaDeposito;
import despacho.xml.bindings.SolicitudArticulos.Items.Articulo;
import despacho.xml.bindings.SolicitudArticulos;
import despacho.xml.bindings.SolicitudArticulos.Items;
import dto.ItemSolicitudArticuloDTO;
import dto.SolicitudArticuloDTO;

@Stateless
public class ClienteJmsParaDepositoBean implements ClienteJmsParaDeposito{

	public boolean enviarSolicitudesArticulos(SolicitudArticuloDTO solicitudArticuloDTO){
		System.out.println("------------------------------");
        System.out.println("##Enviando solicitudes de articulos al deposito: queue/deposito fecha: " + new Date() );
        System.out.println("##solicitudArticulo.id: " + solicitudArticuloDTO.getIdSolicitud());
        System.out.println("##solicitudArticulo.idDeposito: " + solicitudArticuloDTO.getidDeposito());
        for(ItemSolicitudArticuloDTO itemSolicitudArticuloDTO : solicitudArticuloDTO.getItems()){
        		System.out.println("####itemSolicitudArticulo.idArticulo: " + itemSolicitudArticuloDTO.getArticulo().getIdArticulo());
        		System.out.println("####itemSolicitudArticulo.cantidad: " + itemSolicitudArticuloDTO.getCantidad());
        }
        System.out.println("------------------------------");
        
        SolicitudArticulos solicitudArticulos = new SolicitudArticulos();
        solicitudArticulos.setIdSolicitud(String.valueOf(solicitudArticuloDTO.getIdSolicitud()));
        solicitudArticulos.setIdModulo(String.valueOf(solicitudArticuloDTO.getidDeposito()));
        List<Items> items = new ArrayList<Items>();
        for(ItemSolicitudArticuloDTO itemSolicitudArticuloDTO : solicitudArticuloDTO.getItems()){
        	Items item = new Items();
        	Articulo articulo = new Articulo();
        	articulo.setCodigo(String.valueOf(itemSolicitudArticuloDTO.getArticulo().getIdArticulo()));
        	articulo.setCantidad(itemSolicitudArticuloDTO.getCantidad());
        	item.setArticulo(articulo);
        	solicitudArticulos.setItems(item);
        }
        
        
        try {
        	JAXBContext jc = JAXBContext.newInstance(SolicitudArticulos.class);
        
        	Marshaller marshaller = jc.createMarshaller();
        	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        	marshaller.marshal(solicitudArticulos, System.out);

        	return true;
        } catch (Exception e){
        	e.printStackTrace();
        	return false;
        }
	}
}
