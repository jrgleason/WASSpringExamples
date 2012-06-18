package org.gleason.example.rest;
import javax.ws.rs.*;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import org.gleason.example.model.Person;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.gleason.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigInteger;

@Path("/person")
@Component
public class PersonInterface{
  @Autowired
  private PersonService service;

  @GET
  @Path("/{personId}")
  @Produces("application/json")
  public String findMemberById(
    @PathParam("personId") BigInteger id){
    Person newPerson = service.read(id);
    if(newPerson != null){
      return newPerson.toString();
    }
    else{
      return "Person Not Found";
    }
  }
  @GET
  @Path("/add")
  @Produces("application/json")
  public String createSample(){
    Person newPerson = new Person();
    newPerson.setId(new BigInteger("3"));
    newPerson.setName("Not Jackie");
    service.create(newPerson);
    return "Person Saved";
  }

}

