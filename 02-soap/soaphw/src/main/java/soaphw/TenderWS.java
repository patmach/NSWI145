package soaphw;

import jakarta.jws.WebService;

@jakarta.jws.WebService
public interface TenderWS {
    @jakarta.jws.WebMethod
	public String getTender(int ID);

}
