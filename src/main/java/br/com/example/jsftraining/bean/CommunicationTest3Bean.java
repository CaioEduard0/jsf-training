package br.com.example.jsftraining.bean;

import org.omnifaces.cdi.Param;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class CommunicationTest3Bean implements Serializable {

    private String name;
    private String surname;
    private Date date;

    //the post construct was removed here, because the event in the view already call that method automatically.
    public void init() {
        //here we are validating if the request is ajax or not, in that case the if validate if isn't a ajax request.
        if (!FacesContext.getCurrentInstance().isPostback()) {
            System.out.println("communication 3 created");
            System.out.println(name);
            System.out.println(surname);
        }
    }

    public String save() {
        System.out.println("Saving");
        return "result?faces-redirect=true&amp;includeViewParams=true";
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
