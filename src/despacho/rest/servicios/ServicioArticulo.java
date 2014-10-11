package despacho.rest.servicios;

import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import despacho.ejb.interfaces.remotas.AdministradorArticulos;

@Stateless
public class ServicioArticulo {

	@EJB
	private AdministradorArticulos administradorArticulos;
	
	public String testEJB(){
		return "APP Despacho REST OK, test SERVICIO Articulo EJB! " +
				administradorArticulos.testEJB();
	}
	
}
