package br.com.example.jsftraining.bean;

import br.com.example.jsftraining.model.Student;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ValidatorTestBean implements Serializable {

    private Student student = new Student();

    public void save() {
        System.out.println("Saving");
        System.out.println(student.getEmail());
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
