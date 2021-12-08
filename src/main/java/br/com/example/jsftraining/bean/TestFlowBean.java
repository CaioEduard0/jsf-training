package br.com.example.jsftraining.bean;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@FlowScoped(value = "registration")
//the flow scoped have the same behavior of conversation scoped, but it had much
//improves and make several things by itself (ex: begin and end, set id when the
//page are changed by a link).
public class TestFlowBean implements Serializable {

    private String name;
    private String surname;
    private String address;

    public void save() {
        System.out.println("Saving in the database");
        System.out.println(name);
        System.out.println(surname);
        System.out.println(address);
        //return "exitToInit";
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
