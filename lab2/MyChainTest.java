import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyChainTest {

    @Test
    public void testToArray() {
        MyChain list = new MyChain();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        Object[] expected = {1, 2, 3};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    public void testAddRange() {
        MyChain list = new MyChain();
        list.addRange(new Object[]{4, 5, 6});
        assertEquals("[4, 5, 6]", list.toString());
    }

    @Test
    public void testUnion() {
        MyChain list1 = new MyChain();
        list1.addRange(new Object[]{1, 2, 3});

        MyChain list2 = new MyChain();
        list2.addRange(new Object[]{3, 4, 5});

        MyChain result = list1.union(list2);
        assertEquals("[1, 2, 3, 4, 5]", result.toString());
    }

    @Test
    public void testIntersection() {
        MyChain list1 = new MyChain();
        list1.addRange(new Object[]{1, 2, 3, 4});

        MyChain list2 = new MyChain();
        list2.addRange(new Object[]{3, 4, 5});

        MyChain result = list1.intersection(list2);
        assertEquals("[3, 4]", result.toString());
    }

    @Test
    public void testAddRangeNull() {
        MyChain list = new MyChain();
        assertThrows(IllegalArgumentException.class, () -> {
            list.addRange(null);
        });
    }
}
