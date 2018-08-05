package com.sda.javafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private StringProperty name;
    private StringProperty lasname;
    private StringProperty street;
    private StringProperty city;
    private StringProperty postalCode;
    private StringProperty telephoe;

    public Person(){}

    public Person(String name, String lasname) {
        this.name = new SimpleStringProperty(name);
        this.lasname = new SimpleStringProperty(lasname);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getLasname() {
        return lasname.get();
    }

    public StringProperty lasnameProperty() {
        return lasname;
    }

    public String getStreet() {
        return street.get();
    }

    public StringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getCity() {
        return city.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setLasname(String lasname) {
        this.lasname.set(lasname);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getPostalCode() {
        return postalCode.get();
    }

    public StringProperty postalCodeProperty() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode.set(postalCode);
    }

    public String getTelephoe() {
        return telephoe.get();
    }

    public StringProperty telephoeProperty() {
        return telephoe;
    }

    public void setTelephoe(String telephoe) {
        this.telephoe.set(telephoe);
    }
}

