package com.train.transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository(value = "teachreDao")
public class TeacherDao {

    private static final Logger logger = LoggerFactory.getLogger(TeacherDao.class);

    @Resource
    private JdbcTemplate template;

    public void TeachreDAO(JdbcTemplate template) {
        this.template = template;
    }

    public void create(String name, Integer age, Integer marks, Integer year) {
        try {
            String SQL1 = "insert into teacher (name, age) values (?, ?)";
            template.update(SQL1, name, age);
            String SQL2 = "select max(id) from teacher";


            int sid = template.queryForObject(SQL2, Integer.class);
            String SQL3 = "insert into marks(sid, marks, year) values (?, ?, ?)";
            template.update(SQL3, sid, marks, year);
            logger.debug("Created Name = " + name + ", Age = " + age);

            // 如果这里抛出这个异常，在有事务管理的情况下是不会存储成功
//            throw new RuntimeException("simulate Error condition");
        } catch (DataAccessException e) {
            logger.error("[rror in creating record, rolling back] - ", e);
            throw e;
        }
    }

    public List<Teacher> listTeachers() {
        String SQL = "select * from teacher, marks where teacher.id=marks.sid";
        List<Teacher> marks = template.query(SQL, new TeacherMapper());
        return marks;
    }
}
