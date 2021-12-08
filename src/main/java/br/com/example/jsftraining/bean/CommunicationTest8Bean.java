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
public class CommunicationTest8Bean implements Serializable {

    private String key;
    private String value;

    public void init() throws UnsupportedEncodingException {
        //here we are catching all cookies
        Map<String, Object> requestCookieMap = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
        Cookie cookie = (Cookie) requestCookieMap.get("surname");
        //the cookie come as url, then we are to decoder him to get back to him normal state
        String decode = URLDecoder.decode(cookie.getValue(), "UTF-8");
        System.out.println("Cookie decoded: " + decode);
        System.out.println("Cookie value: " + cookie.getValue());
        System.out.println("Cookie map value: " + requestCookieMap.get("name"));
        System.out.println(requestCookieMap);
        //that is the easy way to get the cookies
        String name = Faces.getRequestCookie("name");
        System.out.println("Cookie omnifaces value: " + name);
    }

    public String saveCookie() {
        //setting the cookies with omnifaces
        Faces.addResponseCookie(key, value, -1);
        //the -1 value keep cookie alive until the user erase it
        //the 0 value keep cookie alive in one request
        //any other value greater than 0 keep the cookie alive for the informed time (in seconds)
        return "communication9?faces-redirect=true";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
