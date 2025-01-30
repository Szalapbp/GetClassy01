import java.util.Objects;
import java.time.LocalDate;

public class Product {

    String ID = "";
    String Name = "";
    String Description = "";
    Double Cost = 0.0;


    public Product(String ID, String name, String description, Double cost) {
        this.ID = ID;
        Name = name;
        Description = description;
        Cost = cost;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getCost() {
        return Cost;
    }

    public void setCost(Double cost) {
        Cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Cost=" + Cost +
                '}';
    }

    public String toCSV(){
        return ID + "," + Name + "," + Description + "," + Cost;
    }

    public String toXML(){
        return "<Product>\n" +
                "    <ID>" + ID + "</ID>\n" +
                "    <Name>" + Name + "</Name>\n" +
                "    <Description>" + Description + "</Description>\n" +
                "    <Cost>" + Cost + "</Cost>\n" +
                "</Product>";

    }

    public String toJSON(){
        return "{\n" +
                "  \"ID\": \"" + ID + "\",\n" +
                "  \"Name\": \"" + Name + "\",\n" +
                "  \"Description\": \"" + Description + "\",\n" +
                "  \"Cost\": " + Cost + "\n" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(ID, product.ID) && Objects.equals(Name, product.Name) && Objects.equals(Description, product.Description) && Objects.equals(Cost, product.Cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, Name, Description, Cost);
    }
}
