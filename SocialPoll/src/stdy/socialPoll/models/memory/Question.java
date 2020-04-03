package stdy.socialPoll.models.memory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Question {
    private static List<Question> questions = new ArrayList<>(Arrays.asList(
        new Question("С кем бы ты хотел сидеть за одним столом? Выбери себе до 3-х человек."),
        new Question("Представь, что тебе на День рождения подарили 4 билета в цирк. Один билет тебе, у тебя остается 3 билета. Кого бы ты хотел пригласить с собой в цирк?"),
        new Question("С кем бы ты хотел пойти погулять на улицу? Выбери из группы 3 человека."),
        new Question("С кем бы ты поешл играть в прятки? Выбери себе до 3-х человек."),
        new Question("С кем бы ты хотел отправится в поход? Выбери себе до 3-х человек.")
    ));
    private static Iterator<Question> iterator = questions.iterator();

    private String text;

    private Question(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Question getNextQuestion(){
        if (iterator.hasNext()){
            return iterator.next();
        } else {
            return null;
        }
    }
}
