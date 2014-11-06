package despacho.rest.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import despacho.ejb.interfaces.remotas.AdministradorArticulos;
import despacho.ejb.interfaces.remotas.AdministradorTest;
import despacho.rest.bindings.ArticulosRecibidos;
import despacho.rest.bindings.Item;
import despacho.rest.bindings.RespuestaRest;

@Stateless
public class ServicioArticulo {

	@EJB
	private AdministradorArticulos administradorArticulos;
	
	public Response recibirArticulos(ArticulosRecibidos articulosRecibidos){
		System.out.println("-------------------------------------"); 
		System.out.println("##articulosRecibidos.getIdSolicitud: " + articulosRecibidos.getIdSolicitud());
		System.out.println("##articulosRecibidos.getIdSolicitud: " + articulosRecibidos.getIdModulo());
		for(Item item : articulosRecibidos.getItems()){
			System.out.println("####item.getCodigo: " + item.getCodigo());
			System.out.println("####item.getCantidad: " + item.getCantidad());
		}
		System.out.println("-------------------------------------");
		
		//LOGICA DE NOGCIO FALTANTE
		
		RespuestaRest respuestaRest = new RespuestaRest();
		if(true){
			respuestaRest.setEstado("OK");
			respuestaRest.setMensaje("##recibirArticulos OK!");			
		}else{
			respuestaRest.setEstado("ERROR");
			respuestaRest.setMensaje("##recibirArticulos FALLO!");
		}

		return Response.status(200).entity(respuestaRest).build();
	}
}
