package br.com.example.jsftraining.bean;

import br.com.example.jsftraining.model.Student;
import org.omnifaces.util.Faces;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Named
@ViewScoped
public class CommunicationTest10Bean implements Serializable {

    private String password;
    private List<Student> students = Student.students();

    public void save() {
        System.out.println(password);
    }

    public void delete(Student student) {
        students.remove(student);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
