package model;

public class Cat extends Pet {
    public Cat(int id, String name, String birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String getCategory() {
        return "Кошка";
    }
}
