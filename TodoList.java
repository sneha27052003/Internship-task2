import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoList extends JFrame {
    private DefaultListModel<String> todoListModel;
    private JList<String> todoList;
    private JButton addButton;
    private JButton editButton;
    private JTextField inputField;
     Integer i=1;

    public TodoList() {
       
        setTitle("Todo List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);

        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);
        todoList.setBackground(Color.CYAN);
        Font fo=new Font("Arial",Font.BOLD,20);

        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        inputField = new JTextField(30);
        addButton.setBackground(Color.GREEN);
        editButton.setBackground(Color.ORANGE);

        // JPanel buttonPanel = new JPanel();
        // buttonPanel.setLayout(new FlowLayout());
        // buttonPanel.add(addButton);
        // buttonPanel.add(editButton);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setBackground(Color.DARK_GRAY);
        inputPanel.add(inputField);
       
        inputPanel.add(addButton);
        inputPanel.add(editButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(todoList), BorderLayout.CENTER);
        // add(buttonPanel, BorderLayout.SOUTH);
        add(inputPanel, BorderLayout.NORTH);
    
        todoListModel.addElement("-----------------------------------------------------TODO LIST------------------------------------------------------");
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem = inputField.getText();
                
                
                if (!newItem.isEmpty()) {
                  
                    todoListModel.addElement((i)+") "+ newItem);
                    todoListModel.addElement("_________________________________!!!!!!!!!!__________________________________");
                    inputField.setText("");
                    i=i+1;
                 
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedItem = todoListModel.getElementAt(selectedIndex);
                    String editedItem = JOptionPane.showInputDialog(TodoList.this, "Edit item:", selectedItem);
                    if (editedItem != null && !editedItem.isEmpty()) {
                        todoListModel.set(selectedIndex, editedItem);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TodoList().setVisible(true);
            }
        });
    }
}
