import java.util.*;
class Pet {
    String type;
    int age;
    boolean isAdopted;

    public Pet(String type, int age, boolean isAdopted) {
        this.type = type;
        this.age = age;
        this.isAdopted = isAdopted;
    }
}

class PetPortal<T extends Pet> {
    List<T> pets = new ArrayList<>();

    public void addPet(T pet) {
        pets.add(pet);
    }

    public List<T> filterAvailablePets(String type, int maxAge) {
        List<T> result = new ArrayList<>();
        for (T pet : pets) {
            if (!pet.isAdopted && pet.type.equalsIgnoreCase(type) && pet.age <= maxAge) {
                result.add(pet);
            }
        }
        return result;
    }
}

public class PetAdoptionPortal {
    public static void main(String[] args) {
        PetPortal<Pet> portal = new PetPortal<>();
        portal.addPet(new Pet("Dog", 3, false));
        portal.addPet(new Pet("Cat", 2, false));
        portal.addPet(new Pet("Dog", 5, true));

        List<Pet> dogs = portal.filterAvailablePets("Dog", 4);
        for (Pet dog : dogs) {
            System.out.println(dog.type + " " + dog.age);
        }
    }
}