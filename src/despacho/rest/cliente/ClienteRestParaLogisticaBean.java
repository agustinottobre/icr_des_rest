package despacho.rest.cliente;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
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
import dto.SolicitudArticuloDTO;

@Stateless
public class ClienteRestParaLogisticaBean implements ClienteRestParaLogistica {
	
	private AdministradorPropiedades administradorPropiedades;
	
	@Override
	public boolean enviarCambioEstado(int idOrdenDespacho) {
		  try {
			  Context context = new InitialContext();
			  administradorPropiedades = (AdministradorPropiedades)context.lookup("java:global/icr_des_ear/icr_des_nco/AdministradorPropiedadesBean!despacho.ejb.interfaces.remotas.AdministradorPropiedades");
			  
				ClientRequest request = new ClientRequest(
//						"http://localhost:8080/despacho/rest/test/echopost"
						(String)administradorPropiedades.get("logistica-rest-host") +
						(String)administradorPropiedades.get("logistica-rest-path-cambioestado") +
						idOrdenDespacho
						);
				request.accept("application/json");
		 
//				String input = "{\"nroDespacho\":100,\"name\":\"iPad 4\"}";
//				String input = "{\"nroDespacho\":" + idOrdenDespacho + "}";
//				System.out.println("##enviando a logistica mediante POST: " + input);
				System.out.println("##enviando a logistica mediante POST: " + request.getUri());
//				request.body("application/json", input);
		 
				ClientResponse<String> response = request.post(String.class);
		 
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
		 
			  } catch (Exception e) {		 
				e.printStackTrace();
				return false;
			  }
		 
		return true;
	}	
		
}
