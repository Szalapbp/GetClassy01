import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args)
    {
        boolean doneInput = false;

        String ID = "";
        String Name = "";
        String Description = "";
        String rec ="";
        Double Cost = 0.0;
        ArrayList<Product> product = new ArrayList<>();


        Scanner in = new Scanner(System.in);

        //Create a loop to input the person data
        do{
            ID = SafeInput.getNonZeroLenString(in, "Enter the product ID [######]");
            Name = SafeInput.getNonZeroLenString(in, "Enter the product name");
            Description = SafeInput.getNonZeroLenString(in, "Enter the product description");
            Cost = SafeInput.getRangedDouble(in, "Enter the product cost", 1.00, 99999999.00);



            Product item = new Product(ID, Name, Description, Cost);
            System.out.println(item);
            product.add(item);

            doneInput = SafeInput.getYNConfirm(in,"Are you done? [Y/N]");

        }while(!doneInput);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        try {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(Product item: product)
            {
                writer.write(item.toString(), 0, item.toString().length());
                writer.newLine();
            }

            writer.close();
            System.out.println("Data file written!");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
