package br.com.example.jsftraining.util;

import javax.faces.context.FacesContext;

public class ApplicationMapUtil {

    //that class help us put values in the session without create a bean

    public static Object getValue(String key) {
        return FacesContext.getCurrentInstance().getExternalContext()
                .getApplicationMap().get(key);
    }

    public static void setValue(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext()
                .getApplicationMap().put(key, value);
    }
}
