package rsvier;


import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import dao.ArtikelDao;
import pojo.Artikel;

@Path("Artikels")
public class ArtikelService {

	@EJB
	private ArtikelDao artikelEJB;
	
	@Inject
	private Logger logger;

	@Path("")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveArtikel(Artikel artikel) {
		try {
			artikel = artikelEJB.insert(artikel);
			return Response.ok(artikel).build();
		}
		catch (Exception ex) {
			logger.error("Error saving information", ex);
		}
		return Response.serverError().build();
	}
	
	

}
