
package soaphw;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soaphw package. 
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

    private final static QName _ChangeTenderName_QNAME = new QName("http://soaphw/", "changeTenderName");
    private final static QName _ChangeTenderNameResponse_QNAME = new QName("http://soaphw/", "changeTenderNameResponse");
    private final static QName _GetTender_QNAME = new QName("http://soaphw/", "getTender");
    private final static QName _GetTenderResponse_QNAME = new QName("http://soaphw/", "getTenderResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soaphw
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangeTenderName }
     * 
     */
    public ChangeTenderName createChangeTenderName() {
        return new ChangeTenderName();
    }

    /**
     * Create an instance of {@link ChangeTenderNameResponse }
     * 
     */
    public ChangeTenderNameResponse createChangeTenderNameResponse() {
        return new ChangeTenderNameResponse();
    }

    /**
     * Create an instance of {@link GetTender }
     * 
     */
    public GetTender createGetTender() {
        return new GetTender();
    }

    /**
     * Create an instance of {@link GetTenderResponse }
     * 
     */
    public GetTenderResponse createGetTenderResponse() {
        return new GetTenderResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeTenderName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangeTenderName }{@code >}
     */
    @XmlElementDecl(namespace = "http://soaphw/", name = "changeTenderName")
    public JAXBElement<ChangeTenderName> createChangeTenderName(ChangeTenderName value) {
        return new JAXBElement<ChangeTenderName>(_ChangeTenderName_QNAME, ChangeTenderName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeTenderNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChangeTenderNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soaphw/", name = "changeTenderNameResponse")
    public JAXBElement<ChangeTenderNameResponse> createChangeTenderNameResponse(ChangeTenderNameResponse value) {
        return new JAXBElement<ChangeTenderNameResponse>(_ChangeTenderNameResponse_QNAME, ChangeTenderNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTender }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTender }{@code >}
     */
    @XmlElementDecl(namespace = "http://soaphw/", name = "getTender")
    public JAXBElement<GetTender> createGetTender(GetTender value) {
        return new JAXBElement<GetTender>(_GetTender_QNAME, GetTender.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTenderResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTenderResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soaphw/", name = "getTenderResponse")
    public JAXBElement<GetTenderResponse> createGetTenderResponse(GetTenderResponse value) {
        return new JAXBElement<GetTenderResponse>(_GetTenderResponse_QNAME, GetTenderResponse.class, null, value);
    }

}
