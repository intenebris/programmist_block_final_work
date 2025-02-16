package view;

import model.Pet;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsolePetView implements PetView {

    @Override
    public void showPets(ArrayList<Pet> pets) {
        if (pets.isEmpty()) {
            System.out.println("В реестре нет ни одного животного.");
        } else {
            System.out.println("Животные в реестре:");
            for (Pet pet : pets) {
                System.out.println(pet);
            }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
