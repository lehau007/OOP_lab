package hust.soict.global_ict.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.global_ict.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ArrayList <Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsOrdered.contains(media))
			System.out.println("This media exist!");
		else {
			itemsOrdered.add(media);
			System.out.println("Successfully added");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Successfully removed");
		}
		else
			System.out.println("The media does not exist!");
	}
	
	public Media search(String title) {
		for (Media element : itemsOrdered) {
			if (title.equals(element.getTitle())) return element;
		}
		return null;
	}
	
	public float totalCost() {
		float total_cost = 0;
		for (Media dvd : itemsOrdered) {
			if (dvd != null) total_cost += dvd.getCost();
		}
		
		return total_cost;
	}
	
	// Keep track of the number of DVDs
	public int qtyOrdered() {
		int count = 0;
		for (Media dvd : itemsOrdered) {
	        if (dvd != null) {
	            count++;
	        }
	    }
		return count;
	}
	
	public void displayInfo() {
		System.out.println("**********CART**********");
		System.out.println("Ordered Items: ");
		
		int count = 1;
		for (Media item : itemsOrdered) {
			if (item == null) break;
			System.out.println(count + " - " + item);
			count += 1;
		}
			
		System.out.println("Total Cost = " + totalCost());
		System.out.println("************************");
	}
	
	public void searchInCart(int id) {
		for (Media element : itemsOrdered) {
			if (element.getId() == id) {
				System.out.println(element);
				return;
			}
		}
		System.out.println("Does not exist!");
	}
	
	public void searchInCart(String title) {
		for (Media element : itemsOrdered) {
			if (element.isMatch(title)) {
				System.out.println(element);
				return;
			}
		}
		System.out.println("Does not exist!");
	}
	
	// Check these functions
	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
}

