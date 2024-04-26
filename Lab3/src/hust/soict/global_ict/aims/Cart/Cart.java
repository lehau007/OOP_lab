package Cart;

import Media.media;// Assuming you have a Disc package with DigitalVideoDisc class
import java.util.ArrayList;

public class Cart {
    private static final int MAX_ITEMS = 20;
    private ArrayList<media> itemsOrdered = new ArrayList<>();

    // Print items in cart
    public void print() {
        System.out.println("*********************************************************************************************************");
        int count = 0;
        System.out.println("                                                CART                                                     ");
        for (media m : itemsOrdered) {
            System.out.println(count + ". " + m.toString());
            count += 1;
        }
        System.out.println("Total: " + this.calculateTotalCost());
        System.out.println("*********************************************************************************************************");
    }

    // Add
    public void addMedia(media sth) {
        if (itemsOrdered.size() < MAX_ITEMS) {
            itemsOrdered.add(sth);
        } else {
            System.out.println("Max items");
        }
    }

    // Remove 
    public void removeMedia(media needDelete) {
        boolean found = false;
        for (media m : itemsOrdered) {
            if (m.getTitle().equals(needDelete.getTitle())) { // Use equals() for string comparison
                found = true;
                itemsOrdered.remove(m);
                break;
            }
        }
        if (!found) {
            System.out.println("DVD \"" + needDelete.getTitle() + "\" not found in the cart.");
        }
    }

    public media searchByTitle(String searchTitle) {
        for (media m : itemsOrdered) {
            if (m.getTitle().equalsIgnoreCase(searchTitle)) {
                return m;
            }
        }
        System.out.println("Media \"" + searchTitle + "\" not found in the cart.");
        return null;
    }

    public media searchById(int searchId) {
        for (media m : itemsOrdered) {
            if (m.getId() == searchId) {
                return m;
            }
        }
        System.out.println("Media \"" + searchId + "\" not found in the cart.");
        return null;
    }

    public media searchInCart(String title) {
        return searchByTitle(title);
    }

    public media searchInCart(int id) {
        return searchById(id);
    }

    public void sortByTitleCost() {
        itemsOrdered.sort((m1, m2) -> {
            int titleComparison = m1.getTitle().compareToIgnoreCase(m2.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }
            return Float.compare(m1.getCost(), m2.getCost());
        });
    }
    
    public void sortByCostTitle() {
        itemsOrdered.sort((m1, m2) -> {
            int costComparison = Float.compare(m1.getCost(), m2.getCost());
            if (costComparison != 0) {
                return costComparison;
            }
            return m1.getTitle().compareToIgnoreCase(m2.getTitle());
        });
    }
    
    // Compute total cost
    public float calculateTotalCost() {
        float res = 0;
        for (media m : itemsOrdered) {
            res += m.getCost();
        }
        return res;
    }
}
