import java.io.ByteArrayOutputStream;

import javax.xml.namespace.QName;

import jakarta.xml.soap.*;

public class CompanyClient {
	  public static void main(String[] args) throws Exception {
			SOAPConnectionFactory soapcf = SOAPConnectionFactory.newInstance();
			SOAPConnection soapc = soapcf.createConnection();
		
			MessageFactory mf = MessageFactory.newInstance();
			SOAPMessage soapm = mf.createMessage();
				
			SOAPPart soapp = soapm.getSOAPPart();
			SOAPEnvelope soape = soapp.getEnvelope();
			SOAPBody soapb = soape.getBody();
		
			soape.getHeader().detachNode();
			QName name = new QName("http://soaphw/", "getCompanyByName", "soap");
			SOAPElement soapel = soapb.addBodyElement(name);
			
			soapel.addChildElement(
			    new QName("", "arg0")).addTextNode("a.s.");
			String endpoint = "http://127.0.0.1:80/CompanyWS";
			SOAPMessage response = soapc.call(soapm, endpoint);
			SOAPBody responseBody = response.getSOAPBody();
			if (responseBody.hasFault()) {
			    System.out.println(responseBody.getFault().getFaultString()); 
			} else {				
			QName GetCompanyByNameResponseName = new QName("http://soaphw/", "getCompanyByNameResponse");
			QName GetCompanyByNameResultName = new QName("", "return");

			SOAPBodyElement GetCompanyByNameResponse = (SOAPBodyElement)
			       responseBody.getChildElements(GetCompanyByNameResponseName).next();
			SOAPBodyElement GetCompanyByNameResult = (SOAPBodyElement)
					GetCompanyByNameResponse.getChildElements(GetCompanyByNameResultName).next();

			System.out.println(GetCompanyByNameResult.getValue());
			}
			soapc.close();
	  }

}
