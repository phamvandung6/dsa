package thuchanh.tuan7.bai1;

public class NodeEntry<K, E> implements Entry<K, E> {
    private K key;
    private E element;
    public NodeEntry<K, E> next;

    public NodeEntry(K key, E element) {
        this.key = key;
        this.element = element;
        this.next = null;
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
