package factory;

import model.*;

public class PetFactory {
    private static int idCounter = 1;

    public static Pet createPet(String name, String birthDate, String category) {
        switch (category.toLowerCase()) {
            case "собака":
                return new Dog(idCounter++, name, birthDate);
            case "кошка":
                return new Cat(idCounter++, name, birthDate);
            case "хомяк":
                return new Hamster(idCounter++, name, birthDate);
            default:
                throw new IllegalArgumentException("Неизвестная категория питомца: " + category);
        }
    }
}