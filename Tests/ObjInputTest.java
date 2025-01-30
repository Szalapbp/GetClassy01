import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Scanner;


class ObjInputTest {

private SafeInputObj safeInput;



    @BeforeEach
    void setUp() {

        safeInput = new SafeInputObj(new Scanner(System.in));


    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        safeInput = new SafeInputObj(new Scanner(System.in));
    }

    @Test
    void getNonZeroLenString() {
        setInput("Hello\n");
        assertEquals("Hello", safeInput.getNonZeroLenString("Enter text"));

        setInput("\nValidInput\n");
        assertEquals("ValidInput", safeInput.getNonZeroLenString("Enter text"));
    }

    @Test
    void getRangedInt() {
        setInput("5\n");
        assertEquals(5, safeInput.getRangedInt("Enter number", 1, 10));

        setInput("15\n3\n");
        assertEquals(3, safeInput.getRangedInt("Enter number", 1, 10));
    }

    @Test
    void getInt() {
        setInput("42\n");
        assertEquals(42, safeInput.getInt("Enter any integer"));

        setInput("Hello\n25\n");
        assertEquals(25, safeInput.getInt("Enter any integer"));
    }

    @Test
    void getRangedDouble() {
        setInput("3.5\n");
        assertEquals(3.5, safeInput.getRangedDouble("Enter number", 1.0, 5.0), 0.01);

        setInput("6.7\n2.3\n");
        assertEquals(2.3, safeInput.getRangedDouble("Enter number", 1.0, 5.0), 0.01);
    }

    @Test
    void getDouble() {
        setInput("7.89\n");
        assertEquals(7.89, safeInput.getDouble("Enter any double"), 0.01);

        setInput("Hello\n4.56\n");
        assertEquals(4.56, safeInput.getDouble("Enter any double"), 0.01);
    }

    @Test
    void getYNConfirm() {
        setInput("Y\n");
        assertTrue(safeInput.getYNConfirm("Confirm?"));

        setInput("N\n");
        assertFalse(safeInput.getYNConfirm("Confirm?"));

        setInput("Maybe\nN\n");
        assertFalse(safeInput.getYNConfirm("Confirm?"));
    }

    @Test
    void getRegExString() {
        setInput("A123\n");
        assertEquals("A123", safeInput.getRegExString("Enter code", "A\\d{3}"));

        setInput("B456\nA999\n"); // First invalid, then valid
        assertEquals("A999", safeInput.getRegExString("Enter code", "A\\d{3}"));
    }
}