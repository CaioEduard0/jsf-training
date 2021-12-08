package br.com.example.jsftraining.bean;

import br.com.example.jsftraining.model.Student;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.asList;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private String email;
    private String password;
    private Student student;
    private List<Locale> locales = asList(new Locale("en"), new Locale("pt"));
    private String language;
    private int qntdMessages;

    public String login() {
        //consulting the database...
        if (email.equals("caio@gmail.com") && password.equals("123")) {
            student = new Student();
            qntdMessages++;
            return "/restricted/systemInit.xhtml?faces-redirect=true";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "E-mail or password invalid.", ""));
        return null;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        student = null;
        return "/login?faces-redirect=true";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getQntdMessages() {
        return qntdMessages;
    }

    public void setQntdMessages(int qntdMessages) {
        this.qntdMessages = qntdMessages;
    }
}
