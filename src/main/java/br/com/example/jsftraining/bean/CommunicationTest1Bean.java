package br.com.example.jsftraining.bean;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Named
@ViewScoped
public class CommunicationTest1Bean implements Serializable {

    private String name;
    private String surname;
    private Date date = new Date();
//    private String formattedDate;

//    @PostConstruct
//    public void init() {
//        formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
//    }

    //that represents a global variable for the system.
    public void printAttributes() {
        String initParameter = FacesContext.getCurrentInstance().getExternalContext()
                .getInitParameter("images.location");
        System.out.println(initParameter);
    }
    //sending the parameters by get http method
    public String save() {
        System.out.println(name);
        System.out.println(surname);
        return "communication2?faces-redirect=true&name="+name+"&surname="+surname;
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
