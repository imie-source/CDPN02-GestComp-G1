package fr.skills.service.REST;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.skills.serviceEJB.impl.PersonDTO;
import fr.skills.serviceEJB.inter.IPersonService;

// The Java class will be hosted at the URI path "/helloworld"

@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class PersonResource {
    
	@EJB
	private IPersonService personService;
	
	@GET
	@Path("/member")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }
    
	@GET
	@Path("/member/{id}")
    public Response getMemberById(@PathParam("id") Integer id) {
		PersonDTO member = personService.findById(id);
        return Response.ok(member).build();
    }
	
	@POST
	@Path("/member/create/{}")
	public Response createMember(PersonDTO member){
		PersonDTO res = personService.createPerson(member);	
		return Response.ok(res).build();
	}
}