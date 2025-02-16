package factory;

import model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PetFactory {
    private static int idCounter = 1;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static Pet createPet(String name, String birthDate, String category) {
        LocalDate parsedBirthDate = LocalDate.parse(birthDate, DATE_FORMATTER); // Преобразуем строку в LocalDate
        switch (category.toLowerCase()) {
            case "собака":
                return new Dog(idCounter++, name, parsedBirthDate);
            case "кошка":
                return new Cat(idCounter++, name, parsedBirthDate);
            case "хомяк":
                return new Hamster(idCounter++, name, parsedBirthDate);
            default:
                throw new IllegalArgumentException("Неизвестная категория питомца: " + category);
        }
    }
}