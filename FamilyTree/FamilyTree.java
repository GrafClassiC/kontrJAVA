package FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FamilyTree<T extends Serializable> {
    private Map<String, T> elements;
    private FileIOInterface<Map<String, T>> fileIO;

    public FamilyTree() {
        this.elements = new HashMap<>();
        this.fileIO = new FileIO<Map<String, T>>();
    }

    public void saveToFile(String fileName) {
        fileIO.writeToFile(fileName, elements);
    }

    public void loadFromFile(String fileName) {
        Map<String, T> loadedElements = fileIO.readFromFile(fileName);
        if (loadedElements != null) {
            this.elements = loadedElements;
        }
    }

    public void addElement(String key, T element) {
        elements.put(key, element);
    }

    public T findElementByKey(String key) {
        return elements.get(key);
    }

    public Map<String, T> getElements() {
        return elements;
    }
}