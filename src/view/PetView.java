package view;

import model.Pet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class PetView {
    private Scanner scanner;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public PetView() {
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("1. Добавить питомца");
        System.out.println("2. Удалить питомца");
        System.out.println("3. Показать всех питомцев");
        System.out.println("4. Показать количество питомцев");
        System.out.println("5. Добавить команду питомцу");
        System.out.println("6. Показать команды питомца");
        System.out.println("7. Показать всех питомцев по дате рождения");
        System.out.println("8. Выйти");
    }

    public int getMenuChoice() {
        System.out.print("Выберите опцию: ");
        return scanner.nextInt();
    }

    public String[] getPetDetails() {
        scanner.nextLine(); // Очистка буфера
        System.out.print("Введите имя питомца: ");
        String name = scanner.nextLine();

        LocalDate birthDate = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Введите дату рождения питомца (в формате dd-MM-yyyy): ");
            String birthDateStr = scanner.nextLine();
            try {
                birthDate = LocalDate.parse(birthDateStr, DATE_FORMATTER);
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Ошибка: Неверный формат даты. Пожалуйста, введите дату в формате dd-MM-yyyy.");
            }
        }

        System.out.print("Введите категорию питомца (собака, кошка, хомяк): ");
        String category = scanner.nextLine();
        return new String[]{name, birthDate.format(DATE_FORMATTER), category};
    }

    public int getPetId() {
        System.out.print("Введите ID питомца: ");
        return scanner.nextInt();
    }

    public String getCommand() {
        scanner.nextLine(); // Очистка буфера
        System.out.print("Введите команду: ");
        return scanner.nextLine();
    }

    public void showAllPets(ArrayList<Pet> pets) {
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    public void showPetCount(int count) {
        System.out.println("Количество питомцев в реестре: " + count);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showPetCommands(ArrayList<String> commands) {
        if (commands.isEmpty()) {
            System.out.println("У питомца нет команд.");
        } else {
            System.out.println("Команды питомца:");
            for (String command : commands) {
                System.out.println("- " + command);
            }
        }
    }
}