package model;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String getCategory() {
        return "Кошка";
    }
}
