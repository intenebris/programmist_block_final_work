package model;

import java.time.LocalDate;

public class Hamster extends Pet {
    public Hamster(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String getCategory() {
        return "Хомяк";
    }
}
