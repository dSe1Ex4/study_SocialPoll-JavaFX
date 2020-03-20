package stdy.socialPoll.controllers;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import stdy.socialPoll.gateways.PersonGateway;
import stdy.socialPoll.models.Person;
import stdy.socialPoll.registry.RegGatways;

public class AuthController {
    @FXML TextField tfNameFirst;
    @FXML TextField tfNameSecond;
    @FXML TextField tfNameMiddle;
    @FXML ComboBox<Person> comboxPersons;

    ObservableList<Person> personList = new SimpleListProperty<>();;
    PersonGateway personGW = RegGatways.personGateway;

    @FXML
    public void initialize(){
        //TODO: Подкрутить юзверей из базы и приатачить их к комбу
        personGW.insert(new Person("First", "Second", "Middle"));
        personList = FXCollections.observableArrayList(personGW.all());
        comboxPersons.setItems(personList);
    }


    public void OnClickRegister(ActionEvent actionEvent) {
        Person curPerson = new Person(tfNameFirst.getText(), tfNameSecond.getText(), tfNameMiddle.getText());
        personGW.insert(curPerson);
        personList.add(curPerson);

        tfNameFirst.clear();
        tfNameSecond.clear();
        tfNameMiddle.clear();
    }
}
