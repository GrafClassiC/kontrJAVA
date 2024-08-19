package FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> peopleTree = new FamilyTree<>();
        FamilyTree<Animal> animalsTree = new FamilyTree<>();

        Person john = new Person("John", "Doe", Person.MALE, LocalDate.of(1980, 1, 1));
        Animal fido = new Dog("Fido", "Golden Retriever", LocalDate.of(2015, 5, 10));

        peopleTree.addElement(john.getName(), john);
        animalsTree.addElement(fido.getName(), fido);

        peopleTree.saveToFile("people_tree.dat");
        animalsTree.saveToFile("animals_tree.dat");

        // Загрузка данных из файлов
        FamilyTree<Person> loadedPeopleTree = new FamilyTree<>();
        FamilyTree<Animal> loadedAnimalsTree = new FamilyTree<>();

        loadedPeopleTree.loadFromFile("people_tree.dat");
        loadedAnimalsTree.loadFromFile("animals_tree.dat");

        System.out.println("Дерево Людей:");
        for (Person person : loadedPeopleTree.getElements().values()) {
            System.out.println(person);
        }

        System.out.println("Дерево Животных:");
        for (Animal animal : loadedAnimalsTree.getElements().values()) {
            System.out.println(animal);
        }
    }
}