package br.com.example.jsftraining.bean;

import br.com.example.jsftraining.model.Student;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CommunicationTest7Bean implements Serializable {

    private Student student;

    public void init() {
        //that catch the object (or attribute) sent from the other view (bean)
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        student = (Student) flash.get("student");
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
