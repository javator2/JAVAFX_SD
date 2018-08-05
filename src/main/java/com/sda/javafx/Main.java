package com.sda.javafx;

import com.sda.javafx.cotroller.PersonConroller;
import com.sda.javafx.cotroller.PersonDetalis;
import com.sda.javafx.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;
    private VBox layout;

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public Main(){
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Franek", "Lewandowski"));
        personList.add(new Person("Zbychu", "Dzik"));
        personList.add(new Person("Marian", "Zysk"));
        personList.add(new Person("Jan", "Kowalski"));
        personList.add(new Person("Jan", "Kowalski"));
    }

    public Stage getStage() {
        return stage;
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public static void main(String[] args) {
        launch();


    }

    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.stage.setTitle("Moja aplikacja w JavaFX");
        loadView();

    }

    public void loadView(){
        try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/okienko.fxml"));

        layout = (VBox)loader.load();

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();

            PersonConroller conroller = loader.getController();
            conroller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadNewPerson(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/NewPerson.fxml"));

            VBox window = (VBox)loader.load();

            Stage editStage = new Stage();
            editStage.setTitle("Nowy pracownik");
            Scene scene = new Scene(window);
            editStage.setScene(scene);
            editStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void loadPersonEdit(Person person){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/personedit.fxml"));

            VBox window = (VBox)loader.load();

            PersonDetalis personDetalis =loader.getController();
            personDetalis.setPerson(person);

            Stage editStage = new Stage();
            editStage.setTitle("Edytuj pracownika");

            personDetalis.setStage(editStage);

            Scene scene = new Scene(window);
            editStage.setScene(scene);
            editStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDeletePerson(Person person){

    }

}
