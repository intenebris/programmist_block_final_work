package factory;

import model.Pet;

import java.util.Date;

public interface PetFactory {
    Pet createPet(String name, String birthDate, String type);
}
