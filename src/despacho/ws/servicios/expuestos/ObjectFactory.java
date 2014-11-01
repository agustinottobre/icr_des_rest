
package despacho.ws.servicios.expuestos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the despacho.ws.servicios.expuestos package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RecibirOrdenDespacho_QNAME = new QName("http://soap.interfaces.tpo.ia.fain.uade/", "recibirOrdenDespacho");
    private final static QName _OrdenDespachoYaExisteException_QNAME = new QName("http://soap.interfaces.tpo.ia.fain.uade/", "OrdenDespachoYaExisteException");
    private final static QName _ArticuloDesconocidoException_QNAME = new QName("http://soap.interfaces.tpo.ia.fain.uade/", "ArticuloDesconocidoException");
    private final static QName _Exception_QNAME = new QName("http://soap.interfaces.tpo.ia.fain.uade/", "Exception");
    private final static QName _RecibirOrdenDespachoResponse_QNAME = new QName("http://soap.interfaces.tpo.ia.fain.uade/", "recibirOrdenDespachoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: despacho.ws.servicios.expuestos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link RecibirOrdenDespachoResponse }
     * 
     */
    public RecibirOrdenDespachoResponse createRecibirOrdenDespachoResponse() {
        return new RecibirOrdenDespachoResponse();
    }

    /**
     * Create an instance of {@link ArticuloDesconocidoException }
     * 
     */
    public ArticuloDesconocidoException createArticuloDesconocidoException() {
        return new ArticuloDesconocidoException();
    }

    /**
     * Create an instance of {@link OrdenDespachoYaExisteException }
     * 
     */
    public OrdenDespachoYaExisteException createOrdenDespachoYaExisteException() {
        return new OrdenDespachoYaExisteException();
    }

    /**
     * Create an instance of {@link RecibirOrdenDespacho }
     * 
     */
    public RecibirOrdenDespacho createRecibirOrdenDespacho() {
        return new RecibirOrdenDespacho();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link Resultado }
     * 
     */
    public Resultado createResultado() {
        return new Resultado();
    }

    /**
     * Create an instance of {@link OrdenDespacho }
     * 
     */
    public OrdenDespacho createOrdenDespacho() {
        return new OrdenDespacho();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecibirOrdenDespacho }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.interfaces.tpo.ia.fain.uade/", name = "recibirOrdenDespacho")
    public JAXBElement<RecibirOrdenDespacho> createRecibirOrdenDespacho(RecibirOrdenDespacho value) {
        return new JAXBElement<RecibirOrdenDespacho>(_RecibirOrdenDespacho_QNAME, RecibirOrdenDespacho.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrdenDespachoYaExisteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.interfaces.tpo.ia.fain.uade/", name = "OrdenDespachoYaExisteException")
    public JAXBElement<OrdenDespachoYaExisteException> createOrdenDespachoYaExisteException(OrdenDespachoYaExisteException value) {
        return new JAXBElement<OrdenDespachoYaExisteException>(_OrdenDespachoYaExisteException_QNAME, OrdenDespachoYaExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticuloDesconocidoException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.interfaces.tpo.ia.fain.uade/", name = "ArticuloDesconocidoException")
    public JAXBElement<ArticuloDesconocidoException> createArticuloDesconocidoException(ArticuloDesconocidoException value) {
        return new JAXBElement<ArticuloDesconocidoException>(_ArticuloDesconocidoException_QNAME, ArticuloDesconocidoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.interfaces.tpo.ia.fain.uade/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecibirOrdenDespachoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.interfaces.tpo.ia.fain.uade/", name = "recibirOrdenDespachoResponse")
    public JAXBElement<RecibirOrdenDespachoResponse> createRecibirOrdenDespachoResponse(RecibirOrdenDespachoResponse value) {
        return new JAXBElement<RecibirOrdenDespachoResponse>(_RecibirOrdenDespachoResponse_QNAME, RecibirOrdenDespachoResponse.class, null, value);
    }

}
