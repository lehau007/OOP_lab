import java.util.Scanner;

import Media.media;
import Media.Book;
import Media.Disc;
import Cart.Cart;
import store.Store;
import Media.CompactDisc;

import java.util.ArrayList;

public class Aims {
	// Print the menu and users use
	public static void main(String[] args) {
		Store store = new Store();
		addToStore(store);
		Cart cart = new Cart();
		String strInput;
		
		Scanner scanner = new Scanner(System.in);
		int choice;
		
		do {
			showMenu();
			System.out.print("Your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
				case 1:
					store.print();
					int choice1;
					do {
						storeMenu();
						System.out.print("Your choice: ");
						choice1 = scanner.nextInt();
						scanner.nextLine();
						
						switch(choice1) {
							case 1:
								// See media's detail
								System.out.print("Enter title: ");
								strInput = scanner.nextLine();
								media mediaToSearch = store.searchTitle(strInput);
								if (mediaToSearch == null) System.out.println("Does not exist!");
								else {
									int newChoice1;
									System.out.println(mediaToSearch);
									do {
										mediaDetailsMenu();
										System.out.print("Your choice: ");
										newChoice1 = scanner.nextInt();
										scanner.nextLine();
										
										switch(newChoice1) {
										case 1:
											cart.addMedia(mediaToSearch);
											break;
										
										case 2:
											// Need more
										}
									} while (newChoice1 != 0);
								}
								break;
							case 2:
								// Add to the cart
								System.out.print("Enter title: ");
								strInput = scanner.nextLine();
								media mediaToSearch1 = store.searchTitle(strInput);
								if (mediaToSearch1 == null) {
									System.out.println("Does not exist");
								} else 
									cart.addMedia(mediaToSearch1);
								break;
							case 3:
								// Play
								System.out.print("Enter title: ");
								strInput = scanner.nextLine();
								media mediaToSearch2 = store.searchTitle(strInput);
								if (mediaToSearch2 == null) System.out.println("Does not exist");
								else {
									// Play
								}
								break;
							case 4:
								// See current cart
								cart.print();
								break;
								
							case 0:
								break;
							default:
								System.out.println("Invalid choice!");
						}
					}while (choice1 != 0);
					break;
					
				case 2:
					
					int choice2;
					do {
						System.out.println("1. Add media");
						System.out.println("2. Remove media");
						System.out.println("0. Exit");
						System.out.print("Your choice: ");
						choice2 = scanner.nextInt();
						scanner.nextLine();
						
						switch(choice2) {
						// Add media
						case 1:
							int newChoice2;
							do {
								// Complete compactdisc later
								System.out.println("Choose the type");
								System.out.println("1. DVD");
								System.out.println("2. Book");
								System.out.println("0. Back");
								System.out.print("Your choice: ");
								newChoice2 = scanner.nextInt();
								scanner.nextLine();
								
								// Input the update
								switch(newChoice2) {
									case 1:
										int id, length;
										String title, category, director;
										float cost;
										System.out.print("Enter id: ");
										id = scanner.nextInt();
										scanner.nextLine();
										System.out.print("Enter title: ");
										title = scanner.nextLine();
										System.out.print("Enter category: ");
										category = scanner.nextLine();
										System.out.print("Enter director: ");
										director = scanner.nextLine();
										System.out.print("Enter length: ");
										length = scanner.nextInt();
										scanner.nextLine();
										System.out.print("Enter cost: ");
										cost = scanner.nextFloat();
										scanner.nextLine();
										
										Disc dvd = new Disc(id, title, category, director, length, cost);
										store.addMedia(dvd);
										break;
									case 2:
									
										int id1;
										String title1, category1;
										float cost1;
										System.out.print("Enter id: ");
										id1 = scanner.nextInt();
										scanner.nextLine();
										System.out.print("Enter title: ");
										title1 = scanner.nextLine();
										System.out.print("Enter category: ");
										category1 = scanner.nextLine();
										System.out.print("Enter cost: ");
										cost1 = scanner.nextFloat();
										scanner.nextLine();
										
										Book book = new Book(id1, title1, category1, cost1);
										store.addMedia(book);
										break;
									case 0: 
										break;
									default:
										System.out.println("Invalid choice!");
								}
								
							} while (newChoice2 != 0);
							
						case 2:
							// Remove
							System.out.print("Enter the title: ");
							strInput = scanner.nextLine();
							media mediaToRemove = store.searchTitle(strInput);
							store.removeMedia(mediaToRemove.getTitle());
							break;
							
						case 0:
							break;
						
						default:
							System.out.println("Invalid choice!");
						}
						
					} while (choice2 != 0);
					break;
				
			
				case 3:
					int choice3;
					do {
						cartMenu();
						System.out.print("Your choice: ");
						choice3 = scanner.nextInt();
						scanner.nextLine();
						
						switch(choice3) {
						case 1:
							int newChoice3_1;
							// Filter media in cart
							do {
								System.out.println("1. Search by ID");
								System.out.println("2. Search by title");
								System.out.println("0. Back");
								System.out.print("Your choice: ");
								newChoice3_1 = scanner.nextInt();
								scanner.nextLine();
								switch(newChoice3_1) {
									case 1:
										int idInput = scanner.nextInt();
										scanner.nextLine();
										cart.searchInCart(idInput);
										break;
									case 2:
										strInput = scanner.nextLine();
										cart.searchInCart(strInput);
										break;
									case 0:
										break;
									default:
										System.out.println("Invalid choice!");
								}
								
							} while (newChoice3_1 != 0);
							break;
						case 2:
							// Sort media in cart
							int newChoice3_2;
							do {
								System.out.println("1. Search by title");
								System.out.println("2. Search by cost");
								System.out.println("0. Back");
								System.out.print("Your choice: ");
								newChoice3_2 = scanner.nextInt();
								scanner.nextLine();
								switch(newChoice3_2) {
									case 1:
										// Sort by title
										cart.sortByTitleCost();
										cart.print();
										break;
									case 2:
										// Sort by cost
										cart.sortByCostTitle();
										cart.print();
										break;
									case 0:
										break;
									default:
										System.out.println("Invalid choice!");
								}
								
							} while(newChoice3_2 != 0);
							break;
							
						case 3:
							// Remove media from cart
							System.out.println("Entr the title: ");
							strInput = scanner.nextLine();
							media temp = cart.searchByTitle(strInput);
							cart.removeMedia(temp);
							
							break;
							
						case 4:
							// Play a media
							System.out.println("Enter the title: ");
							strInput = scanner.nextLine();
							media temp2 = cart.searchByTitle(strInput);
							
							if (temp2 == null) System.out.println("Does not exist");
							else {
								// ?
							}
							break;
							
						case 5:
							// Place order
							System.out.println("Successfully created!");
							cart = new Cart();
							break;
						case 0:
							break;
						default:
							System.out.println("Invalid choice!");
						
						}
						
					}while(choice3 !=0);
					break;
					
				case 0:
					break;
				
				default:
					System.out.println("Invalid choice!");
				
			}	
		} while (choice != 0);
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
        System.out.println("------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
        System.out.println("-------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	public static void addToStore(Store store) {
		Disc dvd1 = new Disc(1, "The lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		
		Disc dvd2 = new Disc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		
		Disc dvd3 = new Disc(3, "Aladin", "Animation", "Hau", 84, 18.99f);
		store.addMedia(dvd3);
		
		String[] author1 = new String[2];
		author1[0] = ("Munwind");
		author1[1] = ("Lehau");
		
		String[] author2 = new String[2];
		author2[0] = ("Minh");
		author2[1] = ("Kien");
		
		Book book1 = new Book(3, "LeHau finds his first love", "No hope", 99.99f, author1);
		store.addMedia(book1);
		Book book2 = new Book(4, "We are ones", "The Hunt", 1.1f, author2);
		store.addMedia(book2);
		
	}
}