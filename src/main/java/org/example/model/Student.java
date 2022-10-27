package org.example.model;

public class Student {
    private Long id;
    private String name;
    private Byte age;

    public Student() {
    }

    public Student(String name, Byte age) {
        this.name = name;
        this.age = age;
    }

    public static void print() {
        System.out.println("1: -> CREATE TABLE");
        System.out.println("2: -> SAVE STUDENT");
        System.out.println("3: -> DROP TABLE");
        System.out.println("4: -> FIND BY ID");
        System.out.println("5: -> DELETE BY ID");
        System.out.println("6: -> PRINT ALL");
        System.out.println("7: -> UPDATE ALL");
        System.out.println("8: -> CLEAN TABLE");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
