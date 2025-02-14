import factory.SimplePetFactory;
import model.Pet;
import registry.PetRegistry;

public class Main {
    public static void main(String[] args) {

        // Создаем фабрику и реестр
        SimplePetFactory factory = new SimplePetFactory();
        PetRegistry registry = new PetRegistry();

        //Создаем домашних животных
        Pet kuzja = factory.createPet("Кузя", "2020-01-05", "кошка");
        Pet svist = factory.createPet("Свист", "2022-03-09", "собака");


        //Добавляем животных в реестр
        registry.addPet(kuzja);
        registry.addPet(svist);
        registry.addPet("Хома", "2023-10-15", "хомяк");

        //Выводим всех животных в консоль
        registry.getAllPets().forEach(System.out::println);
    }
}