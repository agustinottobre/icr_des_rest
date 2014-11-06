package despacho.rest.recursos;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import despacho.rest.bindings.ArticulosRecibidos;
import despacho.rest.servicios.ServicioArticulo;
import despacho.rest.servicios.ServicioTest;

@Path("/test")
public class RecursoTest {
	
	@Inject
	private ServicioTest servicioTest;

	@GET()
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String test() {
	    return "APP Despacho REST OK, test!";
	}
	
	@GET()
	@Path("ejb")
	@Produces("text/plain")
	public String testEJB() {
	    return servicioTest.testEJB();
	}
	
	@GET()
	@Path("jpa")
	@Produces("text/plain")
	public String testJPA() {
	    return servicioTest.testJPA();
	}

	@GET()
	@Path("recibirordendespacho")
	@Produces("text/plain")
	public String testRecibirOrdenDespacho() {
	    return servicioTest.testRecibirOrdenDespachoPorWS();
	}
	
	@GET()
	@Path("solicitudarticulo")
	@Produces("text/plain")
	public String testSolicitudArticulo() {
	    return servicioTest.testEnviarSolicitudArticuloDepositoClienteJMS();
	}
	
	@GET()
	@Path("recibirarticulos")
	@Produces("text/plain")
	public String testRecibirArticulos() {
	    return servicioTest.testRecibirArticulos();
	}
	
	@GET()
	@Path("generarjsonrecibirarticulos")
	@Produces("application/json")
	public ArticulosRecibidos testGenerarJsonRecibirArticulos() {
	    return servicioTest.testGenerarJsonRecibirArticulos();
	}
	
}
