package model;

public class Hamster extends Pet {
    public Hamster(int id, String name, String birthDate) {
        super(id, name, birthDate);
    }

    @Override
    public String getCategory() {
        return "Хомяк";
    }
}
