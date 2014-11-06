package despacho.rest.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import despacho.ejb.interfaces.remotas.AdministradorArticulos;
import despacho.ejb.interfaces.remotas.AdministradorTest;
import despacho.rest.bindings.ArticulosRecibidos;
import despacho.rest.bindings.Item;

@Stateless
public class ServicioTest {
	@EJB
	private AdministradorTest administradorTest;
	
	public String testEJB(){
		return "APP Despacho REST OK, test SERVICIO Articulo EJB! " +
				administradorTest.testEJB();
	}
	
	public String testJPA(){
		administradorTest.persistirPortal("desc portal test");
		return "APP Despacho REST OK, test SERVICIO Portal JPA! ";
	}
	
	public String testEnviarSolicitudArticuloDepositoClienteJMS(){
		return administradorTest.testEnviarSolicitudArticuloDepositoClienteJMS();
	}
	
	public String testRecibirOrdenDespachoPorWS(){
		return administradorTest.testRecibirOrdenDespachoPorWSDesdeLogistica();
	}
	
	public String testRecibirArticulos(){
		return administradorTest.testRecibirArticulosPorRESTDesdeDeposito();
	}
	
	public ArticulosRecibidos testGenerarJsonRecibirArticulos(){
		ArticulosRecibidos articulosRecibidos = new ArticulosRecibidos();
		articulosRecibidos.setIdModulo("3");
		articulosRecibidos.setIdSolicitud("22");
		List<Item> items = new ArrayList<Item>();
			Item item = new Item();
			item.setCantidad(5D);
			item.setCodigo("3234");
			items.add(item);
				 item = new Item();
			item.setCantidad(12D);
			item.setCodigo("7654");
			items.add(item);
		articulosRecibidos.setItems(items);
		return articulosRecibidos;
	}
	
}
