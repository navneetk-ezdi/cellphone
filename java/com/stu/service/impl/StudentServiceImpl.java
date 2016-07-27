package com.stu.service.impl;

import com.stu.dao.StudentDao;
import com.stu.model.Student;
import com.stu.service.StudentService;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentdao;
     
 
 
    public void setStudentdao(StudentDao studentdao) {
        this.studentdao = studentdao;
    }
 
 
 
    public int save(Student student) {
        // TODO Auto-generated method stub
        return studentdao.save(student);
    }
 
}