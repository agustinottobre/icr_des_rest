package despacho.rest.recursos;

import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import despacho.rest.servicios.ServicioArticulo;

@Path("/articulos")
public class RecursoArticulo {
	
	@Inject
	private ServicioArticulo servicioArticulo;

	@GET()
	@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
	public String testArticulo() {
	    return "APP Despacho REST OK, test recurso Articulo!";
	}
	
	@GET()
	@Path("ejb")
	@Produces("text/plain")
	public String testEJB() {
	    return servicioArticulo.testEJB();
	}	
}
