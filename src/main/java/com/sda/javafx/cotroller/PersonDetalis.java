package com.sda.javafx.cotroller;

import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonDetalis {

    private Stage stage;

    @FXML
    private TextField imie;
    @FXML
    private TextField nazwisko;
    @FXML
    private TextField ulica;
    @FXML
    private TextField miasto;
    @FXML
    private TextField kodPocztowy;
    @FXML
    private TextField numerTelefonu;

    private Person person;

    @FXML
    public void initialize(){
        imie.setText("to jest tes");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setPerson(Person person){
        this.person = person;

        imie.setText(person.getName());
        nazwisko.setText(person.getLasname());

    }

    public void handleOK(){
        person.setName(imie.getText());
        person.setLasname(nazwisko.getText());
        System.out.println("Zapisz");
        this.stage.close();
    }
}
