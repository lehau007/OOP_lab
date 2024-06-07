package AimsProject.hust.soict.globalict.aims.screen.manager;

import AimsProject.hust.soict.globalict.aims.media.book.Book;
import AimsProject.hust.soict.globalict.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBooktoScreen extends JFrame  implements ActionListener {
    private final JButton addBook;
    private final JButton addAuthor;
    private Book book;
    private final Store store;
    private final JTextField idTF;
    private final JTextField costTF;
    private final JTextField titleTF;
    private final JTextField categoryTF;
    private final JTextField authorTF;

    public AddBooktoScreen(Store store){
        this.store = store; // Initialize the store object
        setLayout(new FlowLayout());
        setSize(350,300);

        JPanel idPanel = new JPanel();
        idPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        idPanel.add(new JLabel("ID: "));
        idTF = new JTextField(20);
        idPanel.add(idTF);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("Title: "));
        titleTF = new JTextField(20);
        titlePanel.add(titleTF);

        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new FlowLayout());
        categoryPanel.add(new JLabel("Category: "));
        categoryTF = new JTextField(20);
        categoryPanel.add(categoryTF);

        JPanel costPanel = new JPanel();
        costPanel.setLayout(new FlowLayout());
        costPanel.add(new JLabel("Cost: "));
        costTF = new JTextField(20);
        costPanel.add(costTF);

        JPanel authorPanel = new JPanel();
        authorPanel.setLayout(new FlowLayout());
        authorPanel.add(new JLabel("Author: "));
        authorTF = new JTextField(15);
        authorPanel.add(authorTF);
        addAuthor = new JButton("ADD");
        addAuthor.addActionListener(this);
        authorPanel.add(addAuthor);

        JPanel addButtonPanel = new JPanel();
        addButtonPanel.setLayout(new BorderLayout());
        addBook = new JButton("ADD BOOK");
        addBook.addActionListener(this);
        addButtonPanel.add(addBook, BorderLayout.CENTER);

        add(idPanel);
        add(titlePanel);
        add(categoryPanel);
        add(costPanel);
        add(authorPanel);
        add(addButtonPanel);
        setTitle("ADD BOOK TO THE STORE");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBook) {
            try {
                int id = Integer.parseInt(idTF.getText());
                String title = titleTF.getText();
                String category = categoryTF.getText();
                float cost = Float.parseFloat(costTF.getText());
                book = new Book(id, title, category, cost);
                System.out.println(book);
                store.addMedia(book);
                store.printStore();
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == addAuthor) {
            if (book != null) {
                String author = authorTF.getText();
                book.addAuthor(author);
                System.out.println(book);
            }
        }
    }
}
