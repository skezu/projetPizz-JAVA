package com.dal.tprojetpizz;

public class Pizza {
    private int id;
    private String name;
    private String ingredients;

    public Pizza(int id, String name, String ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getId() {
        return id;
    }
}
