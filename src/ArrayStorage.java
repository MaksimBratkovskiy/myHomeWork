import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10];

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
        //работает
    }

    Resume get(String uuid) {
        int index = posFoundVal(uuid);
        if (index != -1){
            return storage[index];
        }
        return null;

        //работает
    }

    //Удаляет найденый найденный элемент репозитория
    void delete(String uuid) {
        int posDelVal = posFoundVal(uuid);
        storage[posDelVal] = null;
        for (int i = posDelVal; i < storage.length - 1; i++) {
            storage[i] = storage[i + 1];
        }
        //починил


    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    //Возвращает используемый репощзиторий
    Resume[] getAll() {
        //determine the size of the current storage

        //create intermediate storage and fill it

        return Arrays.copyOf(storage, size());

        // работает
    }

    //находит размер используемого репозитория
    int size() {
        int count = 0;
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] != null){
                count++;
            }
        }
        return count;
//        работает
    }

    //Находит позицию элемента (линейный поиск)
    public int posFoundVal(String a) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(a)) {
                return i;
            }
        }
        return -1;
//        работает
    }
}
