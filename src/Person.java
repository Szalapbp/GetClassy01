import java.util.Objects;
import java.time.LocalDate;

public class Person {

private String ID = "";
private String firstName = "";
private String lastName = "";
private String title = "";
private int YOB = 0;



    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getFullName(){
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getFormalName(){
        return title + " " + getFullName();
    }

    public String toCSV(){
        return ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

    public String toXML(){
        return "<Person>\n" +
                "    <ID>" + ID + "</ID>\n" +
                "    <FirstName>" + firstName + "</FirstName>\n" +
                "    <LastName>" + lastName + "</LastName>\n" +
                "    <Title>" + title + "</Title>\n" +
                "    <YOB>" + YOB + "</YOB>\n" +
                "</Person>";

    }

    public String toJSON(){
        return "{\n" +
                "  \"ID\": \"" + ID + "\",\n" +
                "  \"FirstName\": \"" + firstName + "\",\n" +
                "  \"LastName\": \"" + lastName + "\",\n" +
                "  \"Title\": \"" + title + "\",\n" +
                "  \"YOB\": " + YOB + "\n" +
                "}";
    }

    public int getAge(){
        int currentYear = LocalDate.now().getYear();
        return currentYear - YOB;
    }

    public int getAge(int Year){
        if(YOB > Year)
        {
            throw new IllegalArgumentException("Year selected is before the Year of Birth");
        }
        else
        {
            return Year - YOB;
        }

    }

    @Override
    public String toString() {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && Objects.equals(ID, person.ID) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, title, YOB);
    }
}
