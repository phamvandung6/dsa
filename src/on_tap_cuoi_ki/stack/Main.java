package on_tap_cuoi_ki.stack;

public class Main {
    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(5);
        stack.push(3);

        System.out.println("Size: " + stack.size());
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Top: " + stack.top());
    }
}
