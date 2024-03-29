import java.util.Arrays;

public class Cart {
    private static final int MAX_ITEMS = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_ITEMS];

    // Add a DVD to the cart
    public void addDVDToCart(DigitalVideoDisc disc) {
        int index = getCurrentQuantity();
        if (index >= MAX_ITEMS) {
            System.out.println("Sorry! The cart is full!");
        } else {
            itemsOrdered[index] = disc;
            System.out.println("DVD \"" + disc.getTitle() + "\" added to the cart.");
        }
    }

    // Remove a DVD from the cart
    public void removeDVDFromCart(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < itemsOrdered.length; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                System.arraycopy(itemsOrdered, i + 1, itemsOrdered, i, itemsOrdered.length - 1 - i);
                itemsOrdered[itemsOrdered.length - 1] = null;
                System.out.println("DVD \"" + disc.getTitle() + "\" removed from the cart.");
                break;
            }
        }
        if (!found) {
            System.out.println("DVD \"" + disc.getTitle() + "\" not found in the cart.");
        }
    }

    // Compute total cost
    public float calculateTotalCost() {
        return Arrays.stream(itemsOrdered)
                .filter(dvd -> dvd != null)
                .map(DigitalVideoDisc::getCost)
                .reduce(0.0f, Float::sum);
    }

    // Get the current quantity of items in the cart
    public int getCurrentQuantity() {
        return (int) Arrays.stream(itemsOrdered).filter(dvd -> dvd != null).count();
    }
}
