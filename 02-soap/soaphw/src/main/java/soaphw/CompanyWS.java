package soaphw;

import jakarta.jws.WebService;

@jakarta.jws.WebService
public interface CompanyWS {
    @jakarta.jws.WebMethod
	public String getCompany(String ICO);
    @jakarta.jws.WebMethod
	public String getCompanyByName(String name);

}
