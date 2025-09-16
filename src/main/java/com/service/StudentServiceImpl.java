package com.service;

import com.dao.StudentDAO2;
import com.model.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService{
  @Autowired
    private StudentDAO2 studentDAO;

    public void setStudentDAO(StudentDAO2 studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void insertStudent(StudentForm s) throws Exception {
        studentDAO.insertStudent(s);
    }

    @Override
    public List getAllStudents() throws Exception {
        return studentDAO.getAllStudent();
    }

    @Override
    public StudentForm getStudent(Integer id) throws Exception {
        return studentDAO.getStudent(id);
    }

    @Override
    public void updateStudent(StudentForm s) throws Exception {
        studentDAO.updateStudent(s);
    }

    @Override
    public void deleteStudent(Integer id) throws Exception {
        studentDAO.deleteStudent(id);
    }
}
