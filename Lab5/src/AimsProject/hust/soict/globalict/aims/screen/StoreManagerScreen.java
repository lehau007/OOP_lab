package AimsProject.hust.soict.globalict.aims.screen;

import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.book.Book;
import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.screen.manager.*;
import AimsProject.hust.soict.globalict.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame{
    private final Store store;

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Option");
        menu.add(new JMenuItem("View store"));
        JMenu smUpdateStore = new JMenu("Update store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBooktoScreen_1(store);
            }
        });
        smUpdateStore.add(addBook);

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDVDtoScreen_1(store);
            }
        });
        smUpdateStore.add(addDVD);

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCDtoScreen_1(store);
            }
        });
        smUpdateStore.add(addCD);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font("JetBrains Mono",Font.PLAIN, 50));
        title.setForeground(Color.decode("#020826"));
        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.setBackground(Color.decode("#eaddcf"));
        return header;
    }

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JPanel createCenter(){

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));

        ArrayList<Media> mediaInStore = store.itemsInStore;
        for (int i = 0; i < 9; i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        return center;

    }

    public StoreManagerScreen(Store store){
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),BorderLayout.NORTH);
        cp.add(createCenter());
        setTitle("Store");
        setSize(1024,720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static Store initStore(){
        Store newStore = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"Harry Potter and the Philosopher's Stone(2001)","Fantasy",3.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,"Harry Potter and the Chamber of Secrets(2002)","Fantasy",3.5f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3,"Harry Potter and the Prisoner of Azkaban(2004)","Fantasy",5.0f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(4,"Harry Potter and the Goblet of Fire(2006)","Fantasy",4.5f);
        CompactDisc cd5 = new CompactDisc(5,"Fetch the Bolt Cutters","Unknown",10.39f);
        CompactDisc cd6 = new CompactDisc(6,"Future Nostalgia","Unknown",9.6f);
        Book book7 = new Book(7,"The Hunger Games","Unknown",5.5f);
        Book book8 = new Book(8,"Catching Fire","Unknown",4.9f);
        Book book9 = new Book(9,"Mockingjay","Unknown",5.1f);
        newStore.addMedia(dvd1);
        newStore.addMedia(dvd2);
        newStore.addMedia(dvd3);
        newStore.addMedia(dvd4);
        newStore.addMedia(cd5);
        newStore.addMedia(cd6);
        newStore.addMedia(book7);
        newStore.addMedia(book8);
        newStore.addMedia(book9);
        return newStore;
    }
    public static void main(String[] args){
        Store newStore = initStore();
        new StoreManagerScreen(newStore);
    }
}
