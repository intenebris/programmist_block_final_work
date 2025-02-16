package registry;

import model.Pet;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

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

    public ArrayList<Pet> getPetsSortedByBirthDate() {
        ArrayList<Pet> sortedPets = new ArrayList<>(pets);
        sortedPets.sort(Comparator.comparing(Pet::getBirthDate)); // Сортировка по LocalDate
        return sortedPets;
    }
}