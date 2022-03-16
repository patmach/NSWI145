package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import org.json.*;

import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.SOAPBody;
import jakarta.xml.soap.SOAPBodyElement;
import jakarta.xml.soap.SOAPConnection;
import jakarta.xml.soap.SOAPConnectionFactory;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPMessage;

/**
 * Servlet implementation class CompanyServlet
 */
@WebServlet("/CompanyServlet")
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SOAPConnectionFactory soapcf = SOAPConnectionFactory.newInstance();
			SOAPConnection soapc = soapcf.createConnection();
			MessageFactory mf = MessageFactory.newInstance();
			SOAPMessage soapm = mf.createMessage(null, request.getInputStream());
			QName maxRecordsHeaderName = new QName("http://localhost:8080/CompanyDWP/CompanyServlet", "MaxRecords");
			var header = soapm.getSOAPHeader();
			var allElementsInHeader = header.extractAllHeaderElements();
			var maxRecordsHeader = allElementsInHeader.next();
			int maxRecords=Integer.MAX_VALUE;
			if (maxRecordsHeader!=null) {
				var attribute = maxRecordsHeader.getAttribute("max");
				
				maxRecords = Integer.parseInt(attribute);
			}
			String endpoint = "http://127.0.0.1:80/CompanyWS";
			soapm.getSOAPHeader().detachNode();
			SOAPMessage calcResponse = soapc.call(soapm, endpoint);
			soapc.close();
			
			SOAPBody responseBody = calcResponse.getSOAPBody();			
			QName GetCompanyByNameResponseName = new QName("http://soaphw/", "getCompanyByNameResponse");
			QName GetCompanyByNameResultName = new QName("", "return");
			SOAPBodyElement GetCompanyByNameResponse = (SOAPBodyElement)
			       responseBody.getChildElements(GetCompanyByNameResponseName).next();
			SOAPBodyElement GetCompanyByNameResult = (SOAPBodyElement)
			       GetCompanyByNameResponse.getChildElements(GetCompanyByNameResultName).next();
			
			
			JSONArray list = new JSONArray();     
			org.json.JSONObject jsonResponse = new JSONObject(GetCompanyByNameResult.getValue());
			JSONArray jsonArray = new JSONArray(jsonResponse.getJSONArray("Companies")); 
			int len = jsonArray.length();
			if (jsonArray != null) { 
			   for (int i=0;(i<maxRecords) && (i< jsonArray.length()) ;i++)
			   { 
		            list.put(jsonArray.get(i));			        
			   } 
			}
			jsonResponse.remove("Companies");
			jsonResponse.append("Companies", list);
			
			GetCompanyByNameResult.setValue(jsonResponse.toString());
			
			QName maxRecordsResponseHeaderName = new QName("http://localhost:8080/CompanyDWP/CompanyServlet", "MaxRecordsResponse");
			SOAPEnvelope soape = calcResponse.getSOAPPart().getEnvelope();
			header = soape.getHeader();
			if(header==null) {
				soape.addHeader();
				header = soape.getHeader();
			}
			header.addHeaderElement(maxRecordsResponseHeaderName).addTextNode("Maximum number of returned records set to " + maxRecords);
			response.setContentType("text/xml");
			calcResponse.writeTo(response.getOutputStream());
			response.getOutputStream().flush();
			
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
