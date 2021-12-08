package br.com.example.jsftraining.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;


@Named
@ConversationScoped
//the conversation scoped is like the session scoped, but you have the power of
//kill him whatever you want in the session.
//it initializes in the transient state, therefore, in that state it works like a
//request scoped bean, recreating the variables and calling the post construct
//method all times the page is refreshed.
public class TestConversationBean implements Serializable {

    private List<String> characters;
    private List<String> selectedCharacter = new ArrayList<>();

    //we are asking the container (wildfly server) to resolve all dependencies of the scoped and
    //then let him available for us.
    @Inject
    private Conversation conversation;

    //the post construct annotation make the container (wildfly server) execute all content
    // of method after the attributes is initialized and the constructor was called

    //we will remove the post construct here, because have a method in the xhtml that will be
    //executed before him.
    public void init() {
        System.out.println("Entered in PostConstruct of ConversationScoped.");
        characters = asList("Luffy", "Zoro", "Sanji");

        //asking container to initialize the conversation scoped
        if (conversation.isTransient()) {
            //long running is when the conversation scoped are running
            conversation.begin();
            System.out.println("Initializing the conversation scoped of id = " + conversation.getId());
        }
    }

    public String endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
            System.out.println("Killing the conversation scoped.");
        }
        return "conversation?faces-redirect=true";
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

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
