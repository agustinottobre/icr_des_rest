
package despacho.ws.servicios.expuestos;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orden-despacho complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orden-despacho">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigo-despacho" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo-venta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id-portal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id-monitoreo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="items" type="{http://soap.interfaces.tpo.ia.fain.uade/}item" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orden-despacho", propOrder = {
    "codigoDespacho",
    "codigoVenta",
    "idPortal",
    "idMonitoreo",
    "items"
})
public class OrdenDespacho {

    @XmlElement(name = "codigo-despacho")
    protected String codigoDespacho;
    @XmlElement(name = "codigo-venta")
    protected String codigoVenta;
    @XmlElement(name = "id-portal")
    protected String idPortal;
    @XmlElement(name = "id-monitoreo")
    protected String idMonitoreo;
    protected List<Item> items;

    /**
     * Gets the value of the codigoDespacho property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoDespacho() {
        return codigoDespacho;
    }

    /**
     * Sets the value of the codigoDespacho property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoDespacho(String value) {
        this.codigoDespacho = value;
    }

    /**
     * Gets the value of the codigoVenta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoVenta() {
        return codigoVenta;
    }

    /**
     * Sets the value of the codigoVenta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoVenta(String value) {
        this.codigoVenta = value;
    }

    /**
     * Gets the value of the idPortal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPortal() {
        return idPortal;
    }

    /**
     * Sets the value of the idPortal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPortal(String value) {
        this.idPortal = value;
    }

    /**
     * Gets the value of the idMonitoreo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdMonitoreo() {
        return idMonitoreo;
    }

    /**
     * Sets the value of the idMonitoreo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdMonitoreo(String value) {
        this.idMonitoreo = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     * 
     * 
     */
    public List<Item> getItems() {
        if (items == null) {
            items = new ArrayList<Item>();
        }
        return this.items;
    }

}
