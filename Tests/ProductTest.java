import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product pr1, pr2, pr3;

    @BeforeEach
    void setUp() {
        pr1 = new Product("00000A", "Candy", "Chocolate Candies", 2.00);
        pr2 = new Product("00000A", "Candy", "Chocolate Candies", 2.00);
        pr3 = new Product("00000B", "Pillow", "Very soft pillow", 10.00);


    }

    @Test
    void setID() {
        pr1.setID("00000A");
        assertEquals("00000A", pr1.getFormattedID());

    }

    @Test
    void setName() {
        pr1.setName("Candy");
        assertEquals("Candy", pr1.getFormattedName());
    }

    @Test
    void setDescription() {
        pr1.setDescription("Chocolate Candies");
        assertEquals("Chocolate Candies", pr1.getFormattedDescription());

    }

    @Test
    void setCost() {
        pr1.setCost(2.00);
        assertEquals(2.00, pr1.getCost(), 0);
    }

    @Test
    void testToString() {
        String expected = "Product{ID='00000A', Name='Candy', Description='Chocolate Candies', Cost=2.0}";
        assertEquals(expected, pr1.toString());

    }

    @Test
    void toCSV() {
        String expected = "00000A,Candy,Chocolate Candies,2.0";
        assertEquals(expected, pr1.toCSV());

    }

    @Test
    void testToJSON() {
        String expected = "{\n" +
                "  \"ID\": \"00000A\",\n" +
                "  \"Name\": \"Candy\",\n" +
                "  \"Description\": \"Chocolate Candies\",\n" +
                "  \"Cost\": 2.0\n" +
                "}";
        assertEquals(expected, pr1.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Product>\n" +
                "    <ID>00000A</ID>\n" +
                "    <Name>Candy</Name>\n" +
                "    <Description>Chocolate Candies</Description>\n" +
                "    <Cost>2.0</Cost>\n" +
                "</Product>";
        assertEquals(expected, pr1.toXML());
    }


    @Test
    void testEquals() {
        assertEquals(pr1, pr2);
        assertNotEquals(pr1, pr3);
    }

    @Test
    void testHashCode() {
        assertEquals(pr1.hashCode(), pr2.hashCode());
        assertNotEquals(pr1.hashCode(), pr3.hashCode());

    }
}