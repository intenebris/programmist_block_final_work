import factory.SimplePetFactory;
import model.Pet;
import presenter.PetPresenter;
import registry.PetRegistry;
import view.ConsoleMenu;
import view.ConsolePetView;

public class Main {
    public static void main(String[] args) {

        // Инициализация компонентов
        PetRegistry registry = new PetRegistry();
        SimplePetFactory factory = new SimplePetFactory();
        ConsolePetView view = new ConsolePetView();
        PetPresenter presenter = new PetPresenter(view, registry, factory);

        // Запускаем консольное меню
        ConsoleMenu.startMenu(view, presenter);


    }

}