package com.service;

import com.model.StudentForm;

import java.util.List;



    public interface StudentService {
        List getAllStudents()throws Exception;
        void insertStudent(StudentForm s)throws Exception;
        StudentForm getStudent(Integer id)throws Exception;
        void updateStudent(StudentForm s)throws Exception;
        void deleteStudent(Integer id)throws Exception;
    }


