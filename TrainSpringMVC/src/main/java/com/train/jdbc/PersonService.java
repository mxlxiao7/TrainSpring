package com.train.jdbc;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@Service("personService")
public class PersonService {

    @Resource(name = "personDao")
    private PersonDao dao;

    public List<Person> getAllPerson() {
        return dao.getAll();
    }

    public int addPerson(Person p) {
       return dao.create(p.getName(), p.getAge());
    }
}
