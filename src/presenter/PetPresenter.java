package presenter;

import factory.PetFactory;
import model.Pet;
import registry.PetRegistry;
import view.PetView;

import java.util.ArrayList;
import java.util.List;

public class PetPresenter {
    private final PetView view;
    private final PetRegistry registry;
    private final PetFactory factory;

    public PetPresenter(PetView view, PetRegistry registry, PetFactory factory) {
        this.view = view;
        this.registry = registry;
        this.factory = factory;
    }

    public void addPet(String name, String birthDate, String type) {
        try {
            Pet pet = factory.createPet(name, birthDate, type);
            registry.addPet(name, birthDate, type);
            view.showMessage("Животное добавлено: " + pet);
        } catch (IllegalArgumentException e) {
            view.showMessage("Ошибка: " + e.getMessage());
        }
    }

    public void showAllPets() {
        ArrayList<Pet> pets = registry.getAllPets();
        view.showPets(pets);
    }

    public void showTotalNumberPets() {
        registry.showCounterPets();
    }

    public void removePet(String id) {
        registry.removePetById(id);
        view.showMessage("Животное с ID: " + id + " удалено");
    }
}
