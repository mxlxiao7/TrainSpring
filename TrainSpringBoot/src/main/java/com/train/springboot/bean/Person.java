package com.train.springboot.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Person {

    private Long id;

    private String name;

    private Integer age;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String message;

    @JsonIgnore
    private String hobby;


    public Person() {

    }

    public Person(Long id, String name, Integer age, String message, String hobby) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.message = message;
        this.hobby = hobby;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", message='" + message + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
