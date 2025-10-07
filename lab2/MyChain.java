import java.util.*;

public class MyChain extends Chain {

    public MyChain() {
        super();
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        ChainNode current = firstNode;
        int i = 0;
        while (current != null) {
            arr[i++] = current.element;
            current = current.next;
        }
        return arr;
    }

    public void addRange(Object[] elements) {
        if (elements == null) 
            throw new IllegalArgumentException("Null array not allowed");
        
        for (Object el : elements) {
            add(size, el); 
        }
    }


    public MyChain union(MyChain other) {
        MyChain result = new MyChain();
        
        ChainNode current = this.firstNode;
        while (current != null) {
            result.add(result.size, current.element);
            current = current.next;
        }

        current = other.firstNode;
        while (current !=null) {
            if (result.indexOf(current.element) == -1) {
                result.add(result.size, current.element);
            }
            current = current.next;
        }

        return result;
    }

    public MyChain intersection(MyChain other) {
        MyChain result = new MyChain();

        ChainNode current = this.firstNode;
        while (current != null) {
            if (other.indexOf(current.element) != -1 &&
            result.indexOf(current.element) == -1) {
                result.add(result.size, current.element);
            }
            current = current.next;
        }
        return result;
    }


    public static void main(String[] args) {
        MyChain list1 = new MyChain();
        list1.add(0, 1);
        list1.add(1, 2);
        list1.add(2, 3);

        MyChain list2 = new MyChain();
        list2.add(0, 3);
        list2.add(1, 4);
        list2.add(2, 5);

        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);

        System.out.println("List1 as array: " + Arrays.toString(list1.toArray()));

        list1.addRange(new Object[]{6, 7, 8});
        System.out.println("List1 after addRange: " + list1);

        MyChain unionList = list1.union(list2);
        System.out.println("Union: " + unionList);

        MyChain interList = list1.intersection(list2);
        System.out.println("Intersection: " + interList);
    }
}
