package edu.e_g.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.e_g.dto.Person;
import edu.e_g.entity.PersonEntity;
import edu.e_g.repository.PersonRepository;
import edu.e_g.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    final PersonRepository personRepository;
    final ObjectMapper objectMapper;

    @Override
    public Person savePerson(Person person) {
        PersonEntity entity = personRepository.save(objectMapper.convertValue(person, PersonEntity.class));
        return objectMapper.convertValue(entity,Person.class);
    }

    @Override
    public List<Person> getAllPerson() {
        ArrayList<Person> all = new ArrayList<>();
        personRepository.findAll().forEach(entity->{
            all.add(objectMapper.convertValue(entity,Person.class));
        });
       return all;
    }

    @Override
    public Person searchPersonById(String id) {
        return objectMapper.convertValue(personRepository.findById(id),Person.class);
    }

//    @Override
//    public List<Person> SearchPersonByName(String name) {
//        ArrayList<Person> allName = new ArrayList<>();
//        personRepository.findPersonByName(name).forEach(entity->{
//            allName.add(objectMapper.convertValue(entity,Person.class));
//        });
//        return allName;
//    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }

    @Override
    public Person deletePerson(String id) {
         Person exitingPerson = objectMapper.convertValue(personRepository.findById(id),Person.class);
         personRepository.deleteById(id);
         return  exitingPerson;
    }
}
