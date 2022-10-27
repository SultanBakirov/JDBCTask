package org.example.service;

import org.example.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    void createStudentsTable();

    void saveStudent(String name, byte age);

    void dropStudentsTable();

    Student findById(long id);

    void deleteById(long id);

    void cleanStudentsTable();

    List<Student> printAll();

    void updateStudent(long id, Student student) throws SQLException;
}
