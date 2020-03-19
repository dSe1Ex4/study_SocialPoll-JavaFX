package stdy.socialPoll.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private StringProperty nameFirst = new SimpleStringProperty();
    private StringProperty nameSecond = new SimpleStringProperty();
    private StringProperty nameMiddle = new SimpleStringProperty();

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
}
