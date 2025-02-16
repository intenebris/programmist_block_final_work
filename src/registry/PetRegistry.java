package registry;

import model.Pet;

import java.awt.*;
import java.util.ArrayList;

public class PetRegistry {
    private ArrayList<Pet> pets;

    public PetRegistry() {
        pets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(int id) {
        pets.removeIf(pet -> pet.getId() == id);
    }

    public ArrayList<Pet> getAllPets() {
        return pets;
    }

    public int getPetCount() {
        return pets.size();
    }

    public Pet getPetById(int id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }
}
