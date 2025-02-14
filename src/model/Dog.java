package model;

import java.util.Date;

public class Dog extends Pet {

    public Dog (String id, String name, String birthDate, String type) {
        super(id, name, birthDate, type);
    }

    @Override
    public String getType() {
        return "собака";
    }
}
