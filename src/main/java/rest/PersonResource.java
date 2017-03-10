/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.Person;
import facade.Facade;
import facade.IPersonFacade;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utility.JSONConverter;

/**
 * REST Web Service
 *
 * @author Hannibal
 */
@Path("person")
public class PersonResource {

    private IPersonFacade f = new Facade();
    private JSONConverter c = new JSONConverter();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonResource
     */
    public PersonResource() {
        f.addEntityManagerFactory(Persistence.createEntityManagerFactory("pu"));

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() {

        List<Person> people = f.getPersons();
        return c.getJSONFromPerson(people);
    }
    
    /**
     * Retrieves representation of an instance of rest.PersonResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonById(@PathParam("id") int id) {

        Person person = f.getPerson(id);
        return c.getJSONFromPerson(person);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addPerson(String json) {

        Person person = c.getPersonFromJson(json);

        f.addPerson(person);

        return json;

    }

     @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String editPerson(String json) {

        Person p = f.editPerson(c.getPersonFromJson(json));

        return c.getJSONFromPerson(p);

    }

    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deletePerson(@PathParam("id") int id) {

        f.deletePerson(id);

        return "Successfully deleted person with id: " + id;

    }

}
