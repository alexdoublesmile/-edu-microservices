package edu.joyful.micro.controller;

import edu.joyful.micro.domain.Person;
import edu.joyful.micro.domain.dto.PersonDto;
import edu.joyful.micro.repository.PersonRepository;
import edu.joyful.micro.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping
    public List<Person> findPersons() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

//    @GetMapping("/{id}")
//    public PersonDto findPersonWithNotes(@PathVariable Long id) {
//        return personService.findPersonWithNotes(id);
//    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable Long id) {
        return personRepository.findById(id).orElseThrow();
    }
}
