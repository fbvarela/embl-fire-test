package com.fire.test.service;

import com.fire.test.domain.dto.PersonDTO;
import com.fire.test.domain.entity.Person;
import com.fire.test.domain.mapper.PersonMapper;
import com.fire.test.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    final PersonMapper mapper;
    final PersonRepository repository;

    public PersonServiceImpl(PersonMapper mapper, PersonRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        return repository.findAll().stream()
                .map(person -> mapper.PersonToDTO(person))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PersonDTO> getPersonById(Long id) {
        return repository
                .findById(id)
                .map(entity -> Optional.of(mapper.PersonToDTO(entity)))
                .orElse(Optional.empty());
    }

    @Override
    public PersonDTO addPerson(PersonDTO personDto) {
        Person newPerson = mapper.DTOtoPerson(personDto);
        return mapper.PersonToDTO(repository.save(newPerson));
    }

    @Override
    public PersonDTO updatePerson(Long id, PersonDTO newPerson) {
        return mapper.PersonToDTO(repository.findById(id)
                .map(person -> {
                        person.setFirst_name(newPerson.getFirst_name());
                        person.setSecond_name(newPerson.getSecond_name());
                        person.setAge(Integer.parseInt(newPerson.getAge()));
                        person.setFavourite_colour(newPerson.getFavourite_colour());
                        return repository.save(person);
                    })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return repository.save(mapper.DTOtoPerson(newPerson));
                }));
    }

    @Override
    public boolean deletePerson(Long id) {
        return repository
                .findById(id)
                .map(entity -> {
                    repository.deleteById(id);
                    return true;
                })
                .orElse(false);


    }
}
