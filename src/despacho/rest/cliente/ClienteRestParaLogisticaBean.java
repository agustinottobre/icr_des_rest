package despacho.rest.cliente;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import despacho.ejb.interfaces.remotas.AdministradorPropiedades;
import despacho.ejb.interfaces.remotas.ClienteJmsParaDeposito;
import despacho.ejb.interfaces.remotas.ClienteRestParaLogistica;
import despacho.ejb.interfaces.remotas.SimClienteRestParaDeposito;
import despacho.rest.bindings.ArticulosRecibidos;
import despacho.rest.bindings.Item;
import despacho.xml.bindings.SolicitudArticulos.Items.Articulo;
import despacho.xml.bindings.SolicitudArticulos;
import despacho.xml.bindings.SolicitudArticulos.Items;
import dto.ItemSolicitudArticuloDTO;
import dto.OrdenDespachoDTO;
import dto.SolicitudArticuloDTO;

@Stateless
public class ClienteRestParaLogisticaBean implements ClienteRestParaLogistica {
	
	private AdministradorPropiedades administradorPropiedades;
	
	@Override
	public boolean enviarCambioEstado(OrdenDespachoDTO ordenDespachoDTO) {
		  try {
			  Context context = new InitialContext();
			  administradorPropiedades = (AdministradorPropiedades)context.lookup("java:global/icr_des_ear/icr_des_nco/AdministradorPropiedadesBean!despacho.ejb.interfaces.remotas.AdministradorPropiedades");
			  
//				ClientRequest request = new ClientRequest(
//						(String)administradorPropiedades.get("logistica-rest-host") +
//						(String)administradorPropiedades.get("logistica-rest-path-cambioestado") +
//						ordenDespachoDTO.getIdOrdenDespacho()
//						);
			  ClientRequest request = null;
//				if (ordenDespachoDTO.getIdLogistica()== 10) {
				if (ordenDespachoDTO.getIdLogistica()== Integer.parseInt((String)administradorPropiedades.get("logistica-rest-id1"))) {
					request = new ClientRequest(
							(String)administradorPropiedades.get("logistica-rest-host1") +
							(String)administradorPropiedades.get("logistica-rest-path-cambioestado1") +
							ordenDespachoDTO.getIdOrdenDespacho()
							);		
				}else
//				if (ordenDespachoDTO.getIdLogistica()== 3) {
				if (ordenDespachoDTO.getIdLogistica()== Integer.parseInt((String)administradorPropiedades.get("logistica-rest-id2"))) {
					request = new ClientRequest(
							(String)administradorPropiedades.get("logistica-rest-host2") +
							(String)administradorPropiedades.get("logistica-rest-path-cambioestado2") +
							ordenDespachoDTO.getIdOrdenDespacho()
							);		
				}else
//				if (ordenDespachoDTO.getIdLogistica()== 4) {
				if (ordenDespachoDTO.getIdLogistica()== Integer.parseInt((String)administradorPropiedades.get("logistica-rest-id3"))) {
					request = new ClientRequest(
							(String)administradorPropiedades.get("logistica-rest-host3") +
							(String)administradorPropiedades.get("logistica-rest-path-cambioestado3") +
							ordenDespachoDTO.getIdOrdenDespacho()
							);		
				}

				
				if(null == request){
					System.out.println("##Logistica DESCONOCIDO!!!!!!!!!!!!! ");
					return false;
				}
				
				request.accept("application/json");
		 
//				String input = "{\"nroDespacho\":100,\"name\":\"iPad 4\"}";
//				String input = "{\"nroDespacho\":" + idOrdenDespacho + "}";
//				System.out.println("##enviando a logistica mediante POST: " + input);
				System.out.println("##enviando a logistica id: " + ordenDespachoDTO.getIdLogistica());
				System.out.println("##enviando a logistica mediante POST: " + request.getUri());
//				request.body("application/json", input);
		 
				ClientResponse<String> response = request.post(String.class);
				
				System.out.println("##request.post ya se ejecuto");
		 
				if (response.getStatus() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
				}
		 
				BufferedReader br = new BufferedReader(new InputStreamReader(
					new ByteArrayInputStream(response.getEntity().getBytes())));
		 
				String output;
				System.out.println("Respuesta del servidor Logistica.... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

		  	  } catch (ConnectException e) {
		  		  System.out.println("##Cliente Logistica - Connection Timeout");
		  		  return false;
		      } catch (SocketTimeoutException e) {
		    	  System.out.println("##Cliente Logistica - Socket Timeout");
		    	  return false;
			  } catch (Exception e) {		 
				e.printStackTrace();
				return false;
			  }
		 
		return true;
	}	
		
}
