package stdy.socialPoll.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import stdy.socialPoll.gateways.PersonGateway;
import stdy.socialPoll.models.Person;
import stdy.socialPoll.models.Relation;
import stdy.socialPoll.models.memory.Question;
import stdy.socialPoll.registry.RegGatways;
import stdy.socialPoll.registry.SharedPersistence;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PollController {
    @FXML private VBox vbox;
    @FXML private Label labelName;
    @FXML private Text textQuestion;

    private ArrayList<CheckBox> checkBoxes = new ArrayList<>();
    private ArrayList<Person> persons;

    private SharedPersistence sharedPersistence;
    private PersonGateway personGW = RegGatways.personGateway;

    public PollController() {}

    @FXML
    private void initialize() throws IOException {
        sharedPersistence = SharedPersistence.getInstance();
        if (sharedPersistence.getCurrentPerson() != null)
            labelName.setText(sharedPersistence.getCurrentPerson().toString());

        persons = (ArrayList<Person>) personGW.all();

        for (Person p : persons){
            if (p.equals(sharedPersistence.getCurrentPerson())) continue;

            CheckBox cb = new CheckBox();
            cb.setText(p.toString());
            checkBoxes.add(cb);

            vbox.getChildren().add(cb);
        }

        nextQuestion();
    }

    @FXML
    private void OnClickContinue(ActionEvent actionEvent) throws IOException {
        ArrayList<Person> selectedPersons = new ArrayList<>();

        for (int x = 0; x < checkBoxes.size(); ++x){
            CheckBox cb = checkBoxes.get(x);
            if (cb.isSelected()){
                selectedPersons.add(persons.get(x));
                cb.setSelected(false);
            }
        }

        if (selectedPersons.size() > 3){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ахтунг!");
            alert.setHeaderText(null);
            alert.setContentText("Вы выбрали больше 3 людей!");
            alert.showAndWait();
            return;
        }

        for (Person person : selectedPersons){
            //TODO Если нет в базе - создаем и добавляем
            Relation relation = new Relation(sharedPersistence.getCurrentPerson(), person, 1);
            //Save in database
        }

        nextQuestion();
    }

    private void nextQuestion() throws IOException {
        Question question = Question.getNextQuestion();

        if (question == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Тест");
            alert.setHeaderText(null);
            alert.setContentText("Тест закончен. Спасибо!");
            alert.showAndWait();
            openMainMenu();
            return;
        }

        textQuestion.setText(question.getText());
    }

    private void openMainMenu() throws IOException {
        //Close current
        Stage stage = (Stage) vbox.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/uAuth.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("SocialPoll");
        stage.setResizable(false);
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
