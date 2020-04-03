package stdy.socialPoll.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Relation extends EntityModel {
    private Person firstPerson;
    private Person receivePerson;
    private IntegerProperty relationValue;

    public Relation(){super();}

    public Relation(Person firstPerson, Person receivePerson, IntegerProperty relationValue) {
        this.firstPerson = firstPerson;
        this.receivePerson = receivePerson;
        this.relationValue = relationValue;
    }

    public Relation(Person firstPerson, Person receivePerson, Integer relationValue) {
        this.firstPerson = firstPerson;
        this.receivePerson = receivePerson;
        this.relationValue = new SimpleIntegerProperty(relationValue);
    }

    public Relation(int id, Person firstPerson, Person receivePerson, Integer relationValue) {
        super(id);
        this.firstPerson = firstPerson;
        this.receivePerson = receivePerson;
        this.relationValue = new SimpleIntegerProperty(relationValue);
    }

    public Relation(int id, Person firstPerson, Person receivePerson, IntegerProperty relationValue) {
        super(id);
        this.firstPerson = firstPerson;
        this.receivePerson = receivePerson;
        this.relationValue = relationValue;
    }

    public Person getFirstPerson() {
        return firstPerson;
    }

    public void setFirstPerson(Person firstPerson) {
        this.firstPerson = firstPerson;
    }

    public Person getReceivePerson() {
        return receivePerson;
    }

    public void setReceivePerson(Person receivePerson) {
        this.receivePerson = receivePerson;
    }

    public int getRelationValue() {
        return relationValue.get();
    }

    public IntegerProperty relationValueProperty() {
        return relationValue;
    }

    public void setRelationValue(int relationValue) {
        this.relationValue.set(relationValue);
    }

    @Override
    public String toString() {
        return String.format("%s -> %s = %d",
                firstPerson.getNameFirst()+" "+firstPerson.getNameSecond(),
                receivePerson.getNameFirst()+" "+receivePerson.getNameSecond(),
                relationValue.getValue()
        );
    }
}
