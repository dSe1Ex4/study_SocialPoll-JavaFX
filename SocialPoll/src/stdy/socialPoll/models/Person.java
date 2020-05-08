package stdy.socialPoll.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Person implements EntityModel{
    /*@Id @GeneratedValue*/
    private long id;
    private StringProperty nameFirst = new SimpleStringProperty();
    private StringProperty nameSecond = new SimpleStringProperty();
    private StringProperty nameMiddle = new SimpleStringProperty();

    public Person(){}

    public Person(StringProperty nameFirst, StringProperty nameSecond, StringProperty nameMiddle) {
        this.nameFirst = nameFirst;
        this.nameSecond = nameSecond;
        this.nameMiddle = nameMiddle;
    }

    public Person(String nameFirst, String nameSecond, String nameMiddle) {
        this.nameFirst = new SimpleStringProperty(nameFirst);
        this.nameSecond = new SimpleStringProperty(nameSecond);
        this.nameMiddle = new SimpleStringProperty(nameMiddle);
    }

    public Person(int id, String nameFirst, String nameSecond, String nameMiddle) {
        this.nameFirst = new SimpleStringProperty(nameFirst);
        this.nameSecond = new SimpleStringProperty(nameSecond);
        this.nameMiddle = new SimpleStringProperty(nameMiddle);
    }

    public Person(int id, StringProperty nameFirst, StringProperty nameSecond, StringProperty nameMiddle) {
        this.nameFirst = nameFirst;
        this.nameSecond = nameSecond;
        this.nameMiddle = nameMiddle;
    }

    public String getNameFirst() {
        return nameFirst.get();
    }

    @Transient
    public StringProperty nameFirstProperty() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst.set(nameFirst);
    }

    public String getNameSecond() {
        return nameSecond.get();
    }

    @Transient
    public StringProperty nameSecondProperty() {
        return nameSecond;
    }

    public void setNameSecond(String nameSecond) {
        this.nameSecond.set(nameSecond);
    }

    public String getNameMiddle() {
        return nameMiddle.get();
    }

    @Transient
    public StringProperty nameMiddleProperty() {
        return nameMiddle;
    }

    public void setNameMiddle(String nameMiddle) {
        this.nameMiddle.set(nameMiddle);
    }

    @Override
    public String toString() {
        return getNameFirst()+" "+getNameSecond()+" "+getNameMiddle();
    }

    @Id @GeneratedValue
    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }
}
