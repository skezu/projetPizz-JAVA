package com.dal.tprojetpizz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PizzaModel {
    private ObservableList<Pizza> pizzaList = FXCollections.observableArrayList();

    public ObservableList<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void addPizza(Pizza pizza) {
        pizzaList.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzaList.remove(pizza);
    }
}
