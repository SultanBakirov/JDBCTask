package org.example.service.Implement;

import org.example.dao.Implement.StudentDaoImplement;
import org.example.dao.StudentDao;
import org.example.model.Student;
import org.example.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImplement implements StudentService {

    public StudentServiceImplement() throws SQLException {
    }

    StudentDao dao = new StudentDaoImplement();

    public void createStudentsTable() {
        dao.createStudentsTable();
    }

    public void saveStudent(String name, byte age) {
        dao.saveStudent(name, age);
    }

    public void dropStudentsTable() {
        dao.dropStudentsTable();
    }

    public Student findById(long id) {
        return dao.findById(id);
    }

    public void deleteById(long id) {
        dao.deleteById(id);
    }

    public void cleanStudentsTable() {
        dao.cleanStudentsTable();
    }

    public List<Student> printAll() {
        return dao.printAll();
    }

    public void updateStudent(long id, Student student) throws SQLException {
        dao.updateStudent(id,student);
    }
}
