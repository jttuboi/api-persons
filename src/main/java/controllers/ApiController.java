package controllers;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import com.google.gson.Gson;

import models.Person;
import repositories.ApiRepository;
import repositories.IApiRepository;

@ApplicationPath("/api")
@Path("/persons")
public class ApiController extends Application {
	private IApiRepository apiRepository = new ApiRepository();
	private Gson gson = new Gson();
	
	// pega todos
	// http://localhost:8080/api-persons/api/persons
	@GET
	@Produces("application/json")
	public String getPersons() {
    	return gson.toJson(apiRepository.getPersons());
	}
	
	// pega para editar
	// http://localhost:8080/api-persons/api/persons/1
    @GET
    @Path("{id}")
    @Produces("application/json")
    public String getPerson(@PathParam("id") String id) {
    	return gson.toJson(apiRepository.getPerson(Long.valueOf(id)));
    }
	
//    // salva new
//    @POST
//    @Consumes("application/json")
//    public void savePerson(String person) {
//    	System.out.print(person);
//        Person p = gson.fromJson(person, Person.class);
//        apiRepository.savePerson(p);
//    }
//
//    
//    // atualiza
//    @PUT
//    @Consumes("application/json")
//    public void updatePerson(String person) {
//    	Person p = gson.fromJson(person, Person.class);
//    	apiRepository.savePerson(p);
//    }
//    
//    // serve para deletar
//    @DELETE
//    @Path("/{id}")
//    @Consumes("application/json")
//    public void removePerson(final @PathParam("id") String id) {
//    	apiRepository.deletePerson(Long.valueOf(id));
//    }
//    
//    // busca por query
//    @Path("/query/{query}")
//    @GET
//    @Consumes("application/json")
//    @Produces("application/json")
//    public String getPersonsByQuery(@QueryParam("query") String query) {
//        return gson.toJson(apiRepository.getPersonsByQuery(query));
//    }
}
