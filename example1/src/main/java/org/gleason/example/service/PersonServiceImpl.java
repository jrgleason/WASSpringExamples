package org.gleason.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.gleason.example.model.Person;
import org.gleason.example.repository.PersonRepository;
import java.util.List;
import java.math.BigInteger;

@Service
public class PersonServiceImpl implements PersonService{
   @Autowired
   private PersonRepository repo;
   
   public Person create(Person person) {
     return repo.save(person);
   }

   public Person read(BigInteger id) {
     return repo.findOne(id);
   }

   public List<Person> readAll() {
     return repo.findAll();
   }

   public Person update(Person person) {
     Person existingPerson = repo.findOne(person.getId());

     // Assign new values
     existingPerson.setName(person.getName());
     //existingPerson.setParticipants(person.getParticipants());
     //existingPerson.setDescription(person.getDescription());
     //existingPerson.setDate(person.getDate());
     return repo.save(existingPerson);
   } 

   public Person delete(BigInteger id) {
     repo.delete(id);
     return repo.findOne(id);
   }
}
