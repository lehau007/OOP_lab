import Cart.Cart;
import Media.Disc;

public class CartTest {
    public static void main(String[] args) {
        // Can access into the Cart
        Cart anOrder = new Cart();
        Disc dvd1 = new Disc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addMedia(dvd1);

        Disc dvd2 = new Disc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addMedia(dvd2);

        Disc dvd3 = new Disc(3, "Aladdin", "Animation", 18.99f);
        anOrder.addMedia(dvd3);

        // Top 1 my favorite
        Disc dvd4 = new Disc(4, "Conan Movie 26: Black Iron Submarine", "Animation", 18.99f); // Added full title
        anOrder.addMedia(dvd4);
        
        Disc dvd5 = new Disc(5, "Your Name", "Animation", "Makoto Shinkai", 129, 22.99f);
        anOrder.addMedia(dvd5);
        
        Disc dvd6 = new Disc(6, "Spirited Away", "Animation", "Hayao Miyazaki", 125, 21.99f);
        anOrder.addMedia(dvd6);

        anOrder.print();
    }
}
