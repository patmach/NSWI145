package soaphw;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import jakarta.jws.WebService;
import soaphw.CompanyWS;

@WebService(endpointInterface = "soaphw.CompanyWS")
public class CompanyWSImpl implements CompanyWS {
	
	public String getCompany(String ICO) {
		if (companiesMap.containsKey(ICO))
			return companiesMap.get(ICO).toString();
		else return "{\"ERROR\": \"Company with this ICO is not stored in the database.\"}";
	}
	
	
	public static HashMap<String, Company> companiesMap = new HashMap<String, Company>() {{
		put("45317054", new Company("Komerèní banka, a.s.", "45317054", 
        		new Address("Na pøíkopì", "969/33", "Praha")));
        put("63469511", new Company("NWTa.s.", "63469511", 
        		new Address("Nám. Míru", "1217", "Hulín")));
       
    }};


	
    
    
}

