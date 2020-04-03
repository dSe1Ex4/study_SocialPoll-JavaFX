package stdy.socialPoll.controllers;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import stdy.socialPoll.gateways.PersonGateway;
import stdy.socialPoll.models.Person;
import stdy.socialPoll.registry.RegGatways;
import stdy.socialPoll.registry.SharedPersistence;

import java.io.IOException;

public class AuthController {
    @FXML private TextField tfNameFirst;
    @FXML private TextField tfNameSecond;
    @FXML private TextField tfNameMiddle;
    @FXML private ComboBox<Person> comboxPersons;
    private SharedPersistence sharedPersistence;

    private ObservableList<Person> personList = new SimpleListProperty<>();
    private PersonGateway personGW = RegGatways.personGateway;

    @FXML
    public void initialize(){
        personGW.insert(new Person("First", "Second", "Middle"));
        personList = FXCollections.observableArrayList(personGW.all());
        comboxPersons.setItems(personList);

        sharedPersistence = SharedPersistence.getInstance();
    }

    @FXML
    private void OnClickRegister(ActionEvent actionEvent) {
        Person curPerson = new Person(tfNameFirst.getText(), tfNameSecond.getText(), tfNameMiddle.getText());
        personGW.insert(curPerson);
        personList.add(curPerson);

        tfNameFirst.clear();
        tfNameSecond.clear();
        tfNameMiddle.clear();

        //TODO Сохраняем в базу данных
    }

    @FXML
    private void OnClickContinue(ActionEvent actionEvent) throws IOException {

        if (comboxPersons.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ахтунг!");
            alert.setHeaderText(null);
            alert.setContentText("Выберите пользователя");
            alert.showAndWait();
            return;
        }

        sharedPersistence.setCurrentPerson(comboxPersons.getValue());

        //Close current
        Stage stage = (Stage) comboxPersons.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/uPoll.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Вопрос");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
