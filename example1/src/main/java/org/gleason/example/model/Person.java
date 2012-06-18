package org.gleason.example.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigInteger;

@Document
public class Person{
  @Id
  private BigInteger id;
  private String name;
  
  public BigInteger getId(){
    return id;
  }
  public void setId(BigInteger id){
    this.id = id;
  }
  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }
  @Override
  public String toString(){
    return name;
  }
}
