package despacho.rest.recursos;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import despacho.rest.bindings.ArticulosRecibidos;
import despacho.rest.bindings.RespuestaRest;
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
	
	@POST
	@Path("recibirArticulos")
	@Consumes("application/json")
	@Produces("application/json")
	public Response recibirArticulos(ArticulosRecibidos articulosRecibidos) {
	    return servicioArticulo.recibirArticulos(articulosRecibidos);
	}
	
}
