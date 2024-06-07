package AimsProject.hust.soict.globalict.aims.screen.manager;

import AimsProject.hust.soict.globalict.aims.media.book.Book;
import AimsProject.hust.soict.globalict.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBooktoScreen_1 extends JFrame implements ActionListener {
    private final JButton addBook;
    private final JButton addAuthor;
    private Book book;
    private final Store store;
    private final JTextField idTF;
    private final JTextField costTF;
    private final JTextField titleTF;
    private final JTextField categoryTF;
    private final JTextField authorTF;

    public AddBooktoScreen_1(Store store) {
        this.store = store;
        setLayout(new GridBagLayout());
        setSize(400, 300);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        add(new JLabel("ID: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        idTF = new JTextField(20);
        add(idTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        add(new JLabel("Title: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        titleTF = new JTextField(20);
        add(titleTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        add(new JLabel("Category: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        categoryTF = new JTextField(20);
        add(categoryTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        add(new JLabel("Cost: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        costTF = new JTextField(20);
        add(costTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        add(new JLabel("Author: "), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        authorTF = new JTextField(15);
        add(authorTF, gbc);

        gbc.gridx = 2;
        gbc.weightx = 0;
        addAuthor = new JButton("ADD");
        addAuthor.addActionListener(this);
        add(addAuthor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        addBook = new JButton("ADD BOOK");
        addBook.addActionListener(this);
        add(addBook, gbc);
        setBackground(Color.lightGray);
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
