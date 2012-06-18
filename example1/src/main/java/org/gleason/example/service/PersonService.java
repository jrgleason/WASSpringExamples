package org.gleason.example.service;
import org.gleason.example.model.Person;
import java.util.List;
import java.math.BigInteger;

public interface PersonService{
  public Person create(Person person);
  public Person read(BigInteger id);
  public List<Person> readAll();
  public Person update(Person person);
  public Person delete(BigInteger id);
}
