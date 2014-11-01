
package despacho.ws.servicios.consumidos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the despacho.ws.servicios.consumidos package. 
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

    private final static QName _NotificarEntregaDespacho_QNAME = new QName("http://portalEstadoEntrega/", "notificarEntregaDespacho");
    private final static QName _NotificarEntregaDespachoResponse_QNAME = new QName("http://portalEstadoEntrega/", "notificarEntregaDespachoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: despacho.ws.servicios.consumidos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotificarEntregaDespacho }
     * 
     */
    public NotificarEntregaDespacho createNotificarEntregaDespacho() {
        return new NotificarEntregaDespacho();
    }

    /**
     * Create an instance of {@link NotificarEntregaDespachoResponse }
     * 
     */
    public NotificarEntregaDespachoResponse createNotificarEntregaDespachoResponse() {
        return new NotificarEntregaDespachoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotificarEntregaDespacho }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portalEstadoEntrega/", name = "notificarEntregaDespacho")
    public JAXBElement<NotificarEntregaDespacho> createNotificarEntregaDespacho(NotificarEntregaDespacho value) {
        return new JAXBElement<NotificarEntregaDespacho>(_NotificarEntregaDespacho_QNAME, NotificarEntregaDespacho.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotificarEntregaDespachoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://portalEstadoEntrega/", name = "notificarEntregaDespachoResponse")
    public JAXBElement<NotificarEntregaDespachoResponse> createNotificarEntregaDespachoResponse(NotificarEntregaDespachoResponse value) {
        return new JAXBElement<NotificarEntregaDespachoResponse>(_NotificarEntregaDespachoResponse_QNAME, NotificarEntregaDespachoResponse.class, null, value);
    }

}
