package model;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(int id, String name, LocalDate birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String getCategory() {
        return "Собака";
    }
}
