package br.com.example.jsftraining.bean;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;

@Named
@ViewScoped
//the view scoped keep alive while the user stay in the same page
//when him change the page the attributes are killed automatically
public class TestViewBean implements Serializable {

    private List<String> characters;
    private List<String> selectedCharacter = new ArrayList<>();
    private final TestDependentBean testDependentBean;
    private final TestSessionBean testSessionBean;

    @Inject
    public TestViewBean(TestDependentBean testDependentBean, TestSessionBean testSessionBean) {
        this.testDependentBean = testDependentBean;
        this.testSessionBean = testSessionBean;
    }

    //the post construct annotation make the container (wildfly server) execute all content
    // of method after the attributes is initialized and the constructor was called
    @PostConstruct
    public void init() {
        System.out.println("Entered in PostConstruct of ViewScoped.");
        characters = asList("Naruto", "Hinata", "Yondaime");
    }

    public void setSelectedCharacter(List<String> selectedCharacter) {
        this.selectedCharacter = selectedCharacter;
    }

    public void selectCharacter() {
        int index = ThreadLocalRandom.current().nextInt(3);
        String character = characters.get(index);
        selectedCharacter.add(character);
        testDependentBean.getSelectedCharacter().add(character);
    }

    public List<String> getSelectedCharacter() {
        return selectedCharacter;
    }

    public TestDependentBean getTestDependentBean() {
        return testDependentBean;
    }

    public TestSessionBean getTestSessionBean() {
        return testSessionBean;
    }
}
