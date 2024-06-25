import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class EvenOrOdd {
    EvenOrOdd collectionsExercise = new CollectionsExercise();

    @Test
    public void testAddSixToEndOfLinkedList() {
        LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        collectionsExercise.addToEndOfLinkedList(numbers, 6);
        assertEquals(Integer.valueOf(6), numbers.getLast());
    }

}
