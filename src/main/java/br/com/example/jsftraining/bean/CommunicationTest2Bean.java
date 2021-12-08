package br.com.example.jsftraining.bean;

import org.omnifaces.cdi.Param;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@Named
@ViewScoped
public class CommunicationTest2Bean implements Serializable {

    //that is a functionality of omnifaces, a library that help us develop with JSF.
    //and that annotation set the parameter that come from URL automatically in the
    //annotated property
    @Inject
    @Param(name = "name")
    private String name;

    @Inject @Param(name = "surname")
    private String surname;

    @PostConstruct
    public void init() {
        //here I'm getting the parameters sent by the other view (Communication1)
//        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        name = params.get("name");
//        surname = params.get("surname");
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
