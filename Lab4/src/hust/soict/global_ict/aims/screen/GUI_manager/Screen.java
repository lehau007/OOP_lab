package hust.soict.global_ict.aims.screen.GUI_manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.global_ict.aims.store.Store;

public abstract class Screen extends JFrame implements ActionListener {
    
    protected Store store;
    
    public Screen(Store store){
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Option");

        JMenuItem viewStoreMenuItem = new JMenuItem("View Store");
        viewStoreMenuItem.addActionListener(this); // Add action listener
        menu.add(viewStoreMenuItem);

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenuItem = new JMenuItem("Add Book");
        addBookMenuItem.addActionListener(this); // Add action listener
        smUpdateStore.add(addBookMenuItem);
        JMenuItem addCDMenuItem = new JMenuItem("Add CD");
        addCDMenuItem.addActionListener(this); // Add action listener
        smUpdateStore.add(addCDMenuItem);
        JMenuItem addDVDMenuItem = new JMenuItem("Add DVD");
        addDVDMenuItem.addActionListener(this); // Add action listener
        smUpdateStore.add(addDVDMenuItem);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;

    }
    
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());

        JLabel title = new JLabel("AIMS", JLabel.CENTER);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.BLACK);

        header.add(title, BorderLayout.CENTER);

        return header;
    }
    
    abstract JPanel createCenter();
    public abstract void actionPerformed(ActionEvent e);
    
}
