package br.com.example.jsftraining.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@FlowScoped(value = "newpendencies")
public class TestNestedFlowBuilderBean implements Serializable {

    private String username;
    private String userSurname;

    public String validate() {
        System.out.println("Validating user");

//        if (true) {
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                            "User data incorrect", "something util"));
//            return null;
//        }
        //here we are return user to page if the validation is successful
        return "proceedToNewRegistration3";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
}
