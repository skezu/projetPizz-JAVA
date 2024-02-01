package com.dal.tprojetpizz;

public class Pizza {
    private String name;
    private String ingredients;

    public Pizza(String name, String ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        return ingredients;
    }
}
