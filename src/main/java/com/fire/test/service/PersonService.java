package com.fire.test.service;

import com.fire.test.domain.dto.PersonDTO;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<PersonDTO> getAllPersons();
    Optional<PersonDTO> getPersonById(Long id);
    PersonDTO addPerson(PersonDTO person);
    PersonDTO updatePerson(Long id, PersonDTO personDTO);
    boolean deletePerson(Long id);
}
