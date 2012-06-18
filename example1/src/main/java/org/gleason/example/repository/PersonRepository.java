package org.gleason.example.repository;
import org.gleason.example.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.math.BigInteger;

public interface PersonRepository extends MongoRepository<Person, BigInteger> {
}
