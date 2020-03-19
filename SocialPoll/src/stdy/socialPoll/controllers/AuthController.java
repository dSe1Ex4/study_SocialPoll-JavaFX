package stdy.socialPoll.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import stdy.socialPoll.models.Person;

public class AuthController {
    @FXML TextField tfNameFirst;
    @FXML TextField tfNameSecond;
    @FXML TextField tfNameMiddle;
    @FXML ComboBox<Person> comboxPersons;

    @FXML
    public void initialize(){
        //TODO: Подкрутить юзверей из базы и приатачить их к комбу
    }


    public void OnClickRegister(ActionEvent actionEvent) {
        Person person1 = new Person(tfNameFirst.getText(), tfNameSecond.getText(), tfNameMiddle.getText());
        tfNameFirst.setText(person1.getNameFirst()+person1.getNameMiddle());
        
    }
}
