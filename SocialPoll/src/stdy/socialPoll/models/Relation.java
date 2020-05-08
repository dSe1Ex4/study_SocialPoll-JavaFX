package stdy.socialPoll.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Relation implements EntityModel {
/*    @Id @GeneratedValue*/
    private long id;

/*    @OneToOne(targetEntity=Person.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="first_person_id")*/
    private Person firstPerson;

/*    @OneToOne(targetEntity=Person.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="receive_person_id")*/
    private Person receivePerson;

    public Relation(){}

    public Relation(Person firstPerson, Person receivePerson, IntegerProperty relationValue) {
        this.firstPerson = firstPerson;
        this.receivePerson = receivePerson;
    }

    public Relation(Person firstPerson, Person receivePerson, Integer relationValue) {
        this.firstPerson = firstPerson;
        this.receivePerson = receivePerson;
    }

    public Relation(long id, Person firstPerson, Person receivePerson, Integer relationValue) {
        this.firstPerson = firstPerson;
        this.receivePerson = receivePerson;
    }

    public Relation(long id, Person firstPerson, Person receivePerson, IntegerProperty relationValue) {
        this.firstPerson = firstPerson;
        this.receivePerson = receivePerson;
    }

    @OneToOne(targetEntity=Person.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name="first_person_id")
    public Person getFirstPerson() {
        return firstPerson;
    }

    public void setFirstPerson(Person firstPerson) {
        this.firstPerson = firstPerson;
    }

    @OneToOne(targetEntity=Person.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name="receive_person_id")
    public Person getReceivePerson() {
        return receivePerson;
    }

    public void setReceivePerson(Person receivePerson) {
        this.receivePerson = receivePerson;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s",
                firstPerson.getNameFirst()+" "+firstPerson.getNameSecond(),
                receivePerson.getNameFirst()+" "+receivePerson.getNameSecond()
        );
    }

    @Id @GeneratedValue
    @Override
    public long getId() {
        return id;
    }
    public void setId(long id) { this.id = id; }
}
