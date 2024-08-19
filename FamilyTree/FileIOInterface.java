package FamilyTree;

import java.io.Serializable;

public interface FileIOInterface<T> {
    void writeToFile(String fileName, T data);
    T readFromFile(String fileName);
}
