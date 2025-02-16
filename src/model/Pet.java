package model;

import java.awt.*;
import java.util.ArrayList;


public abstract class Pet {
    private int id;
    private String name;
    private String birthDate;
    private ArrayList commands;

    public Pet(int id, String name, String birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    @Override
    public String toString() {
        return "Питомец {" +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", дата рождения='" + birthDate + '\'' +
                ", команды=" + commands +
                '}';
    }

    // Абстрактный метод для получения категории питомца
    public abstract String getCategory();
}