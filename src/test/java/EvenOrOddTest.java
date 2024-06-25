import org.example.EvenOrOdd;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvenOrOddTest {
    EvenOrOdd evenOrOdd = new EvenOrOdd();

    @Test
    public void isEven_true() {
        assertTrue(evenOrOdd.isEven(0));
        assertTrue(evenOrOdd.isEven(2));
        assertTrue(evenOrOdd.isEven(4));
        assertTrue(evenOrOdd.isEven(6));
        assertTrue(evenOrOdd.isEven(8));
        assertTrue(evenOrOdd.isEven(-20));
        assertTrue(evenOrOdd.isEven(100));
        assertTrue(evenOrOdd.isEven(-46));
    }

    @Test
    public void isEven_false() {
        assertFalse(evenOrOdd.isEven(1));
        assertFalse(evenOrOdd.isEven(3));
        assertFalse(evenOrOdd.isEven(5));
        assertFalse(evenOrOdd.isEven(7));
        assertFalse(evenOrOdd.isEven(9));
        assertFalse(evenOrOdd.isEven(-11));
        assertFalse(evenOrOdd.isEven(93));
        assertFalse(evenOrOdd.isEven(-75));
    }
}
