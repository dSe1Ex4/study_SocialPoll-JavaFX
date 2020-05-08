package stdy.socialPoll.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Access(AccessType.PROPERTY)
public class Question implements EntityModel{
    @Id @GeneratedValue
    private long id;
    private String text;

    public Question(){}

    public Question(String text){
        this.text = text;
    }
    public Question(int id, String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Id @GeneratedValue
    @Override
    public long getId() {
        return id;
    }
    public void setId(long id) { this.id = id; }
}
