package br.com.example.jsftraining.model;

import br.com.example.jsftraining.model.enums.Shift;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Student implements Serializable {

    private Integer id;
    private String name = "Caio";
    private String surname = "Eduardo";
    private double grade1 = 20;
    private double grade2;
    private double grade3 = 10;
    private Shift shift = Shift.MORNING;
    private String email;
    private transient boolean editing;

    public Student() {
    }

    public Student(String name, String surname, double grade1) {
        this.name = name;
        this.surname = surname;
        this.grade1 = grade1;
    }

    public Student(Integer id, String name, String surname, double grade1) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade1 = grade1;
    }

    public static List<Student> students() {
        return new ArrayList<>(asList(new Student(1,"Ikki", "Fenix", 10),
                new Student(2,"Shiryu", "Dragon", 10),
                new Student(2,"Shiryu", "Dragon", 10),
                new Student(3,"Seiya", "Pegasus", 10)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getGrade1() {
        return grade1;
    }

    public void setGrade1(double grade1) {
        this.grade1 = grade1;
    }

    public double getGrade2() {
        return grade2;
    }

    public void setGrade2(double grade2) {
        this.grade2 = grade2;
    }

    public double getGrade3() {
        return grade3;
    }

    public void setGrade3(double grade3) {
        this.grade3 = grade3;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", shift=" + shift +
                ", email='" + email + '\'' +
                '}';
    }
}
