package com.dao;

import com.model.StudentForm;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDAO2")
public class StudentDAO2 {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insertStudent(StudentForm student) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public StudentForm getStudent(int id) {
        Session session = sessionFactory.openSession();
        StudentForm student = null;
        try {
            student = (StudentForm) session.get(StudentForm.class, id);
        } finally {
            session.close();
        }
        return student;
    }

    @SuppressWarnings("unchecked")
    public List<StudentForm> getAllStudent() {
        Session session = sessionFactory.openSession();
        List<StudentForm> list = null;
        try {
            Query query = session.createQuery("from StudentForm");
            list = query.list();
        } finally {
            session.close();
        }
        return list;
    }

    public void updateStudent(StudentForm s) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(s);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteStudent(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            StudentForm s = (StudentForm) session.get(StudentForm.class, id);
            if (s != null) {
                session.delete(s);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
