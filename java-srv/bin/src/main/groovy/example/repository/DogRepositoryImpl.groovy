package example.repository;

import com.orientechnologies.orient.core.db.ODatabaseRecordThreadLocal;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import example.model.Dog;

@Repository
public class DogRepositoryImpl implements DogRepository {

  @Autowired
  ODatabaseDocumentTx orientDBfactory;

  @Override
  public void save(Dog dog){
    ODatabaseRecordThreadLocal.instance().set(orientDBfactory);

    // The Class will be automatically created into Orient Studio
    ODocument doc = new ODocument(Dog.class.getSimpleName()); // The entity name is provided as parameter
    doc.field("id", dog.getId());
    doc.field("breed", dog.getBreed());
    doc.field("color", dog.getColor());
    doc.save();
  }

  @Override
  public void saveAll(Iterable<Dog> itr)
  {
    itr.forEach(dog -> { this.save(dog); });
  }

  @Override
  public Iterable<Dog> findAll()
  {
    ODatabaseRecordThreadLocal.instance().set(orientDBfactory);

    // List of resulting article
    List<Dog> dogs = new ArrayList<Dog>();

    // Load all the articles
    orientDBfactory.browseClass("Dog").forEach( dogDocument -> {
        Dog dog = Dog.fromODocument(dogDocument);
        dogs.add(dog);
    });

    Iterator<Dog> dogItr = dogs.iterator();
    return StreamSupport
      .stream(
        Spliterators.spliteratorUnknownSize(
          dogItr, 0), false
        ).collect(Collectors.toList());
  }
}
