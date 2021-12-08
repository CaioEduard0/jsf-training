package br.com.example.jsftraining.bean;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CommunicationResultTestBean implements Serializable {

    private String name;
    private String surname;

    //the post construct was removed here, because the event in the view already call that method automatically.
    public void init() {
        System.out.println("communication result created");
        System.out.println(name);
        System.out.println(surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
