package mlg.project.portfolio.controllers;

import mlg.project.portfolio.models.Person;
import mlg.project.portfolio.views.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;


    @GetMapping("/person")
    public List<Person> getAllPerson(){
        return this.personRepository.findAll();
    }

    @PostMapping("/post")
    public Person postPerson(@RequestBody Person person){
        return this.personRepository.save(person);
    }

    @PutMapping("/person")
    public Person updatePerson(
            @RequestBody Person person,
            @RequestParam(name = "id") Long id
    ){
        person.setId(id);
        return personRepository.save(person);
    }

}
