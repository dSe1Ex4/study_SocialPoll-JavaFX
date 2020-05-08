package stdy.socialPoll.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import stdy.socialPoll.models.Person;
import stdy.socialPoll.models.Relation;
import stdy.socialPoll.registry.RegGateways;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class StatsController {
    @FXML VBox vbox_leader;
    @FXML VBox vbox_pop;
    @FXML VBox vbox_none;
    @FXML VBox vbox_isol;
    @FXML VBox vbox_all;

    private Map<Person, Integer> elections;
    private ArrayList<Person> persons;
    private ArrayList<Relation> relations;

    public StatsController() {}

    @FXML
    private void initialize(){
        //TODO для каждой связи из базы данных
        relations = (ArrayList<Relation>) RegGateways.relationGateway.all();

        elections = new HashMap<>();
        persons = (ArrayList<Person>) RegGateways.personGateway.all();

        for(Person person : persons){
            elections.put(person, 0);
        }

        for(Person person : persons) {
            for (Relation rel : relations) {
                if (rel.getReceivePerson().getId() == person.getId()){//Сравнивать по id на готовой базе
                    Integer val = elections.getOrDefault(person, 0);
                    elections.put(person, ++val);
                }
            }
        }

        displayCurrentStat(vbox_all, relations);
        displayCurrentStat(vbox_leader, getLeaders());
        displayCurrentStat(vbox_pop, getPopulars());
        displayCurrentStat(vbox_none, getNones());
        displayCurrentStat(vbox_isol, getIsolates());
    }

    private <E> void displayCurrentStat(VBox out, ArrayList<E> items){
        for (E itm : items) {
            Label name = new Label();
            name.setText(itm.toString());
            out.getChildren().add(name);
        }
    }

    private ArrayList<Person> getPersonsByQuantity(int minQuantity, int maxQuantity){
        ArrayList<Person> people = new ArrayList<>();
        for(Person person : elections.keySet()) {
            Integer val = elections.getOrDefault(person, 0);
            if (val >= minQuantity && val <= maxQuantity){
                people.add(person);
            }
        }
        return people;
    }

    private ArrayList<Person> getLeaders(){
        //5-6 выборов
        return getPersonsByQuantity(5, Integer.MAX_VALUE);
    }

    private ArrayList<Person> getPopulars(){
        //3-4 выборов
        return getPersonsByQuantity(3, 4);
    }

    private ArrayList<Person> getNones(){
        //1-2 выборов
        return getPersonsByQuantity(1, 2);
    }

    private ArrayList<Person> getIsolates(){
        //0 выборов
        ArrayList<Person> isolates = new ArrayList<>();
        for (Person pers : elections.keySet()){
            if (elections.getOrDefault(pers, 0) == 0)
                isolates.add(pers);
        }

        return isolates;
    }


    public void onMenuClick(ActionEvent actionEvent) throws IOException {
        //Close current
        Stage stage = (Stage) vbox_leader.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view/uAuth.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setTitle("SocialPoll");
        stage.setResizable(false);
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
