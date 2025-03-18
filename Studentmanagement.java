import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Studentmanagement extends JFrame {
    // Declare variables
    public JTextField Namef, Idf, Agef, OperationIdf;
    public JPanel panel, NamePan, AgePan, IdPan, subPan, panel2, operationPanel;
    public JButton btn, Namebt, Agebt, Idbt, Add, Display, Update, Delete, Search;
    public JTable table;
    public DefaultTableModel model;

    public void studentInfo() {
        panel = new JPanel(new GridLayout(4, 2));

        NamePan = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        Namebt = new JButton("Name");
        Namef = new JTextField(15);

        NamePan.add(Namebt);
        NamePan.add(Namef);
        panel.add(NamePan);

        AgePan = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        Agebt = new JButton("Age");
        Agef = new JTextField(15);

        AgePan.add(Agebt);
        AgePan.add(Agef);
        panel.add(AgePan);

        IdPan = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        Idf = new JTextField(15);
        Idbt = new JButton("ID");

        IdPan.add(Idbt);
        IdPan.add(Idf);
        panel.add(IdPan);

        subPan = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 5));
        Add = new JButton("Add");
        subPan.add(Add);
        panel.add(subPan);

        add(panel, BorderLayout.NORTH);

      
        JPanel bottomPanel = new JPanel(new BorderLayout());

        
        operationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        OperationIdf = new JTextField(15);
        JLabel operationLabel = new JLabel("Enter ID for operations:");
        operationPanel.add(operationLabel);
        operationPanel.add(OperationIdf);
    
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        Display = new JButton("Display");
        Search = new JButton("Search");
        Update = new JButton("Update");
        Delete = new JButton("Delete");
        
        buttonPanel.add(Display);

        buttonPanel.add(Search);

        buttonPanel.add(Update);

        buttonPanel.add(Delete);

        bottomPanel.add(operationPanel, BorderLayout.NORTH);

        bottomPanel.add(buttonPanel, BorderLayout.CENTER);
        
        
        add(bottomPanel, BorderLayout.SOUTH);

        String[] column = {"Name", "Age", "ID"};
         model = new DefaultTableModel(column, 0);
         table = new JTable(model);

          JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = Namef.getText();
                String id = Idf.getText();
                String age = Agef.getText();
                if (!id.isEmpty() && !name.isEmpty() && !age.isEmpty()) {

                    model.addRow(new Object[]{name, age, id});
                    clearInputFields();
                } 
                else
                 {

                    JOptionPane.showMessageDialog(null, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
                }
                }
        });

        Display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No records to display", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                }
        });

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String operationId = OperationIdf.getText();
                if (operationId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter an ID to search", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                boolean found = false;
                
                for (int i = 0; i < table.getRowCount(); i++) {
                    String tableId = (String) table.getValueAt(i, 2);
                    
                    if (tableId.equals(operationId)) {
                        String name = (String) table.getValueAt(i, 0);
                        String age = (String) table.getValueAt(i, 1);
                        JOptionPane.showMessageDialog(null, 
                            "Student Details:\n Name: " + name + "\n Age: " + age + "\nId: " + operationId, " Student Information", JOptionPane.INFORMATION_MESSAGE);
                        found = true;
                        break;
                    } 
                }
                
                if (! found) {
                    JOptionPane.showMessageDialog(null, "ID not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String operationId = OperationIdf.getText();
                if (operationId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "  enter Id to update", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                 
                boolean found = false;
                
                for (int i = 0; i < table.getRowCount(); i++) 
                {
                    String tableId = (String) table.getValueAt(i, 2);
                    
                 if (tableId.equals(operationId))
                  {
                    String name = (String) table.getValueAt(i, 0);
                    String age = (String) table.getValueAt(i, 1);
                        String newName = JOptionPane.showInputDialog(null, " new name ", name);
                        String newAge = JOptionPane.showInputDialog(null, " new age ", age);
                        
                        if (newName != null && newAge != null && !newName.isEmpty() && !newAge.isEmpty())
                         {
                            model.setValueAt(newName, i, 0);
                            model.setValueAt(newAge, i, 1);
                            OperationIdf.setText(""); 
                        }
                        found = true;
                        break;
                    }
                }
                
                if (!found)
                 {
                    JOptionPane.showMessageDialog(null, "ID not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        Delete.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            String operationId = OperationIdf.getText();
            if (operationId.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null, "enter an ID to delete", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
               
                boolean found = false;
                
            for (int i = 0; i < table.getRowCount(); i++) 
            {
             String tableId = (String) table.getValueAt(i, 2);

             if (tableId.equals(operationId)) 
            {
             int confirm = JOptionPane.showConfirmDialog(null,  "uu want to delete", "Confirm Delete", 
            JOptionPane.YES_NO_OPTION);
                        
            if (confirm == JOptionPane.YES_OPTION)
             {
             model.removeRow(i);
            OperationIdf.setText("");
              }
               found = true;
              break;
            }
                }
                
                if (!found)
                 {
                 JOptionPane.showMessageDialog(null, "ID not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setTitle("Student Management");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void clearInputFields() 
    {
        Namef.setText("");
        Agef.setText("");
        Idf.setText("");
    }

    public static void main(String[] args) {
        Studentmanagement sm = new Studentmanagement();
        sm.studentInfo();
    }
}