package br.com.example.jsftraining.converters;

import br.com.example.jsftraining.model.Student;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.List;
import java.util.Map;

@FacesConverter(value = "studentConverter")
public class StudentConverter implements Converter {

    private List<Student> students = Student.students();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value == null || !value.matches("\\d+")) {
            return null;
        }
//        with the 2 methods below we don't need to fetch the students of the database anymore.
//        Student student = new Student();
//        student.setId(Integer.parseInt(value));
//        int index = students.indexOf(student);
//        return students.get(index);
        return this.getAttributesFrom(uiComponent).get(value);
        //if we don't implements serializable in the entity class (Student), the id come in null.
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value != null && !value.equals("")) {
            Student student = (Student) value;
            if (student.getId() != null) {
                this.addAttribute(uiComponent, student);
                return student.getId().toString();
            }
        }
        return null;
    }

    private Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

    private void addAttribute(UIComponent component, Student student) {
        this.getAttributesFrom(component).put(student.getId().toString(), student);
    }
}
