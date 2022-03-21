package ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "CompanyWS", targetNamespace = "http://ws/")
public interface CompanyWS {
	@WebMethod(operationName = "getCompany", action = "urn:GetCompany")
	public String getCompany(String ICO);
	@WebMethod(operationName = "getCompanyByName", action = "urn:GetCompanyByName")
	public String getCompanyByName(String name);

}
