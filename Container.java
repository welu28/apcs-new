import java.util.*;

public class Container<T> {
    private ArrayList<T> items;

    public Container() {
        items = new ArrayList<>();
    }

    public void remove(int index) {
        items.remove(index);
    }

    public T get(int index) {
        return items.get(index);
    }

    public void add(T item) {
        items.add(item);
    }


    public static void main(String[] args) {
        Container<Integer> intContainer = new Container<>();
        intContainer.add(1);
        intContainer.add(2);
        intContainer.add(3);
        System.out.println("index 1: " + intContainer.get(1));
        intContainer.remove(1);
        System.out.println("after removal, index 1: " + intContainer.get(1));
        
        Container<String> stringContainer = new Container<>();
        stringContainer.add("Hello");
        stringContainer.add("World");
        System.out.println("index 0: " + stringContainer.get(0));
        stringContainer.remove(0);
        System.out.println("after removal, index 0: " + stringContainer.get(0));
    }
}
