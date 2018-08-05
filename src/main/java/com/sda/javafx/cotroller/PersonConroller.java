package com.sda.javafx.cotroller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;


public class PersonConroller {

    private Main main;

    @FXML
    private TableView<Person> personTable;

    @FXML
    private Label imie;
    @FXML
    private Label nazwisko;
    @FXML
    private Label ulica;
    @FXML
    private Label miasto;
    @FXML
    private Label kodPocztowy;
    @FXML
    private Label telefon;

    @FXML
    private TableColumn<Person, String> firstNameCol;

    @FXML
    private TableColumn<Person, String> lastNameCol;

    @FXML
    private Button newButton;

    @FXML
    public void handleSaveAS() throws IOException {
        main.saveAS();

    }

    @FXML
    public void handleSaveList() throws IOException {
        main.saveList();

    }

    @FXML
    public void handleNewPerson(){
        System.out.println("testtest");
        this.main.loadNewPerson();

        imie.setLabelFor(personTable.getSelectionModel().getTableView());
    }

    @FXML
    public void handlePersonEdit(){
        Person selectPerson = personTable.getSelectionModel().getSelectedItem();

        if(selectPerson != null) {
            System.out.println(selectPerson.getName());
            this.main.loadPersonEdit(selectPerson);
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getStage());
            alert.setTitle("Brak osoby");
            alert.setContentText("Nie wybrano osoby");
            alert.showAndWait();
        }
    }

    @FXML
    public void handleDeletePerson() {
        Person index = personTable.getSelectionModel().getSelectedItem();
        if (index != null) {
            System.out.println(index);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete " + index.getName() + " ?", ButtonType.YES,
                    ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                personTable.getItems().remove(index);
            }
        }
    }

    @FXML
    public void initialize(){
        firstNameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());
        lastNameCol.setCellValueFactory(cell -> cell.getValue().lasnameProperty());

        personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldFiled, newFiled) -> showPersonDetalis(newFiled));
    }

    private void showPersonDetalis(Person person){
        imie.setText(person.getName());
        nazwisko.setText(person.getLasname());
    }

    public void setMain(Main main) {
        this.main = main;
        personTable.setItems(main.getPersonList());
    }
}
