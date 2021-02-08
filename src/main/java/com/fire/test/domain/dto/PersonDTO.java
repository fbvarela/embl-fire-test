package com.fire.test.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class PersonDTO {
    public PersonDTO() {}
    public PersonDTO(String first_name, String second_name, String age, String favourite_colour) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.age = age;
        this.favourite_colour = favourite_colour;
    }

    @JsonIgnore
    private Long id;

    private String first_name;

    private String second_name;

    private String age;

    private String favourite_colour;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFavourite_colour() {
        return favourite_colour;
    }

    public void setFavourite_colour(String favourite_colour) {
        this.favourite_colour = favourite_colour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
