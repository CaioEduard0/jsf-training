package br.com.example.jsftraining.bean;

import br.com.example.jsftraining.model.Student;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ConverterTestBean implements Serializable {

    private List<Student> students = Student.students();
    private Student student;

    public void save() {
        System.out.println("Saving");
        System.out.println(student);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
