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
public class ServicioArticulo {

	@EJB
	private AdministradorArticulos administradorArticulos;
	
	public String recibirArticulos(ArticulosRecibidos articulosRecibidos){
		System.out.println("-------------------------------------"); 
		System.out.println("##articulosRecibidos.getIdSolicitud: " + articulosRecibidos.getIdSolicitud());
		System.out.println("##articulosRecibidos.getIdSolicitud: " + articulosRecibidos.getIdModulo());
		for(Item item : articulosRecibidos.getItems()){
			System.out.println("####item.getCodigo: " + item.getCodigo());
			System.out.println("####item.getCantidad: " + item.getCantidad());
		}
		System.out.println("-------------------------------------");
		
		return "##recibirArticulos OK!";
	}
}
