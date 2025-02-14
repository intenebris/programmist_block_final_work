package model;

import java.util.ArrayList;
import java.util.Date;

public abstract class Pet {
    private String id;
    private String name;
    private String birthDate;
    private String type;
    private ArrayList<String> commands;

    public Pet(String id, String name, String birthDate, String type) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public abstract String getType();

    public ArrayList<String> getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", имя='" + name + '\'' +
                ", дата рождения=" + birthDate +
                ", категория='" + getType() + '\'' +
                '}';
    }
}
