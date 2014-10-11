package despacho.rest.recursos;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ordenesdespacho")
public class RecursoOrdenDespacho {

	@GET()
	@Produces("text/plain")
	public String testOrdenDespacho() {
	    return "APP Despacho REST OK, test recurso OrdenDespacho!";
	}
}
