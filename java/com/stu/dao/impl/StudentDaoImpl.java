package com.stu.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.stu.dao.StudentDao;
import com.stu.model.Student;

public class StudentDaoImpl implements StudentDao {
    private HibernateTemplate hibernatetemplate;
    public void setHibernatetemplate(HibernateTemplate hibernatetemplate) {
        this.hibernatetemplate = hibernatetemplate;
    }
 

    public int save(Student student) {
         
        Integer i = (Integer)hibernatetemplate.save(student);
        return i;
    }
 
}