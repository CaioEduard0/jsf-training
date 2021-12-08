package br.com.example.jsftraining.bean;

import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.asList;

@Named
@ViewScoped
public class AjaxTestBean implements Serializable {

    private String name;
    private String surname;
    private Map<String, List<String>> animeCharacters;
    private List<String> characters;
    private String selectedAnime;
    private String selectedCharacter;
    private String email;

//    {
//        animeCharacters = new TreeMap<>();
//        animeCharacters.put("Hellsing", asList("Alucard", "Seras", "Alexander"));
//        animeCharacters.put("Attack on Titan", asList("Eren", "Mikasa", "Armin"));
//        animeCharacters.put("Berserk", asList("Guts", "Casca", "Griffith"));
//    }

    public void init() {
        //that isn't a ajax request?
        if (!FacesContext.getCurrentInstance().isPostback()) {
            animeCharacters = new TreeMap<>();
            animeCharacters.put("Hellsing", asList("Alucard", "Seras", "Alexander"));
            animeCharacters.put("Attack on Titan", asList("Eren", "Mikasa", "Armin"));
            animeCharacters.put("Berserk", asList("Guts", "Casca", "Griffith"));
        }
    }

    public void toUpperCase(AjaxBehaviorEvent event) {
        this.name = this.name.toUpperCase();
        this.surname = this.surname.toUpperCase();
    }

    public void toUpperCaseName() {
        this.name = this.name.toUpperCase();
    }

    public void onSelectAnime() {
        if (selectedAnime == null) {
            characters = null;
            return;
        }
        characters = animeCharacters.get(selectedAnime);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Map<String, List<String>> getAnimeCharacters() {
        return animeCharacters;
    }

    public void setAnimeCharacters(Map<String, List<String>> animeCharacters) {
        this.animeCharacters = animeCharacters;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getSelectedAnime() {
        return selectedAnime;
    }

    public void setSelectedAnime(String selectedAnime) {
        this.selectedAnime = selectedAnime;
    }

    public String getSelectedCharacter() {
        return selectedCharacter;
    }

    public void setSelectedCharacter(String selectedCharacter) {
        this.selectedCharacter = selectedCharacter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
