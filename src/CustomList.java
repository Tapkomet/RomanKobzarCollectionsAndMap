import java.util.AbstractList;
import java.util.Arrays;

public class CustomList<T> extends AbstractList<T> {

    private T[] arr;
    private int size;
    
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    CustomList(T[] array) {
        arr = array;
    }

    public T get(int index) {
        return arr[index];
    }

    public T set(int index, T element) {
        T oldValue = arr[index];
        arr[index] = element;
        return oldValue;
    }
    
    public boolean add(T element) {
        ensureCapacityInternal(size + 1);
        arr[size++] = element;
        return true;
    }
    
    private void ensureCapacityInternal(int minCapacity) {
        modCount++;
        if (minCapacity - arr.length > 0)
            grow(minCapacity);
    }
    
    private void grow(int minCapacity) {
        int oldCapacity = arr.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        arr = Arrays.copyOf(arr, newCapacity);
    }
    
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }

    public int size() {
        return size;
    }
}