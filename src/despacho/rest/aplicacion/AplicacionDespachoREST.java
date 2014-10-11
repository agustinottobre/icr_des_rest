package despacho.rest.aplicacion;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import despacho.rest.recursos.RecursoArticulo;
import despacho.rest.recursos.RecursoOrdenDespacho;

@ApplicationPath("/")
public class AplicacionDespachoREST extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	public AplicacionDespachoREST(){
		 classes.add(RecursoArticulo.class);
		 classes.add(RecursoOrdenDespacho.class);
	}
	@Override
	public Set<Class<?>> getClasses() {
	     return classes;
	}
	@Override
	public Set<Object> getSingletons() {
	     return singletons;
	}
}
