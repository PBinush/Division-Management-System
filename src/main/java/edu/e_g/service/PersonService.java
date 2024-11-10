package edu.e_g.service;

import edu.e_g.dto.Person;

import java.util.List;

public interface PersonService {
    Person savePerson(Person person);

    List<Person> getAllPerson();

    Person searchPersonById(String id);

//    List<Person> SearchPersonByName(String name);

    Person updatePerson(Person person);

    Person deletePerson(String id);
}
