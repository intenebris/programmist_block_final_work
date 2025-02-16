package view;

import model.Pet;

import java.awt.*;
import java.util.ArrayList;

public interface PetView {
    void showPets(ArrayList<Pet> pets);
    void showMessage(String message);
    String getInput(String prompt);
}
