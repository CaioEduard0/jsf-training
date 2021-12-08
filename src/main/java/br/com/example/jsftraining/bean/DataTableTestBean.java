package br.com.example.jsftraining.bean;

import br.com.example.jsftraining.model.Student;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Named
@ViewScoped
public class DataTableTestBean implements Serializable {

    private List<Student> students = Student.students();
    private Set<Student> studentsSet = new HashSet<>(Student.students());
    private List<Student> studentsLinkedList = new LinkedList<>(Student.students());
    private Map<String, Student> studentsMap = new HashMap<>();

    public void init() {
        studentsMap.put("Student 1", new Student(1,"Ikki", "Fenix", 10));
        studentsMap.put("Student 2", new Student(2,"Shiryu", "Dragon", 10));
        studentsMap.put("Student 3", new Student(3,"Seiya", "Pegasus", 10));
    }

    public void orderByName(String order) {
        if (order.equals("asc")) {
            students.sort(Comparator.comparing(Student::getName));
        } else {
            students.sort(Comparator.comparing(Student::getName).reversed());
        }
    }

    public void orderBySurname(String order) {
        if (order.equals("asc")) {
            students.sort(Comparator.comparing(Student::getSurname));
        } else {
            students.sort(Comparator.comparing(Student::getSurname).reversed());
        }
    }

    public void delete(Student student) {
        students.remove(student);
    }

    public void update(Student student) {
        student.setEditing(true);
    }

    public void save() {
        students.forEach(student -> {
            if (student.isEditing()) {
                System.out.println(student);
            }
            student.setEditing(false);
        });
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Set<Student> getStudentsSet() {
        return studentsSet;
    }

    public void setStudentsSet(Set<Student> studentsSet) {
        this.studentsSet = studentsSet;
    }

    public List<Student> getStudentsLinkedList() {
        return studentsLinkedList;
    }

    public void setStudentsLinkedList(List<Student> studentsLinkedList) {
        this.studentsLinkedList = studentsLinkedList;
    }

    public Map<String, Student> getStudentsMap() {
        return studentsMap;
    }

    public void setStudentsMap(Map<String, Student> studentsMap) {
        this.studentsMap = studentsMap;
    }
}
