package org.example;

import org.example.model.Student;
import org.example.service.Implement.StudentServiceImplement;
import org.example.service.StudentService;

import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static final Scanner scannerA = new Scanner(System.in);
    public static final Scanner scannerB = new Scanner(System.in);
    public static final Scanner scannerC = new Scanner(System.in);
    public static void main( String[] args ) throws SQLException {
        StudentService student = new StudentServiceImplement();
        while (true) {
            Student.print();
            int a = scannerA.nextInt();
            if (a == 1) {
                student.createStudentsTable();
            } else if (a == 2) {
                System.out.println("Name: ");
                String name = scannerB.nextLine();
                System.out.println("Age: ");
                byte age = scannerC.nextByte();
                student.saveStudent(name, age);
            } else if (a == 3) {
                student.dropStudentsTable();
            } else if (a == 4) {
                System.out.println("Id: ");
                int id = scannerA.nextInt();
                System.out.println(student.findById(id));
            } else if (a == 5) {
                System.out.println("Id: ");
                int id = scannerB.nextInt();
                student.deleteById(id);
            } else if (a == 6) {
                System.out.println(student.printAll());
            } else if (a  == 7) {
                System.out.println("Student id: ");
                long id = scannerA.nextLong();
                System.out.println("Name: ");
                String name = scannerC.nextLine();
                System.out.println("Age: ");
                byte age = scannerB.nextByte();
                student.updateStudent(id, new Student(name, age));
            } else if (a == 8) {
                student.cleanStudentsTable();
            } else {
                System.err.println("We don't have such kind of number");
            }
        }
    }
}
