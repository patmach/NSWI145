package soaphw;
import jakarta.xml.ws.Endpoint;
import soaphw.TenderWSImpl;

public class Runner {
    public static void main(String[] args)
       {
        Endpoint.publish("http://127.0.0.1:8000/TenderWS", new TenderWSImpl());
        Endpoint.publish("http://127.0.0.1:80/CompanyWS", new CompanyWSImpl());
       }
}

