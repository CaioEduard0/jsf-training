package br.com.example.jsftraining.bean;

import br.com.example.jsftraining.model.Student;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CommunicationTest4Bean implements Serializable {

    private String buttonName = "Name of bean button";
    private Student student = new Student();

    public void execute(ActionEvent event) {
        String name = (String) event.getComponent().getAttributes().get("name");
        String adjective = (String) event.getComponent().getAttributes().get("adjective");
        Student student = (Student) event.getComponent().getAttributes().get("student");
        String test = (String) event.getComponent().getAttributes().get("test");
        System.out.println(name);
        System.out.println(adjective);
        System.out.println(student.getShift());
        System.out.println(test);
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
