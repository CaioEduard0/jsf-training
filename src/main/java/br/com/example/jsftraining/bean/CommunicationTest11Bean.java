package br.com.example.jsftraining.bean;

import br.com.example.jsftraining.model.Student;
import br.com.example.jsftraining.util.ApplicationMapUtil;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CommunicationTest11Bean implements Serializable {

    private List<Student> students = Student.students();

    public String update(Student student) {
        ApplicationMapUtil.setValue("student", student);
        return "communication12?faces-redirect=true";
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
