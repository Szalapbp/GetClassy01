import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args)
    {
        boolean doneInput = false;

        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;
        ArrayList<Person> people = new ArrayList<>();


        Scanner in = new Scanner(System.in);

        do{
            ID = SafeInput.getNonZeroLenString(in, "Enter your ID [######]");
            firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
            title = SafeInput.getNonZeroLenString(in, "Enter your title");
            YOB = SafeInput.getRangedInt(in, "Enter your year of birth", 1000, 9999);

            Person person = new Person(ID, firstName, lastName, title, YOB);
            System.out.println(person);

            people.add(person);

            doneInput = SafeInput.getYNConfirm(in,"Are you done? [Y/N]");

        }while(!doneInput);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");

        try {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(Person person : people) {
                writer.write(person.toString(), 0, person.toString().length());
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
