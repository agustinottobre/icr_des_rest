package despacho.jms.cliente;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import despacho.ejb.interfaces.remotas.ClienteJmsParaDeposito;
import despacho.ejb.interfaces.remotas.SimuladorLogisticaClienteJmsParaDespacho;
import despacho.xml.bindings.SolicitudArticulos.Items.Articulo;
import despacho.xml.bindings.SolicitudArticulos;
import despacho.xml.bindings.SolicitudArticulos.Items;
import dto.ItemSolicitudArticuloDTO;
import dto.SolicitudArticuloDTO;

@Stateless
public class SimuladorLogisticaClienteJmsParaDespachoBean implements SimuladorLogisticaClienteJmsParaDespacho{
	private final Logger log = Logger.getLogger(SimuladorLogisticaClienteJmsParaDespachoBean.class.getName());
	
    private String DEFAULT_MESSAGE;
    private final String DEFAULT_CONNECTION_FACTORY = "java:jboss/exported/jms/RemoteConnectionFactory";
    private final String DEFAULT_DESTINATION = "java:jboss/exported/jms/queue/nuevosArticulos";
    private final String DEFAULT_MESSAGE_COUNT = "1";
    private final String DEFAULT_USERNAME = "despacho";
    private final String DEFAULT_PASSWORD = "despacho123!";
//    private static final String DEFAULT_USERNAME = "admin";
//    private static final String DEFAULT_PASSWORD = "admin2014!";
    private final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private final String PROVIDER_URL = "remote://localhost:4447";

    public String testRecibirOrdenDespachoPorWSDesdeLogistica(){

        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        MessageProducer producer = null;
        MessageConsumer consumer = null;
        Destination destination = null;
        TextMessage message = null;
        Context context = null;

        try {
//        	System.getProperty("[B]jboss.server.home.dir[/B]");
//        	System.getProperty("jboss.server.config.url");
        	
        	String basePath= "../standalone/deployments/icr_des_ear.ear/icr_des_rest.war/"; 
        	  
//        	  String files;
//        	  File folder = new File(basePath);
//        	  File[] listOfFiles = folder.listFiles(); 
//        	 
//        	  for (int i = 0; i < listOfFiles.length; i++) 
//        	  {
//        	   if (listOfFiles[i].isFile()) 
//        	   {
//        		   files = listOfFiles[i].getName();
//        		   System.out.println(files);
//        	   }
//        	  }

            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(basePath + "xml/nuevoArticuloTest.xml"));
            String sCurrentLine;
            while (( sCurrentLine = br.readLine()) != null) {
              sb.append(sCurrentLine);
            }
            System.out.println(sb.toString());
            DEFAULT_MESSAGE = sb.toString();
            
            // Set up the context for the JNDI lookup
            final Properties env = new Properties();
//            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
            env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", DEFAULT_USERNAME));
            env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", DEFAULT_PASSWORD));
            context = new InitialContext(env);

            // Perform the JNDI lookups
            String connectionFactoryString = System.getProperty("connection.factory", DEFAULT_CONNECTION_FACTORY);
            log.info("Attempting to acquire connection factory \"" + connectionFactoryString + "\"");
            connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);
            log.info("Found connection factory \"" + connectionFactoryString + "\" in JNDI");

            String destinationString = System.getProperty("destination", DEFAULT_DESTINATION);
            log.info("Attempting to acquire destination \"" + destinationString + "\"");
            destination = (Destination) context.lookup(destinationString);
            log.info("Found destination \"" + destinationString + "\" in JNDI");

            // Create the JMS connection, session, producer, and consumer
            connection = connectionFactory.createConnection(System.getProperty("username", DEFAULT_USERNAME), System.getProperty("password", DEFAULT_PASSWORD));
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(destination);
//            consumer = session.createConsumer(destination);
            connection.start();

            int count = Integer.parseInt(System.getProperty("message.count", DEFAULT_MESSAGE_COUNT));
            String content = System.getProperty("message.content", DEFAULT_MESSAGE);

            log.info("Sending " + count + " messages with content: " + content);

//             Send the specified number of messages
            for (int i = 0; i < count; i++) {
                message = session.createTextMessage(content);
                producer.send(message);
            }

            // Then receive the same number of messages that were sent
//            for (int i = 0; i < count; i++) {
//                message = (TextMessage) consumer.receive(5000);
//                log.info("Received message with content " + message.getText());
//            }
        } catch (Exception e) {
            log.severe(e.getMessage());
//            throw e;
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
			}
        }
        
        return "##TEST testRecibirOrdenDespachoPorWSDesdeLogistica OK!";
    }
}
