/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null){
                break;
            }
            if (storage[i] != null){
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null){
                storage[i] = r;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.intern() == uuid.intern()){
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int count = size();

        for (int i = count - 1; i < storage.length - 1; i++) {
            storage[i] = storage[i + 1];
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        //determine the size of the current storage
        int count = size();

        //create intermediate storage and fill it
        Resume[] currentStorage = new Resume[count];
        for (int i = 0; i < currentStorage.length; i++) {
            currentStorage[i] = storage[i];
        }
        return storage;
    }

    int size() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null){
                count = i;
                break;
            }
        }
        return count;
    }
}
