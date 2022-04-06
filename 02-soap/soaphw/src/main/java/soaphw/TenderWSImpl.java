package soaphw;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.jws.WebService;
import soaphw.TenderWS;

@WebService(endpointInterface = "soaphw.TenderWS")
public class TenderWSImpl implements TenderWS {
	
	public String getTender(int ID) {
		if (tendersMap.containsKey(ID))
			return tendersMap.get(ID).toString();
		else return "{\"ERROR\": \"Tender with this ID is not stored in the database.\"}";
    }
	
	public String changeTenderName(int ID, String newName) {
		try {
			if (tendersMap.containsKey(ID)){
				tendersMap.get(ID).name += " (" + newName + ")";
				return "{\"CONFIRM\": \"Realization of tender ("+ID+") was changed\"}";
			}
			else return "{\"ERROR\": \"Tender with this ID is not stored in the database.\"}";
		}
		catch (Exception e) {
			return "{\"ERROR\": \"The name value is not in the right format.\"}";
		}
	}
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
	
	
	public static HashMap<Integer, Tender> tendersMap = new HashMap<Integer, Tender>() {{
		try {
        put(15001, new Tender("Nákup tiskárny pro úèetní oddìlení", 8000, formatter.parse("31/12/2022")));
        put(15002, new Tender("Oprava fasády budovy v Jihlavì", 100000, formatter.parse("15/5/2023")));
		}
		catch (java.text.ParseException e) {
            e.printStackTrace();
        }
       
    }};
    
    
}

