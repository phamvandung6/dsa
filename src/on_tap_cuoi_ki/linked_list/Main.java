package on_tap_cuoi_ki.linked_list;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        System.out.println(list);

        list.remove(2);

        System.out.println(list);
    }
}