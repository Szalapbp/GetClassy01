import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.ArrayList;

public class RandProductSearch extends JFrame
{
    private JTextField searchField;
    private JButton searchBtn;
    private JTextArea resultsArea;

    public RandProductSearch()
    {
        setTitle("Search Product");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter partial name:"));
        searchField = new JTextField(20);
        topPanel.add(searchField);

        searchBtn = new JButton("Search");
        topPanel.add(searchBtn);

        add(topPanel, BorderLayout.NORTH);

        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        add(new JScrollPane(resultsArea), BorderLayout.CENTER);

        searchBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                searchProducts();
            }
        });
    }

    private void searchProducts(){
        String searchTerm = searchField.getText().trim().toLowerCase();
        resultsArea.setText("");

        try(RandomAccessFile file = new RandomAccessFile("products.dat", "r")){
            List<String> matchingProducts = new ArrayList<>();

            while (file.getFilePointer()< file.length())
            {
                String id = file.readUTF().trim();
                String name = file.readUTF().trim();
                String description = file.readUTF().trim();
                double cost = file.readDouble();

                if(name.toLowerCase().contains(searchTerm))
                {
                    matchingProducts.add(String.format("%s - %s ($%.2f)\nDescription: %s\n", id, name, cost, description));
                }
            }

            if(matchingProducts.isEmpty())
            {
                resultsArea.append("No matches found.\n");
            }
            else
            {
                for(String product : matchingProducts)
                {
                    resultsArea.append(product + "\n");
                }
            }
        }catch(IOException ex)
        {
            ex.printStackTrace();
            resultsArea.append("Error reading file.\n");
        }
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new RandProductSearch().setVisible(true));
    }
}
