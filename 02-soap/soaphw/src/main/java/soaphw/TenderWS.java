package soaphw;

import java.util.Date;

import jakarta.jws.WebService;

@jakarta.jws.WebService
public interface TenderWS {
    @jakarta.jws.WebMethod
	public String getTender(int ID);
    @jakarta.jws.WebMethod
	public String changeTenderName(int ID, String newName);

}
