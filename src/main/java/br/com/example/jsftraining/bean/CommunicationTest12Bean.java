package br.com.example.jsftraining.bean;

import br.com.example.jsftraining.model.Student;
import br.com.example.jsftraining.util.ApplicationMapUtil;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class CommunicationTest12Bean implements Serializable {

    private Student student;
    private Student student2 = new Student();

    public void init() {
        System.out.println("Enter");
        student = (Student) ApplicationMapUtil.getValue("student");
    }

    public String back() {
        System.out.println(student2.getName());
        System.out.println(student2.getSurname());
        return "communication11?faces-redirect=true";
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent2() {
        return student2;
    }

    public void setStudent2(Student student2) {
        this.student2 = student2;
    }
}
