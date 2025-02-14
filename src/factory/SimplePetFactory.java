package factory;

import model.Cat;
import model.Dog;
import model.Hamster;
import model.Pet;

import java.util.Date;
import java.util.UUID;

public class SimplePetFactory implements PetFactory{
    @Override
    public Pet createPet(String name, String birthDate, String type) {
        // Генерация уникального ID
        String id = UUID.randomUUID().toString();

        // Логика создания животных
        if (type.toLowerCase().contains("собака")) {
            return new Dog(id, name, birthDate, type);
        } else if (type.toLowerCase().contains("кошка")) {
            return new Cat(id, name, birthDate, type);
        } else if (type.toLowerCase().contains("хомяк")) {
            return new Hamster(id, name, birthDate, type);
        } else {
            throw new IllegalArgumentException("Неизвестная категория животного " + name);
        }
    }
}
