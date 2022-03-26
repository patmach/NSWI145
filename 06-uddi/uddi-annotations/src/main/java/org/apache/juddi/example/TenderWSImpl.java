package org.apache.juddi.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import org.apache.juddi.v3.annotations.UDDIService;
import org.apache.juddi.v3.annotations.UDDIServiceBinding;


@UDDIService(
		businessKey="uddi:www.mycompany.com:business",
		serviceKey="uddi:${keyDomain}:services-tender${department}", 
		description = "Get tender test service")
@UDDIServiceBinding(
		bindingKey="uddi:${keyDomain}:${serverName}-${serverPort}-tender${department}-wsdl",
	    description="WSDL endpoint for the tender${department} Service. This service is used for "
				  + "testing the jUDDI annotation functionality",
	    accessPointType="wsdlDeployment",
	    accessPoint="http://${serverName}:${serverPort}/uddi-annotations/services/tenderws?wsdl")
@WebService(
		endpointInterface = "org.apache.juddi.example.TenderWS",
        serviceName = "GetTender")
public class TenderWSImpl implements TenderWS {
	
	public String getTender(int ID) {
		if (tendersMap.containsKey(ID))
			return tendersMap.get(ID).toString();
		else return "{\"ERROR\": \"Tender with this ID is not stored in the database.\"}";
    }
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
	
	
	public static HashMap<Integer, Tender> tendersMap = new HashMap<Integer, Tender>() {{
		try {
        put(15001, new Tender("Nákup tiskárny pro účetní oddělení", 8000, formatter.parse("31/12/2022")));
        put(15002, new Tender("Oprava fasády budovy v Jihlavě", 100000, formatter.parse("15/5/2023")));
		}
		catch (java.text.ParseException e) {
            e.printStackTrace();
        }
       
    }};
    
    
}