package view;

import presenter.PetPresenter;

public class ConsoleMenu {

    public static void startMenu(ConsolePetView view, PetPresenter presenter) {
        while (true){
            // Отображение меню
            view.showMessage("\n--- Меню реестра домашних животных ---");
            view.showMessage("1. Добавить животное");
            view.showMessage("2. Показать всех животных");
            view.showMessage("5. Показать общее количество животных в реестре");
            view.showMessage("3. Удалить животное по ID");
            view.showMessage("4. Выход");
            String choice = view.getInput("Выберите нужную опцию: ");

            // Обработка выбора пользователя
            switch (choice) {
                case "1":
                    // Добавление животного
                    String name = view.getInput("Введите имя животного: ");
                    String birthDate = view.getInput("Введите дату рождения (в формате 2020-01-01): ");
                    String type = view.getInput("Введите категорию (например кошка или собака): ");
                    presenter.addPet(name, birthDate, type);
                    break;
                case "2":
                    // Показать всех животных
                    presenter.showAllPets();
                    break;
                case "5":
                    // Показать количество
                    view.showMessage("Всего животных в реестре: ");
                    presenter.showTotalNumberPets();
                    break;
                case "3":
                    // Удалить животное по ID
                    String id = view.getInput("Введите ID животного для удаления: ");
                    presenter.removePet(id);
                    break;
                case "4":
                    // Выход из приложения
                    view.showMessage("Выхожу...");
                    return;
                default:
                    view.showMessage("Неверная команда. Попробуйте еще раз.");
                    break;
            }
        }
    }
}
