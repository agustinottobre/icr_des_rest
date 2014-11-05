package despacho.jms.cliente;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jms.Queue;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import despacho.ejb.interfaces.remotas.AdministradorArticulos;
import despacho.xml.bindings.Articulo;
import dto.ArticuloDTO;

/**
 * Message-Driven Bean implementation class for: EjemploMDB
 */
@MessageDriven(
activationConfig = { 
@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/nuevosArticulos")
}, mappedName = "queue/nuevosArticulos")

public class NuevosArticulosMDB implements MessageListener {
	
	@EJB
	private AdministradorArticulos administradorArticulos;

    public NuevosArticulosMDB() {
    }
	
    public void onMessage(Message message) {
    	TextMessage textMessage = (TextMessage) message;
        try {
          System.out.println("Articulo Nuevo recibido de queue/nuevosArticulos fecha: " + new Date() );
          System.out.println(textMessage.getText());
          
          JAXBContext jc = JAXBContext.newInstance(Articulo.class);
          
          Unmarshaller unmarshaller = jc.createUnmarshaller();

          ByteArrayInputStream input = new ByteArrayInputStream (textMessage.getText().getBytes()); 
          Articulo articulo = (Articulo) unmarshaller.unmarshal(input);
          input.close();
          
          System.out.println("------------------------------");
          System.out.println("Articulo Recibido y parseado: ");
          System.out.println("articulo.codigo: " + articulo.getCodigo());
          System.out.println("articulo.nombre: " + articulo.getNombre());
          System.out.println("articulo.idModulo: " + articulo.getIdModulo());
          System.out.println("------------------------------");
          
          ArticuloDTO articuloDTO = new ArticuloDTO();
          articuloDTO.setDescripcion(articulo.getNombre());
          articuloDTO.setIdArticulo(Integer.parseInt(articulo.getCodigo()));
          articuloDTO.setIdDeposito(Integer.parseInt(articulo.getIdModulo()));
          
          if (null != administradorArticulos.altaArticulo(articuloDTO)){
        	  System.out.println("administradorArticulos.altaArticulo exitosa!");
        	  return;
          }
          System.out.println("administradorArticulos.altaArticulo fallida!");
          
             
        } catch (JMSException e) {
        	e.printStackTrace();
        } catch (Exception e){
        	e.printStackTrace();
        }

    }
}