package despacho.ws.servicios;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Session Bean implementation class HelloWorld
 */
@Stateless
@WebService
public class HelloWorld {

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }
    
    @WebMethod
    public String saludo(){
    	return "holis";
    }
    
    @WebMethod
    public int contador(int a){
    	return ++a ;
    }

}
