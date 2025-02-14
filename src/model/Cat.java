package model;

import java.util.Date;

public class Cat extends Pet{
    public Cat (String id, String name, String birthDate, String type) {
        super(id, name, birthDate, type);
    }

    @Override
    public String getType() {
        return "кошка";
    }
}
