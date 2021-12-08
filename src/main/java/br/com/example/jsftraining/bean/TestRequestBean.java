package br.com.example.jsftraining.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
@RequestScoped
//request scoped stay alive while the request exists. therefore, when the client make
//a request and the response was returned, the variables are destroyed and will be
//recreated in the next request.
public class TestRequestBean implements Serializable {

    private List<String> characters;
    private List<String> selectedCharacter = new ArrayList<>();

    //the post construct annotation make the container (wildfly server) execute all content
    // of method after the attributes is initialized and the constructor was called
    @PostConstruct
    public void init() {
        System.out.println("Entered in PostConstruct of RequestScoped.");
        characters = asList("Yusuke", "Hiei", "Kurama");
    }

    public void selectCharacter() {
        int index = ThreadLocalRandom.current().nextInt(3);
        String character = characters.get(index);
        selectedCharacter.add(character);
    }

    public List<String> getSelectedCharacter() {
        return selectedCharacter;
    }

    public void setSelectedCharacter(List<String> selectedCharacter) {
        this.selectedCharacter = selectedCharacter;
    }
}
