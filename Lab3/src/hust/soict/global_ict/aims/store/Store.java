package store;

import java.util.ArrayList;
import Media.media;

public class Store {
    private final int MAX = 100;
    private ArrayList<media> itemsInStore = new ArrayList<>();

    public media searchTitle(String title) {
        for (media m : itemsInStore) {
            if (title.equals(m.getTitle())) {
                return m;
            }
        }
        return null;
    }

    // Add DVD to Store
    public void addMedia(media n) {
        if (itemsInStore.size() > MAX) {
            System.out.println("The store is Full now!");
        } else { 
            itemsInStore.add(n);
        }
    }

    // Remove DCD
    public void removeMedia(String title) {
        boolean found = false;
        for (media m : itemsInStore) {
            if (title.equals(m.getTitle())) {
                // Found so new remove
                found = true;
                itemsInStore.remove(m);
            }
        }
        if (found == false) {
            System.out.println("Now, in the store, there is not this item");
        }
    } 

    // Print items in cart 
    public void print() {
        System.out.println("*********************************************************************************************************");
        System.out.println("                                                STORE                                                     ");
        int count = 0;
        for (media m : itemsInStore) {
            System.out.println(count + ". " + m.toString());
            count += 1;
        }
        System.out.println("*********************************************************************************************************");
    }

    public void setStore() {
        System.out.println("The current number of items: " + itemsInStore.size());
    } 
}
