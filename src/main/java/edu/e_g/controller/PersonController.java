package edu.e_g.controller;

import edu.e_g.dto.Person;
import edu.e_g.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@CrossOrigin
@RequiredArgsConstructor
public class PersonController {
    final PersonService personService;

    @PostMapping("/save")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        try {
            return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> all = personService.getAllPerson();
        if (all.isEmpty()){
            new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
        //HashSet Danna
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Person> searchPersonById(@PathVariable String id){
        Person SearchById = personService.searchPersonById(id);
        if(SearchById != null){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/search/{name}")
//    public ResponseEntity<List<Person>> searchPersonByName(@PathVariable String name) {
//        List<Person> SearchByName = personService.SearchPersonByName(name);
//        if (SearchByName.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(SearchByName, HttpStatus.OK);
//    }


    @PutMapping("/put")
    public ResponseEntity<Person> updatePerson(Person person){
        try{
            return new ResponseEntity<>(personService.updatePerson(person),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable String id){
        return new ResponseEntity<>(personService.deletePerson(id),HttpStatus.ACCEPTED);
    }


}
