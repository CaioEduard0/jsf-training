package br.com.example.jsftraining.validators;

import br.com.example.jsftraining.bean.LoginBean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import java.util.List;

import static java.util.Arrays.asList;

@FacesValidator
public class DuplicatedEmailValidator implements Validator {

    private List<String> emails = asList("caio@hotmail.com", "caio2@hotmail.com");

    @Inject
    private LoginBean loginBean;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        System.out.println(loginBean.getLanguage());
        String email = (String) o;
        if (emails.contains(email)) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "The e-mail already exists.", "");
            throw new ValidatorException(message);
        }
    }
}
