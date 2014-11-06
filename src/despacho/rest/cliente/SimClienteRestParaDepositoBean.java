package despacho.rest.cliente;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

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

import despacho.ejb.interfaces.remotas.ClienteJmsParaDeposito;
import despacho.ejb.interfaces.remotas.SimClienteRestParaDeposito;
import despacho.xml.bindings.SolicitudArticulos.Items.Articulo;
import despacho.xml.bindings.SolicitudArticulos;
import despacho.xml.bindings.SolicitudArticulos.Items;
import dto.ItemSolicitudArticuloDTO;
import dto.SolicitudArticuloDTO;

@Stateless
public class SimClienteRestParaDepositoBean implements SimClienteRestParaDeposito {

	public String testRecibirArticulosPorRESTDesdeDeposito(){		
		return "##TEST testRecibirArticulosPorRESTDesdeDeposito OK!";
	}
}
