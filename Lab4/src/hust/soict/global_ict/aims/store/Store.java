package hust.soict.global_ict.aims.store;

import java.util.ArrayList;
import hust.soict.global_ict.aims.media.Media;

public class Store {
	private ArrayList <Media> itemsInStore = new ArrayList <Media>();
	
	public ArrayList <Media> getItems(){
		return itemsInStore;
	}
	
	public void addMedia(Media disc) {
		itemsInStore.add(disc);
		System.out.println("Add Successfully");
	}
	
	public void removeMedia(Media disc) {
		if (itemsInStore.contains(disc)) {
			itemsInStore.remove(disc);
			System.out.println("Remove successfullly!");
		}
		else System.out.println("Does not exist!");
	}
	
	public Media searchByTitle(String title) {
		for (Media element : itemsInStore) {
			if (title.equals(element.getTitle())) {
				return element;
			}
			
		}
		return null;
	}
	
	public void displayInfo() {
		System.out.println("**********Store**********");
		System.out.println("Items: ");
		
		int count = 1;
		for (Media item : itemsInStore) {
			System.out.println(count + " - " + item);
			count += 1;
		}
		System.out.println("*************************");
	}
}	

