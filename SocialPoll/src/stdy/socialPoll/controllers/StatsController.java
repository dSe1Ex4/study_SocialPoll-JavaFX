package stdy.socialPoll.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import stdy.socialPoll.models.Person;

import java.util.ArrayList;


public class StatsController {
    @FXML VBox vbox_leader;
    @FXML VBox vbox_pop;
    @FXML VBox vbox_none;
    @FXML VBox vbox_isol;
    @FXML VBox vbox_all;

    public StatsController() {}

    @FXML
    private void initialize(){
        //TODO для каждой связи из базы данных
        Label name = new Label();
        name.setText("Связь");
        vbox_all.getChildren().add(name);
    }

    private ArrayList<Person> getLeaders(){
        //5-6 выборов
        ArrayList<Person> leaders = new ArrayList<>();
        return leaders;
    }

    private ArrayList<Person> getNones(){
        //1-2 выборов
        ArrayList<Person> nones = new ArrayList<>();
        return nones;
    }

    private ArrayList<Person> getIsolates(){
        //0 выборов
        ArrayList<Person> isol = new ArrayList<>();
        return isol;
    }

    private ArrayList<Person> getPopulars(){
        //3-4 выборов
        ArrayList<Person> pops = new ArrayList<>();
        return pops;
    }



}
