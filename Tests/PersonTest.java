import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1, p2, p3;

    @BeforeEach
    void setUp() {
        p1 = new Person("00000A", "Blake", "Szalapski", "Mr.", 2002);
        p2 = new Person("00000A", "Blake", "Szalapski", "Mr.", 2002);
        p3 = new Person("00000C", "Billy", "Bob", "Dr.", 1970);
    }

    @Test
    void setID() {
        p1.setID("00000B");
        assertEquals("00000B", p1.getID());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Blake");
        assertEquals("Blake", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Szalapski");
        assertEquals("Szalapski", p1.getLastName());
    }

    @Test
    void setTitle() {
        p1.setTitle("Mr.");
        assertEquals("Mr.", p1.getTitle());
    }

    @Test
    void setYOB() {
        p1.setYOB(2002);
        assertEquals(2002, p1.getYOB());
    }

    @Test
    void getFullName() {
        p1.setFirstName("Blake");
        p1.setLastName("Szalapski");
        assertEquals("Blake Szalapski", p1.getFullName());
    }

    @Test
    void getFormalName() {
        p1.setFirstName("Blake");
        p1.setLastName("Szalapski");
        p1.setTitle("Mr.");
        assertEquals("Mr. Blake Szalapski", p1.getFormalName());

    }

    @Test
    void getAge(){
        int expectedAge = LocalDate.now().getYear() - 2002;
        assertEquals(expectedAge, p1.getAge());
    }

    @Test
    void getAgeByYear(){
        assertEquals(21,p1.getAge(2023));
        assertEquals(50,p2.getAge(2052));
        assertThrows(IllegalArgumentException.class, () -> p2.getAge(2001));
    }

    @Test
    void toCSV() {
        String expected = "00000A,Blake,Szalapski,Mr.,2002";
        assertEquals(expected, p1.toCSV());

    }

    @Test
    void testToJSON() {
        String expected = "{\n" +
                "  \"ID\": \"00000A\",\n" +
                "  \"FirstName\": \"Blake\",\n" +
                "  \"LastName\": \"Szalapski\",\n" +
                "  \"Title\": \"Mr.\",\n" +
                "  \"YOB\": 2002\n" +
                "}";
        assertEquals(expected, p1.toJSON());
    }

    @Test
    void testToXML() {
        String expected = "<Person>\n" +
                "    <ID>00000A</ID>\n" +
                "    <FirstName>Blake</FirstName>\n" +
                "    <LastName>Szalapski</LastName>\n" +
                "    <Title>Mr.</Title>\n" +
                "    <YOB>2002</YOB>\n" +
                "</Person>";
        assertEquals(expected, p1.toXML());
    }

    @Test
    void testToString() {
        String expected = "Person{ID='00000A', firstName='Blake', lastName='Szalapski', title='Mr.', YOB=2002}";
        assertEquals(expected, p1.toString());
    }

    @Test
    void testEquals() {

        assertEquals(p1, p2);
        assertNotEquals(p1, p3);

    }

    @Test
    void testHashCode() {
        assertEquals(p1.hashCode(), p2.hashCode());
        assertNotEquals(p1.hashCode(), p3.hashCode());
    }
}