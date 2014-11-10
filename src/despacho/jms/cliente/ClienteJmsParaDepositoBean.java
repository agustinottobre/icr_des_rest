package despacho.jms.cliente;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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

import despacho.ejb.interfaces.remotas.AdministradorPropiedades;
import despacho.ejb.interfaces.remotas.ClienteJmsParaDeposito;
import despacho.xml.bindings.SolicitudArticulos.Items.Articulo;
import despacho.xml.bindings.SolicitudArticulos;
import despacho.xml.bindings.SolicitudArticulos.Items;
import dto.ItemSolicitudArticuloDTO;
import dto.SolicitudArticuloDTO;

@Stateless
@LocalBean
public class ClienteJmsParaDepositoBean implements ClienteJmsParaDeposito{
	
	@EJB
	private AdministradorPropiedades administradorPropiedades;
	
//    private String DEFAULT_MESSAGE;
//    private String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
//    private String DEFAULT_DESTINATION = "jms/queue/solicitud";
//    private final String DEFAULT_MESSAGE_COUNT = "1";
//    private String DEFAULT_USERNAME = "test1";
//    private String DEFAULT_PASSWORD = "test12341!";
//    private final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
//    private String PROVIDER_URL = "remote://localhost:4447";
	
    private String DEFAULT_MESSAGE;
    private String DEFAULT_CONNECTION_FACTORY;
    private String DEFAULT_DESTINATION;
    private final String DEFAULT_MESSAGE_COUNT = "1";
    private String DEFAULT_USERNAME;
    private String DEFAULT_PASSWORD;
    private final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private String PROVIDER_URL;


	public boolean enviarSolicitudesArticulos(SolicitudArticuloDTO solicitudArticuloDTO){		
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        Destination destination = null;
        TextMessage message = null;
        Context context = null;

        try{
			DEFAULT_DESTINATION = (String)administradorPropiedades.get("deposito-jms-queue");
			DEFAULT_CONNECTION_FACTORY = (String)administradorPropiedades.get("deposito-jms-connection-factory");
			DEFAULT_USERNAME = (String)administradorPropiedades.get("deposito-jms-usuario");
			DEFAULT_PASSWORD = (String)administradorPropiedades.get("deposito-jms-password");
			PROVIDER_URL = (String)administradorPropiedades.get("deposito-jms-host");
			
//			DEFAULT_DESTINATION = "jms/queue/solicitud";
//			DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
//			DEFAULT_USERNAME = "deposito";
//			DEFAULT_PASSWORD = "deposito.1234";
//			PROVIDER_URL = "remote://172.16.163.30:4447";
			
        }catch(Exception e){
        	e.printStackTrace();
        }
		
		System.out.println("------------------------------");
        System.out.println("##Enviando solicitudes de articulos al deposito:  fecha: " + new Date() );
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
        
        StringWriter sw = new StringWriter();
        
        try {
        	JAXBContext jc = JAXBContext.newInstance(SolicitudArticulos.class);
        
        	Marshaller marshaller = jc.createMarshaller();
        	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        	marshaller.marshal(solicitudArticulos, System.out);
        	marshaller.marshal(solicitudArticulos, sw);

        } catch (Exception e){
        	e.printStackTrace();
        	return false;
        }
        
        try {
        	String basePath= "../standalone/deployments/icr_des_ear.ear/icr_des_rest.war/"; 

            DEFAULT_MESSAGE = sw.toString();
            
            // Set up the context for the JNDI lookup
            final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
            env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", DEFAULT_USERNAME));
            env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", DEFAULT_PASSWORD));
            context = new InitialContext(env);

            // Perform the JNDI lookups
            String connectionFactoryString = System.getProperty("connection.factory", DEFAULT_CONNECTION_FACTORY);
            System.out.println("Attempting to acquire connection factory \"" + connectionFactoryString + "\"");
            connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);
            System.out.println("Found connection factory \"" + connectionFactoryString + "\" in JNDI");

            String destinationString = System.getProperty("destination", DEFAULT_DESTINATION);
            System.out.println("Attempting to acquire destination \"" + destinationString + "\"");
            destination = (Destination) context.lookup(destinationString);
            System.out.println("Found destination \"" + destinationString + "\" in JNDI");

            // Create the JMS connection, session, producer
            connection = connectionFactory.createConnection(System.getProperty("username", DEFAULT_USERNAME), System.getProperty("password", DEFAULT_PASSWORD));
//            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(destination);
            connection.start();

            int count = Integer.parseInt(System.getProperty("message.count", DEFAULT_MESSAGE_COUNT));
            String content = System.getProperty("message.content", DEFAULT_MESSAGE);

            System.out.println("Sending " + count + " messages with content: " + content);
//             Send the specified number of messages
            for (int i = 0; i < count; i++) {
                message = session.createTextMessage(content);
                producer.send(message);
            }
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        	return false;
        } finally {
        	try{
	            if (context != null) {
	                context.close();
	            }
	            // closing the connection takes care of the session, producer, and consumer
	            if (connection != null) {
	                connection.close();
	            }
        	}catch (Exception e) {
        		e.printStackTrace();
        		return false;
			}
        }
        
        return true;
	}
}
