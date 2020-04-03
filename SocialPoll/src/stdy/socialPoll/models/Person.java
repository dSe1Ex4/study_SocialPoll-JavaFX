package stdy.socialPoll.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person extends EntityModel {
    private StringProperty nameFirst;
    private StringProperty nameSecond;
    private StringProperty nameMiddle;

    public Person(){super();}

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
        super(id);
        this.nameFirst = new SimpleStringProperty(nameFirst);
        this.nameSecond = new SimpleStringProperty(nameSecond);
        this.nameMiddle = new SimpleStringProperty(nameMiddle);
    }

    public Person(int id, StringProperty nameFirst, StringProperty nameSecond, StringProperty nameMiddle) {
        super(id);
        this.nameFirst = nameFirst;
        this.nameSecond = nameSecond;
        this.nameMiddle = nameMiddle;
    }

    public String getNameFirst() {
        return nameFirst.get();
    }

    public StringProperty nameFirstProperty() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst.set(nameFirst);
    }

    public String getNameSecond() {
        return nameSecond.get();
    }

    public StringProperty nameSecondProperty() {
        return nameSecond;
    }

    public void setNameSecond(String nameSecond) {
        this.nameSecond.set(nameSecond);
    }

    public String getNameMiddle() {
        return nameMiddle.get();
    }

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
}
