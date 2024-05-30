package thuchanh.tuan7.bai1;

public class ArrEntry<K, E> implements Entry<K, E> {
    K key;
    E element;

    public ArrEntry(K key, E element) {
        this.key = key;
        this.element = element;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public E getValue() {
        return element;
    }

    @Override
    public String toString() {
        return "[" + key + ":" + element + "]";
    }
}
