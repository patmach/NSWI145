package ws;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.jws.WebService;

import ws.CompanyWS;

@WebService(targetNamespace = "http://ws/", endpointInterface = "ws.CompanyWS", portName = "CompanyWSImplPort", serviceName = "CompanyWSImplService")
public class CompanyWSImpl implements CompanyWS {
	
	public String getCompany(String ICO) {
		if (companiesMap.containsKey(ICO))
			return companiesMap.get(ICO).toString();
		else return "{\"ERROR\": \"Company with this ICO is not stored in the database.\"}";
	}
	
	public String getCompanyByName(String name) {
		List<Company> companiesToReturn = new ArrayList();
		for(Company company : companiesMap.values()) {
			if (company.name.toLowerCase().contains(name.toLowerCase())) {
				companiesToReturn.add(company);
			}
		}
		return "{\"Companies\": [" + 
			companiesToReturn.stream().map(new Function<Company, String>() {
				public String apply(Company x) {
					return x.toString();
				}
			}).collect(Collectors.joining(","))
		+ "]}";
	}
	
	public static HashMap<String, Company> companiesMap = new HashMap<String, Company>() {{
		put("45317054", new Company("Komerèní banka, a.s.", "45317054", 
        		new Address("Na pøíkopì", "969/33", "Praha")));
        put("63469511", new Company("NWTa.s.", "63469511", 
        		new Address("Nám. Míru", "1217", "Hulín")));
       
    }};


	


	
    
    
}

