package stdy.socialPoll.registry;

import stdy.socialPoll.gateways.QuestionGateway;
import stdy.socialPoll.models.Person;
import stdy.socialPoll.models.Question;

import java.util.Iterator;
import java.util.Objects;

public class SharedPersistence {
    private static SharedPersistence instance;

    private Person currentPerson;

    private Iterator<Question> iterator = RegGatways.questionGateway.all().iterator();

    public Question getNextQuestion(){
        if (iterator.hasNext()){
            return iterator.next();
        } else {
            return null;
        }
    }

    public static SharedPersistence getInstance(){
        return Objects.requireNonNullElseGet(instance, () -> instance = new SharedPersistence());
    }

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;
    }
}
