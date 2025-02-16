package registry;


import factory.SimplePetFactory;
import model.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetRegistry {
    private final Map<String, Pet> pets = new HashMap<>();
    private final CounterPets counter = new CounterPets();


    public void addPet (String name, String birthDate, String type) {
        Pet animal = new SimplePetFactory().createPet(name, birthDate, type);
        pets.put(animal.getId(), animal);
        counter.addPetToCounter();
    }

    public ArrayList<Pet> getAllPets () {
        return new ArrayList<>(pets.values());
    }

    public int showCounterPets() {
        return counter.getCounter();
    }

    public void removePetById (String id) {
        pets.remove(id);
        counter.removePetFromCounter();
    }


}
