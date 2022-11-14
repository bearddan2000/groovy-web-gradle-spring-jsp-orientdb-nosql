package example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
import java.util.*;

import example.model.Dog;
import example.repository.*;

@RestController
public class DogRestController {

	@Autowired
	private DogRepositoryImpl dogRepository;

	@PostConstruct
	private void init()
	{
	    List<Dog> list = new ArrayList<Dog>();
			list << new Dog(1L, "Am Bulldog", "White");
			list << new Dog(2L, "Foxhound", "Red");
			list << new Dog(3L, "Gr Shepard", "Black");

			list.forEach(dog -> {dogRepository.save(dog);});
	}

	@RequestMapping(path="/dogs", method=RequestMethod.GET)
	public Iterable<Dog> getAllDogs(){
		return dogRepository.findAll();
	}
}
