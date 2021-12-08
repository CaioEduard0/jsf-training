package br.com.example.jsftraining.bean;

import org.omnifaces.util.Faces;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

@Named
@ViewScoped
public class CommunicationTest9Bean implements Serializable {

    private String value;

    public void init() throws UnsupportedEncodingException {
        value = Faces.getRequestCookie("name");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
