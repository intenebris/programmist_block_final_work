package registry;

public class CounterPets {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public int addPetToCounter(){
        counter ++;
        return counter;
    }

    public int removePetFromCounter(){
        if (counter > 0){
            counter --;
        } else {
            counter = 0;
        }
        return counter;
    }

}
