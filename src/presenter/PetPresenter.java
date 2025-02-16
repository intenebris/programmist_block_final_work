package presenter;

import factory.PetFactory;
import model.Pet;
import registry.PetRegistry;
import view.PetView;

public class PetPresenter {
    private PetView view;
    private PetRegistry registry;

    public PetPresenter(PetView view, PetRegistry registry) {
        this.view = view;
        this.registry = registry;
    }

    public void start() {
        while (true) {
            view.showMenu();
            int choice = view.getMenuChoice();

            switch (choice) {
                case 1:
                    String[] details = view.getPetDetails();
                    Pet pet = PetFactory.createPet(details[0], details[1], details[2]);
                    registry.addPet(pet);
                    view.showMessage("Питомец добавлен!");
                    break;
                case 2:
                    int idToRemove = view.getPetId();
                    registry.removePet(idToRemove);
                    view.showMessage("Питомец удален!");
                    break;
                case 3:
                    view.showAllPets(registry.getAllPets());
                    break;
                case 4:
                    view.showPetCount(registry.getPetCount());
                    break;
                case 5:
                    int idToAddCommand = view.getPetId();
                    Pet petToAddCommand = registry.getPetById(idToAddCommand);
                    if (petToAddCommand != null) {
                        String command = view.getCommand();
                        petToAddCommand.addCommand(command);
                        view.showMessage("Команда добавлена!");
                    } else {
                        view.showMessage("Питомец с таким ID не найден!");
                    }
                    break;
                case 6:
                    int idToShowCommands = view.getPetId();
                    Pet petToShowCommands = registry.getPetById(idToShowCommands);
                    if (petToShowCommands != null) {
                        view.showPetCommands(petToShowCommands.getCommands());
                    } else {
                        view.showMessage("Питомец с таким ID не найден!");
                    }
                    break;
                case 7:
                    view.showAllPets(registry.getPetsSortedByBirthDate());
                    break;
                case 8:
                    return;
                default:
                    view.showMessage("Неверный выбор!");
            }
        }
    }
}