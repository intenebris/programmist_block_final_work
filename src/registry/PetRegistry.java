package registry;


import factory.SimplePetFactory;
import model.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetRegistry {
    private final Map<String, Pet> pets = new HashMap<>();

    public void addPet (Pet pet) {
        pets.put(pet.getId(), pet);
    }

    public void addPet (String name, String birthDate, String type) {
        Pet animal = new SimplePetFactory().createPet(name, birthDate, type);
        pets.put(animal.getId(), animal);
    }

    public List<Pet> getAllPets () {
        return new ArrayList<>(pets.values());
    }

    public void removePetById (String id) {
        pets.remove(id);
    }
}
