
package despacho.ws.servicios.expuestos;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.7.redhat-1
 * 2014-11-01T16:46:31.575-03:00
 * Generated source version: 2.7.7.redhat-1
 */

@WebFault(name = "Exception", targetNamespace = "http://soap.interfaces.tpo.ia.fain.uade/")
public class Exception_Exception extends java.lang.Exception {
    
    private despacho.ws.servicios.expuestos.Exception exception;

    public Exception_Exception() {
        super();
    }
    
    public Exception_Exception(String message) {
        super(message);
    }
    
    public Exception_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Exception_Exception(String message, despacho.ws.servicios.expuestos.Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception_Exception(String message, despacho.ws.servicios.expuestos.Exception exception, Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    public despacho.ws.servicios.expuestos.Exception getFaultInfo() {
        return this.exception;
    }
}
