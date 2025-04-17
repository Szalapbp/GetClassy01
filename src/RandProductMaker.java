import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandProductMaker extends JFrame
{
    private JTextField nameField, descriptionField, idField, costField, countField;
    private JButton addBtn, clearBtn;
    private int recordCount = 0;

    public RandProductMaker()
    {
        setTitle("Random Product Maker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("ID:"));
        idField = new JTextField(6);
        add(idField);

        add(new JLabel("Name:"));
        nameField = new JTextField(35);
        add(nameField);

        add(new JLabel("Description:"));
        descriptionField = new JTextField(75);
        add(descriptionField);

        add(new JLabel("Cost:"));
        costField = new JTextField();
        add(costField);

        add(new JLabel("Count:"));
        countField = new JTextField("0");
        countField.setEditable(false);
        add(countField);

        addBtn = new JButton("Add");
        add(addBtn);

        clearBtn = new JButton("Clear");
        add(clearBtn);

        addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addRecord();
            }
        });
        clearBtn.addActionListener(e -> clearFields());
    }
    private void addRecord(){
        String name = String.format("%-35s", nameField.getText().trim());
        String description = String.format("%-75s", descriptionField.getText().trim());
        String id = String.format("%-6s", idField.getText().trim());
        double cost = Double.parseDouble(costField.getText().trim());

        try (RandomAccessFile file = new RandomAccessFile("products.dat", "rw")){
            file.seek(file.length());
            file.writeUTF(id);
            file.writeUTF(name);
            file.writeUTF(description);
            file.writeDouble(cost);
            recordCount++;
            countField.setText(String.valueOf(recordCount));
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private void clearFields(){
        nameField.setText("");
        descriptionField.setText("");
        idField.setText("");
        costField.setText("");
    }

    public static void main(String[] atgs) {
        SwingUtilities.invokeLater(()-> new RandProductMaker().setVisible(true));
    }
}
