package org.example.dao.Implement;

import org.example.configuration.DbConnection;
import org.example.dao.StudentDao;
import org.example.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImplement implements StudentDao {

    public final Connection connection;

    public StudentDaoImplement() throws SQLException {
        connection = new DbConnection().getConnection();
    }

    public void createStudentsTable() {
        String query = """
                create table students(
                id serial primary key,
                name varchar(50) not null,
                age bigint not null
                );
                """;
        try(Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("Table students created successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveStudent(String name, byte age) {
        String query = """
                insert into students(name, age) values(?, ?);
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.execute();
            System.out.println("Students with name " + name + " added successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropStudentsTable() {
        String query = """
                drop table students;
                """;
        try(Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("Table students dropped successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Student findById(long id) {
        String query = """
                select * from students where id = ?;
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.err.println("We don't have such kind of id!");
            }
            Student student = new Student();
            student.setId(resultSet.getLong(1));
            student.setName(resultSet.getString(2));
            student.setAge(resultSet.getByte(3));
            return student;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void deleteById(long id) {
        String query = """
                delete from students where id = ?;
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Id " + id + " removed from table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cleanStudentsTable() {
        String query = """
                truncate table students;
                """;
        try(Statement statement = connection.createStatement()) {
            statement.execute(query);
            System.out.println("Table students cleaned successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> printAll() {
        String query = "select * from students";
        ArrayList<Student> students = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong(1));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getByte("age"));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void updateStudent(long id, Student student) {
        String query = "update students set name = ?, age = ? where id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setByte(2, student.getAge());
            preparedStatement.setLong(3, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
