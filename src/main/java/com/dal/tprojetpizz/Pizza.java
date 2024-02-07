package com.dal.tprojetpizz;

public class Pizza {
    private int id;
    private int cmdId;
    private String name;
    private String ingredients;

    public Pizza(int id, int cmdId, String name, String ingredients) {
        this.id = id;
        this.cmdId = cmdId;
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

    public int getCmdId() {
        return cmdId;
    }
}
