package model;

import java.util.Date;

public class Hamster extends Pet{
    public Hamster (String id, String name, String birthDate, String type) {
        super(id, name, birthDate, type);
    }

    @Override
    public String getType() {
        return "хомяк";
    }
}
