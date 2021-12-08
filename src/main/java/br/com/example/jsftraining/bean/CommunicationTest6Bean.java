package br.com.example.jsftraining.bean;

import br.com.example.jsftraining.model.Student;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CommunicationTest6Bean implements Serializable {

    private List<Student> students = Student.students();

    public String update(int index) {
        Student student = students.get(index);
        //that bring to us the object sent from the view, and make this execute by one redirect (request)
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("student", student);
        return "communication7?faces-redirect=true";
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
