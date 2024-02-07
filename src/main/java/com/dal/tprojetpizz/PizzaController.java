package com.dal.tprojetpizz;

public class PizzaController {
    private PizzaModel model;
    private PizzaView view;

    public PizzaController(PizzaModel model, PizzaView view) {
        this.model = model;
        this.view = view;
    }

    public void addPizza(int id, int cmdId, String name, String ingredients) {
        Pizza pizza = new Pizza(id, cmdId, name, ingredients);
        model.addPizza(pizza);
        view.update(); // Update view
    }

    public void removePizza(Pizza pizza) {
        model.removePizza(pizza);
        view.update(); // Update view
    }
}
