package despacho.ws.servicios.expuestos.impl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import despacho.ejb.interfaces.remotas.AdministradorOrdenesDespacho;
import despacho.ejb.interfaces.remotas.AsyncEnviarSolicitudesArticulos;
import despacho.ejb.interfaces.remotas.ClienteJmsParaDeposito;
import despacho.ws.servicios.expuestos.*;
import dto.ArticuloDTO;
import dto.ItemOrdenDespachoDTO;
import dto.OrdenDespachoDTO;
import dto.OrdenVentaDTO;
import dto.PortalDTO;
import dto.SolicitudArticuloDTO;

import javax.ejb.EJB;
import javax.jws.WebService;

@WebService(serviceName = "OrdenDespachoSoapWSBeanService", endpointInterface = "despacho.ws.servicios.expuestos.OrdenDespachoSoapWS", targetNamespace = "http://soap.interfaces.tpo.ia.fain.uade/")
public class OrdenDespachoSoapWSImpl implements OrdenDespachoSoapWS {
	
	@EJB
	private AdministradorOrdenesDespacho administradorOrdenesDespacho;
	
	@EJB
	private AsyncEnviarSolicitudesArticulos async;
	
	public despacho.ws.servicios.expuestos.Resultado recibirOrdenDespacho(
			despacho.ws.servicios.expuestos.OrdenDespacho arg0)
			throws ArticuloDesconocidoException_Exception,
			OrdenDespachoYaExisteException_Exception, Exception_Exception {
		
		OrdenDespacho ordenDespacho = (OrdenDespacho) arg0;
		OrdenDespachoDTO ordenDespachoDTO = new OrdenDespachoDTO();
		
		System.out.println("###### Llamada de Web Service de Logistica --> Despacho para envio de Orden de Despacho ");
		System.out.println("## --- Datos Recibidos ---");
		System.out.println("##codigo despacho: " + ordenDespacho.getCodigoDespacho());
		ordenDespachoDTO.setIdOrdenDespacho(Integer.parseInt(ordenDespacho.getCodigoDespacho()));
		
		System.out.println("##codigo portal: " + ordenDespacho.getIdPortal());
		PortalDTO portalDTO = new PortalDTO();
		portalDTO.setIdPortal(Integer.parseInt(ordenDespacho.getIdPortal()));
		
		System.out.println("##codigo venta: " + ordenDespacho.getCodigoVenta());
		OrdenVentaDTO ordenVentaDTO = new OrdenVentaDTO();
		ordenVentaDTO.setIdOrdenVenta(Integer.parseInt(ordenDespacho.getCodigoVenta()));
		ordenVentaDTO.setPortal(portalDTO);
		ordenDespachoDTO.setOrdenVenta(ordenVentaDTO);
		
		System.out.println("##codigo monitoreo: " + ordenDespacho.getIdMonitoreo());
		ordenDespachoDTO.setIdLogistica(Integer.parseInt(ordenDespacho.getIdMonitoreo()));
		
		//No se usa por ahora...
		
		
		Set<ItemOrdenDespachoDTO> itemsOrdenDespachoDTOs = new HashSet<ItemOrdenDespachoDTO>();
		System.out.println("## ITEMS");
		for(Item item : ordenDespacho.getItems()){
			System.out.println("------------------");
			ItemOrdenDespachoDTO itemOrdenDespachoDTO = new ItemOrdenDespachoDTO();
			System.out.println("####item - id articulo: " + item.getArticuloId());
			ArticuloDTO articuloDTO = new ArticuloDTO();
			articuloDTO.setIdArticulo(Integer.parseInt(item.getArticuloId()));
			itemOrdenDespachoDTO.setArticulo(articuloDTO);
			System.out.println("####item - cantidad: " + item.getCantidad());
			itemOrdenDespachoDTO.setCantidad(item.getCantidad());
			itemOrdenDespachoDTO.setIdOrdenDespacho(ordenDespachoDTO.getIdOrdenDespacho());
			itemsOrdenDespachoDTOs.add(itemOrdenDespachoDTO);
			System.out.println("");
		}
		ordenDespachoDTO.setItems(itemsOrdenDespachoDTOs);
		
		Resultado resultado = new Resultado();
		if(administradorOrdenesDespacho.altaOrdenDespacho(ordenDespachoDTO)){
			System.out.println("## AdministradorOrdenesDespacho - altaOrdenDespacho OK");
			resultado.setEstado("OK");
			resultado.setMensaje("El alta de la Orden de Despacho fue exitosa");
			
			System.out.println("### AdministradorOrdenesDespacho - Comienza procesamiento de Orden de Despacho");
			List<SolicitudArticuloDTO> listaSolicitudesArticulosDTO = administradorOrdenesDespacho.procesarSolicitudDespacho(ordenDespachoDTO); 
			if ( listaSolicitudesArticulosDTO != null) {
				
//				//Enviar a deposito por JMS las solicitudes
//				for(SolicitudArticuloDTO solicitudArticuloDTO : listaSolicitudesArticulosDTO){
//					clienteJmsParaDeposito.enviarSolicitudesArticulos(solicitudArticuloDTO);	
//				}
				async.enviarSolicitudesArticulos(listaSolicitudesArticulosDTO);
				
				resultado.setEstado("OK");
				resultado.setMensaje("El alta de la Orden de Despacho fue exitosa");
				return resultado;
			}
			
		}
		resultado.setEstado("ERROR");
		resultado.setMensaje("Fallo el alta de la Orden de Despacho");
		return resultado;
	}
}