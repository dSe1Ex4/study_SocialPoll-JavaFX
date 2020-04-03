package stdy.socialPoll.registry;

import stdy.socialPoll.models.Person;

import java.util.Objects;

public class SharedPersistence {
    private static SharedPersistence instance;

    private Person currentPerson;

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
