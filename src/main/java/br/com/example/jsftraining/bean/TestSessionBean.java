package br.com.example.jsftraining.bean;

import br.com.example.jsftraining.model.Student;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
@SessionScoped
//the session scoped maintain the attributes alive while the session are active
//the session just dies when the browser are closed, some method (function)
//is called to invalidate the session or the session time up.
public class TestSessionBean implements Serializable {

    private List<String> characters;
    private List<String> selectedCharacter = new ArrayList<>();
    private Student student;

    //the post construct annotation make the container (wildfly server) execute all content
    // of method after the attributes is initialized and the constructor was called
    @PostConstruct
    public void init() {
        System.out.println("Entered in PostConstruct of SessionScoped.");
        characters = asList("Goku", "Vegeta", "Gohan");
        login();
    }

    public void login() {
        //consulting database and verifying if login exists and is active
        student = new Student();
    }

    //this method invalidate the session
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "session?faces-redirect=true";
        //normally that method redirect the user to login page, where him don't need
        //permissions to access.
    }

    public void setSelectedCharacter(List<String> selectedCharacter) {
        this.selectedCharacter = selectedCharacter;
    }

    public void selectCharacter() {
        int index = ThreadLocalRandom.current().nextInt(3);
        String character = characters.get(index);
        selectedCharacter.add(character);
    }

    public List<String> getSelectedCharacter() {
        return selectedCharacter;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
