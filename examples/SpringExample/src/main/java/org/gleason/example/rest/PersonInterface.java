package org.gleason.example.rest;
import javax.ws.rs.*;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import org.gleason.example.model.Person;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/person")
@Component
public class PersonInterface{
  //public void addPerson(@Context HttpServletResponse servletResponse)
  @POST
  @Consumes("application/json")
  @Produces(MediaType.TEXT_HTML)
  public void addPerson() 
  throws IOException{
    System.out.println("This is adding a user");
    //servletResponse.sendRedirect("www.google.com");
  }
//  @GET
//  @Path("/{personId}")
//  @Produces("application/json")
//  public List<Person> findMemberByPhoneNumber(
//    @PathParam("phoneId") int phoneNumber){
//    System.out.println("This is adding a user");
//    List<Person> persons = new ArrayList<Person>();
//    Person newPerson = new Person();
//    newPerson.setId(1);
//    newPerson.setName("Jackie");
//    persons.add(newPerson);
//    return persons;
//  }

  @GET
  @Path("/{personId}")
  @Produces("application/json")
  public String findMemberByPhoneNumber(
    @PathParam("phoneId") int phoneNumber){
    System.out.println("This is adding a user");
    List<Person> persons = new ArrayList<Person>();
    Person newPerson = new Person();
    newPerson.setId(1);
    newPerson.setName("Jackie");
    persons.add(newPerson);
    return "Test";
  }

}

