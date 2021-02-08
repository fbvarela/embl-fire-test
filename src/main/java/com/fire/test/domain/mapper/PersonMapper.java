package com.fire.test.domain.mapper;

import com.fire.test.domain.dto.PersonDTO;
import com.fire.test.domain.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonDTO PersonToDTO(Person entity) {
        return new PersonDTO(
                entity.getFirst_name(),
                entity.getSecond_name(),
                entity.getAge().toString(),
                entity.getFavourite_colour()
        );
    }

    public Person DTOtoPerson(PersonDTO dto) {

        Person person = new Person(
                dto.getFirst_name(),
                dto.getSecond_name(),
                Integer.parseInt(dto.getAge()),
                dto.getFavourite_colour()
        );

        return person;
    }

}
