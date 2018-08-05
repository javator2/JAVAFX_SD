package com.sda.javafx;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.javafx.cotroller.PersonConroller;
import com.sda.javafx.cotroller.PersonCreater;
import com.sda.javafx.cotroller.PersonDetalis;
import com.sda.javafx.model.Person;
import com.sda.javafx.model.PersonJSON;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Stage stage;
    private VBox layout;

    private ObservableList<Person> personList = FXCollections.observableArrayList();
    private List<PersonJSON> personJSONList = new ArrayList<PersonJSON>();


    public Main() throws IOException {
       /* personJSONList.add(new PersonJSON("Jan", "Kowalski"));
        personJSONList.add(new PersonJSON("Franek", "Lewandowski"));
        personJSONList.add(new PersonJSON("Zbychu", "Dzik"));
        personJSONList.add(new PersonJSON("Marian", "Zysk"));
        personJSONList.add(new PersonJSON("Jan", "Kowalski"));
        personJSONList.add(new PersonJSON("Jan", "Kowalski"));
*/


        ObjectMapper mapper = new ObjectMapper();
        // File filename = new File("person.json");
        // filename.createNewFile();
        // mapper.writeValue(filename, personJSONList);


        PersonJSON[] readorders = mapper.readValue(new File("person.json"), PersonJSON[].class);

        for (PersonJSON p : readorders) {
            System.out.println(p.getName());
            personList.add(new Person(p.getName(), p.getLastname()));

        }
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

    public void loadView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/okienko.fxml"));

            layout = (VBox) loader.load();

            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.show();

            PersonConroller conroller = loader.getController();
            conroller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadNewPerson() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/NewPerson.fxml"));

            VBox window = (VBox) loader.load();
            Stage editStage = new Stage();
            editStage.setTitle("Nowy pracownik");

            PersonCreater personCreater = loader.getController();

            Person person = new Person("","");
            personCreater.setStage(editStage);
            personCreater.createPerson(person);
            personList.add(person);



            Scene scene = new Scene(window);
            editStage.setScene(scene);
            editStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadPersonEdit(Person person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/personedit.fxml"));

            VBox window = (VBox) loader.load();

            PersonDetalis personDetalis = loader.getController();
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

    public void saveList() throws IOException {

        List<PersonJSON> newPersonList = new ArrayList<PersonJSON>();

        for (Person p : personList) {
            System.out.println(p.getName());
            newPersonList.add(new PersonJSON(p.getName(), p.getLasname()));

        }
        ObjectMapper maper = new ObjectMapper();
        FileWriter fileWriter = new FileWriter("person.json");
        maper.writeValue(fileWriter, newPersonList);
    }

    public void saveAS() throws IOException {
        List<PersonJSON> newPersonList = new ArrayList<PersonJSON>();

        for (Person p : personList) {
            System.out.println(p.getName());
            newPersonList.add(new PersonJSON(p.getName(), p.getLasname()));

        }
        ObjectMapper maper = new ObjectMapper();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Zapisz liste");
        File newFile = fileChooser.showSaveDialog(stage).getAbsoluteFile();

       maper.writeValue(newFile, newPersonList);
    }

        public void loadDeletePerson (Person person){


        }

    }
