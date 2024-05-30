package data_structure_template.single_linked_list;

public class SingleLinkedList<T> {
    private Node<T> head;

    public SingleLinkedList() {
        head = null;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(T data) {
        if (head == null) {
            addFirst(data);
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<>(data);
        }
    }

    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        T data = head.data;
        head = head.next;
        return data;
    }

    public T getFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    public int size() {
        int size = 0;
        Node<T> temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;
        while (temp != null) {
            sb.append(temp.data).append(" -> ");
            temp = temp.next;
        }
        sb.append("null");
        return sb.toString();
    }
    
    public boolean search(T value) {
        Node<T> current = head;
        if (current == null) {
            return false;
        }
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
