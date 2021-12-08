package br.com.example.jsftraining.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

import static java.util.Arrays.asList;

@Named
@ApplicationScoped
//the application scoped keep alive while the server has running.
//and can be accessed by the entire application when some attribute
//is updated in that page, the users of all system will see the change.
public class TestApplicationBean implements Serializable {

    private List<String> categories;
    private final TestDependentBean testDependentBean;
    private final TestSessionBean testSessionBean;

    @Inject
    public TestApplicationBean(TestDependentBean testDependentBean, TestSessionBean testSessionBean) {
        this.testDependentBean = testDependentBean;
        this.testSessionBean = testSessionBean;
    }

    //we can inject a bean within other that stay alive much time than itself.

    @PostConstruct
    public void init() {
        System.out.println("Entered in PostConstruct of ApplicationScoped.");
        categories = asList("RPG", "SCI-FI", "Horror");
        testDependentBean.getCategories().addAll(asList("Comedy", "Romance"));
        testSessionBean.selectCharacter();
    }

    public void updateList() {
        categories = asList("RPG", "SCI-FI", "Horror", "Porn");
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public TestDependentBean getTestDependentBean() {
        return testDependentBean;
    }

    public TestSessionBean getTestSessionBean() {
        return testSessionBean;
    }
}
