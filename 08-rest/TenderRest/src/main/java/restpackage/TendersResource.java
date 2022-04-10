package restpackage;

import java.text.SimpleDateFormat;
import java.util.*;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.xml.bind.JAXBElement;

@Path("/tenders")
public class TendersResource {
	private static Map<Integer, Tender> tenders = new HashMap<Integer, Tender>();
    
	@Context
	UriInfo uriInfo;

	public TendersResource() {
	    tenders.put(15001, new Tender(15001, "Nákup tiskárny pro úèetní oddìlení", 8000));
	    tenders.put(15002, new Tender(15002, "Oprava fasády budovy v Jihlavì", 100000));
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Tender> getContacts() {
	    List<Tender> returnedTenders = new ArrayList<Tender>();
	    returnedTenders.addAll( tenders.values() );
	    return returnedTenders;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{tender}")
	public Tender getTender(
	     	@PathParam("tender") String tenderID) {
		try {
			int ID = Integer.parseInt(tenderID);
		
			if(!tenders.containsKey(ID))
				return null;
			return tenders.get(ID);
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{tender}")
	    public Response putTender(
	        	@PathParam("tender") String tenderID, JAXBElement<Tender> tender) {
		Tender t = tender.getValue();
		Response res;
		if (!String.valueOf(t.getID()).equals(tenderID)) {
			res = Response.status(Response.Status.CONFLICT)
			         .entity("Numbers don't match").build();			
		}
		else {
			
			if(!tenders.containsKey(t.getID())) {
				tenders.put(t.getID(), t);
				res = Response.created(uriInfo.getAbsolutePath()).build();
			}
			else {
				
				res = Response.status(204).entity("Tender replaced.").build();
			}
			tenders.put(t.getID(), t);
		}
		return res;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{tender}")
	    public Response postTender(
	        	@PathParam("tender") String tenderID, JAXBElement<Tender> tender) {
		Tender t = tender.getValue();
		Response res;
		if (!String.valueOf(t.getID()).equals(tenderID)) {
			res = Response.status(Response.Status.CONFLICT)
			         .entity("Numbers don't match").build();			
		}
		else {
			if(!tenders.containsKey(t.getID())) {
				tenders.put(t.getID(), t);
				res = Response.created(uriInfo.getAbsolutePath()).build();
			}
			else {
				res = Response.status(Response.Status.CONFLICT)
				         .entity("Tender with this ID already exists").build();	
			}
		}
		return res;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{tender}")
	public Response deleteTender(
	     	@PathParam("tender") String tenderID) {
		Response res;
		try {
			int ID = Integer.parseInt(tenderID);
		
			if(!tenders.containsKey(ID)) {
				res = Response.status(Response.Status.CONFLICT)
				         .entity("Tender with this ID is not in the database").build();	
			}
			else {
				tenders.remove(ID);
				res =  Response.status(Response.Status.ACCEPTED)
				         .entity("Tender was deleted from the database.").build();	
			}
		}
		catch(NumberFormatException e) {
			res = Response.status(Response.Status.FORBIDDEN)
			         .entity("ID has to be integer!").build();	
			return res;
		}
		return res;
		
	}

}
