package model;

public class Dog extends Pet {
    public Dog(int id, String name, String birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String getCategory() {
        return "Собака";
    }
}
