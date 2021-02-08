package com.fire.test.domain.entity;

import javax.persistence.*;

@Entity
@Table(name="Person")
public class Person {
    public Person() {}
    public Person(String first_name, String second_name, Integer age, String favourite_colour) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.age = age;
        this.favourite_colour = favourite_colour;
    }

     @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="first_name", length=50, nullable=false)
    private String first_name;

    @Column(name="second_name", length=50, nullable=false)
    private String second_name;

    @Column(name="age", nullable=false)
    private Integer age;

    @Column(name="favourite_colour", length=50, nullable=false)
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFavourite_colour() {
        return favourite_colour;
    }

    public void setFavourite_colour(String favourite_colour) {
        this.favourite_colour = favourite_colour;
    }

}
