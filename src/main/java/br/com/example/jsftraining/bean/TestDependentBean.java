package br.com.example.jsftraining.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
@Dependent
//dependent is the default scoped of a bean (if a bean don't have
//any annotation, then it is a dependent scoped bean)
public class TestDependentBean implements Serializable {

    private List<String> characters;
    private List<String> selectedCharacter = new ArrayList<>();
    private List<String> categories = new ArrayList<>();

    //the post construct annotation make the container (wildfly server) execute all content
    // of method after the attributes is initialized and the constructor was called
    @PostConstruct
    public void init() {
        System.out.println("Entered in PostConstruct of @Dependent.");
        characters = asList("Naruto", "Hinata", "Yondaime");
    }

    public void setSelectedCharacter(List<String> selectedCharacter) {
        this.selectedCharacter = selectedCharacter;
    }

    public void selectCharacter() {
        int index = ThreadLocalRandom.current().nextInt(3);
        String character = characters.get(index);
        selectedCharacter.add(character);
    }

    public List<String> getSelectedCharacter() {
        return selectedCharacter;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
