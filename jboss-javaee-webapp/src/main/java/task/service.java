package task;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class service {
	
	@PersistenceContext
    EntityManager manager;
	int result = 0;
	
	
	@POST
	@Path("calc")
	public Response calc(calculation1 c) {
		switch (c.getOperation()) {
			case "+":
				result = c.getNum1()+c.getNum2();
				break;
			case "-":
				result = c.getNum1()-c.getNum2();
				break;
			case "*":
				result = c.getNum1()*c.getNum2();
				break;
			case "/":
				result = c.getNum1()/c.getNum2();
				break;
			default:
				return Response.status(400).entity("Error").build() ;
		}
		
		manager.persist(c);
		return Response.ok().entity("result = " + result ).build() ;
	}
	
	@GET
	@Path("calculations")
	
	public Response getResult() {
		
		List <calculation1> l = manager.createQuery("SELECT operation FROM calculation operation" , calculation1.class).getResultList();
		
		return Response.ok().entity(l).build();
		
	}
	
}
