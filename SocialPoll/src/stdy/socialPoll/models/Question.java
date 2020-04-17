package stdy.socialPoll.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question extends EntityModel {
    private String text;

    public Question(String text){
        this.text = text;
    }
    public Question(int id, String text){
        super(id);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
