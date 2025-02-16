import presenter.PetPresenter;
import registry.PetRegistry;
import view.PetView;

public class Main {
    public static void main(String[] args) {
        PetView view = new PetView();
        PetRegistry registry = new PetRegistry();
        PetPresenter presenter = new PetPresenter(view, registry);

        presenter.start();
    }

}