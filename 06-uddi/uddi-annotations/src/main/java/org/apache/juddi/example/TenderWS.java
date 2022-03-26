package org.apache.juddi.example;



import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public interface TenderWS {

	String getTender(@WebParam(name="ID")int ID);

}
