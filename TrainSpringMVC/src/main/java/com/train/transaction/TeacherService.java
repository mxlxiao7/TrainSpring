package com.train.transaction;

import com.train.Constants;
import com.train.log.SystemServiceLog;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@Service("teacherService")
public class TeacherService {

    @Resource(name = "teachreDao")
    private TeacherDao dao;

    @SystemServiceLog(description = Constants.ADMIN_SAVE_OPTIONS, tableType = Constants.ADMIM_TABLE_TYPE)
    public List<Teacher> getAllTeacher() {
        return dao.listTeachers();
    }

    @SystemServiceLog(description = Constants.ADMIN_ADD_OPTIONS, tableType = Constants.ADMIM_TABLE_TYPE)
    public void addTeacher(Teacher teacher) {
        dao.create(teacher.getName(), teacher.getAge(), teacher.getMarks(), teacher.getYear());
    }
}
