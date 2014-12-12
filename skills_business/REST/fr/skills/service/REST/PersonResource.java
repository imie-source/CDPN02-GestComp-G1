package fr.skills.service.REST;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.skills.serviceEJB.impl.PersonDTO;
import fr.skills.serviceEJB.inter.IPersonService;

@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Path("/member")
@Stateless
public class PersonResource {
    
	@EJB
	private IPersonService personService;
	
	@GET
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }
    
	@GET
	@Path("/{id}")
    public Response getMemberById(@PathParam("id") Integer id) {
		PersonDTO p = new PersonDTO();
		p.setId(id);
		p = personService.findById(p);
        return Response.ok(p).build();
    }
	
	@POST
	public Response createMember(PersonDTO p){
		PersonDTO res = personService.createPerson(p);	
		return Response.ok(res).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteMember(@PathParam("id") Integer id){
		PersonDTO p = new PersonDTO();
		p.setId(id);
		PersonDTO member = personService.remove(p);
		return Response.ok(member).build();
	}
	
	@PUT
	@Path("/{id}")
	public Response updateMember(@PathParam("id") Integer id){
		PersonDTO p = new PersonDTO();
		p.setId(id);
		PersonDTO member = personService.update(p);
		return Response.ok(member).build();
	}
}