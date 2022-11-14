package example.repository;

import org.springframework.stereotype.Repository;
import java.util.*;

import example.model.Dog;

@Repository("dogRepository")
public interface DogRepository{
  void save(Dog dog);
  void saveAll(Iterable<Dog> itr);
  Iterable<Dog> findAll();
}
