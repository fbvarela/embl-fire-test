package com.fire.test.controller;

import com.fire.test.domain.dto.PersonDTO;
import com.fire.test.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class PersonRestController {
    private static final Logger logger = LoggerFactory.getLogger(PersonRestController.class);

    private final PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value="/persons", produces = "application/vnd.emblfire.app-v1+json")
    public ResponseEntity<List<PersonDTO>> getPersons() {
        logger.debug("Get a list of Persons");
        List<PersonDTO> allPersons = personService.getAllPersons();

        return allPersons.size() > 0 ? new ResponseEntity<>(personService.getAllPersons(), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/persons/{id}", produces = "application/vnd.emblfire.app-v1+json")
    public ResponseEntity<PersonDTO> getPerson(@PathVariable Long id) {
        logger.debug("Get a Person with id: {}", id);
        Optional<PersonDTO> personById = personService.getPersonById(id);

        return personById.isPresent() ? new ResponseEntity<>(personById.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value="/persons", produces = "application/vnd.emblfire.app-v1+json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO newPerson) {
        logger.debug("Create a Person");
        PersonDTO response = personService.addPerson(newPerson);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(value="/persons/{id}", produces = "application/vnd.emblfire.app-v1+json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @RequestBody PersonDTO newPerson) {
        logger.debug("Update a Person with id: {}", id);
        PersonDTO response = personService.updatePerson(id, newPerson);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value="/persons/{id}", produces = "application/vnd.emblfire.app-v1+json")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        logger.debug("Delete a Person with id: {}", id);

        return personService.deletePerson(id) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
