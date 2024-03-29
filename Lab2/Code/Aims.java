import java.util.Scanner;

public class Aims {

    // An example for userid and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.println("Welcome to the AIMS System");
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        if (!login(enteredUsername, enteredPassword)) {
            System.out.println("Incorrect username or password. Exiting the program.");
            scanner.close();
            return;
        }

        System.out.println("Login successful.");
        // Can access into the Cart
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDVDToCart(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDVDToCart(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        anOrder.addDVDToCart(dvd3);

        // Top 1 my favorite
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Conan Movie 26: Black Iron Submarine", "Animation", 18.99f); // Added full title
        anOrder.addDVDToCart(dvd4);
        
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Your Name", "Animation", "Makoto Shinkai", 129, 22.99f);
        anOrder.addDVDToCart(dvd5);
        
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 21.99f);
        anOrder.addDVDToCart(dvd6);

        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Casablanca", "Romance, Drama", "Michael Curtiz", 102, 17.99f);
        anOrder.addDVDToCart(dvd7);

        DigitalVideoDisc dvd8 = new DigitalVideoDisc("The Godfather", "Crime Drama", "Francis Ford Coppola", 175, 25.99f);
        anOrder.addDVDToCart(dvd8);

        // Sci-Fi/Fantasy
        DigitalVideoDisc dvd9 = new DigitalVideoDisc("The Matrix", "Action, Sci-Fi", "The Wachowskis", 136, 19.99f);
        anOrder.addDVDToCart(dvd9);

        DigitalVideoDisc dvd10 = new DigitalVideoDisc("Blade Runner", "Sci-Fi, Neo-Noir", " Ridley Scott", 117, 18.99f);
        anOrder.addDVDToCart(dvd10);

        // Action/Adventure
        DigitalVideoDisc dvd11 = new DigitalVideoDisc("Raiders of the Lost Ark", "Action, Adventure", "Steven Spielberg", 115, 19.99f);
        anOrder.addDVDToCart(dvd11);

        DigitalVideoDisc dvd12 = new DigitalVideoDisc("Kill Bill: Vol. 1", "Action, Crime", "Quentin Tarantino", 111, 22.99f);
        anOrder.addDVDToCart(dvd12);

        // Comedy
        DigitalVideoDisc dvd13 = new DigitalVideoDisc("Monty Python and the Holy Grail", "Comedy", "Terry Gilliam and Terry Jones", 91, 16.99f);
        anOrder.addDVDToCart(dvd13);

        DigitalVideoDisc dvd14 = new DigitalVideoDisc("Groundhog Day", "Comedy, Fantasy", "Harold Ramis", 101, 17.99f);
        anOrder.addDVDToCart(dvd14);


        anOrder.removeDVDFromCart(dvd2);

        System.out.print("Total cost is ");
        System.out.println(anOrder.calculateTotalCost());

        scanner.close();
    }

    // Method to check login credentials
    private static boolean login(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}
