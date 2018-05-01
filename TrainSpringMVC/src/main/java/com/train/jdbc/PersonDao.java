package com.train.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("personDao")
public class PersonDao implements IPersonDao {

    @Resource
    private JdbcTemplate template;

    public PersonDao(JdbcTemplate template){
        this.template = template;
    }

    public int create(String name, Integer age) {
        String SQL = "insert into person (name, age) values (?, ?)";
        int update = template.update(SQL, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
        return update;
    }

    public Person getPerson(Integer id) {
        String SQL = "select * from person where id = ?";
        Person p = template.queryForObject(SQL, new Object[]{id}, new PersonMapper());
        return p;
    }

    public List<Person> getAll() {
        String SQL = "select * from person";
        List<Person> personList = template.query(SQL, new PersonMapper());
        return personList;
    }

    public void delete(Integer id) {
        String SQL = "delete from person where id = ?";
        template.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
        return;
    }

    public void update(Integer id, Integer age) {
        String SQL = "update person set age = ? where id = ?";
        template.update(SQL, age, id);
        System.out.println("Updated Record with ID = " + id);
        return;
    }
}
