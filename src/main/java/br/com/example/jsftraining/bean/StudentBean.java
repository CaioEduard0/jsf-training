package br.com.example.jsftraining.bean;

import br.com.example.jsftraining.model.Student;

import javax.el.LambdaExpression;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;

@Named
//view scoped means that while the user stay in the same page the container don't change the
//objects state. (he don't recreate the attributes of bean again, just if user change the page)
@ViewScoped
public class StudentBean implements Serializable {

    private Student student = new Student();
    private String[] array = {"Yu-Gi-Oh", "DBZ", "Beyblade"};
    private List<String> names = asList("Caio", "José", "Maria", "John");
    private Set<String> namesSet = new HashSet<>(asList("Caio", "José", "Maria", "John"));
    private Map<String, String> namesMap = new HashMap<>();
    private boolean showGrades;
    private boolean showLink;

    {
        namesMap.put("1- ", "Caio");
        namesMap.put("2- ", "Maria");
        namesMap.put("3- ", "Elisney");
    }

    public void func() {
        System.out.println("test function.");
    }

    public void func(String param) {
        System.out.println("test function with param: " + param);
    }

    public String funcWithReturn(String param) {
        return "What is the sent param? " + param;
    }

    public String goToIndex2() {
        return "index2?faces-redirect=true";
    }

    public void showGrades() {
        this.showGrades = true;
    }

    public void hideGrades() {
        this.showGrades = false;
    }

    public void showLink() {
        this.showLink = true;
    }

    public void hideLink() {
        this.showLink = false;
    }

    public void cubeCalculate(LambdaExpression le, long value) {
        long result = (long) le.invoke(FacesContext.getCurrentInstance().getELContext(), value);
        System.out.println(result);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Set<String> getNamesSet() {
        return namesSet;
    }

    public void setNamesSet(Set<String> namesSet) {
        this.namesSet = namesSet;
    }

    public Map<String, String> getNamesMap() {
        return namesMap;
    }

    public void setNamesMap(Map<String, String> namesMap) {
        this.namesMap = namesMap;
    }

    public boolean isShowGrades() {
        return showGrades;
    }

    public void setShowGrades(boolean showGrades) {
        this.showGrades = showGrades;
    }

    public boolean isShowLink() {
        return showLink;
    }

    public void setShowLink(boolean showLink) {
        this.showLink = showLink;
    }
}
