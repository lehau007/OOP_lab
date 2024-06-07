package AimsProject.hust.soict.globalict.aims;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.book.Book;
import AimsProject.hust.soict.globalict.aims.media.disc.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.media.disc.Track;
import AimsProject.hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.exception.LimitExceededException;
import hust.soict.globalict.aims.exception.PlayerException;

import java.util.Random;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) throws PlayerException, LimitExceededException {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        store.init();
        Cart cart = new Cart();
        int menuChoice = -1;
        while (menuChoice != 0) {
            showMenu();
            try {
                menuChoice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e){
                System.out.print("Please enter a valid integer. ");
                scanner.nextLine();
            }
            switch (menuChoice){
                case 1:
                    int storeChoice = -1;
                    while (storeChoice != 0){
                        store.printStore();
                        storeMenu();
                        try {
                            storeChoice = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e){
                            System.out.print("Please enter a valid integer. ");
                            scanner.nextLine();
                        }
                        switch (storeChoice){
                            case 1:
                                String title1;
                                try{
                                    System.out.print("Enter the title of the media: ");
                                    title1 = scanner.nextLine();
                                    Media item1 = store.searchTitle(title1);
                                    if (item1 == null){
                                        System.out.println("Invalid title");
                                    } else {
                                        System.out.println(item1);
                                    }
                                    int mediaChoice = -1;
                                    while(mediaChoice != 0){
                                        mediaDetailsMenu();
                                        try {
                                            mediaChoice = scanner.nextInt();
                                            scanner.nextLine();
                                        } catch (Exception e){
                                            System.out.print("Please enter a valid integer. ");
                                            scanner.nextLine();
                                        }
                                        switch (mediaChoice){
                                            case 1:
                                                cart.addMedia(item1, store);
                                                break;
                                            case 2:
                                                if (item1 instanceof CompactDisc temp){
                                                    temp.play();
                                                } else if (item1 instanceof DigitalVideoDisc temp){
                                                    temp.play();
                                                } else {
                                                    System.out.println("Cannot play");
                                                }
                                                break;
                                            case 0:
                                                System.out.println("BACK");
                                                break;
                                            default:
                                                System.out.println("Invalid choice");
                                                break;
                                        }
                                    }
                                } catch (Exception e){
                                    System.out.println("The given title is not valid");
                                }
                                break;
                            case 2:
                                String title2;
                                store.printStore();
                                System.out.print("Enter the title of the media: ");
                                title2 = scanner.nextLine();
                                Media item2 = store.searchTitle(title2);
                                if (item2 == null){
                                    System.out.println("Invalid title");
                                } else {
                                    cart.addMedia(item2, store);
                                }
                                System.out.println("There are " + cart.getSize() +" items in the cart");
                                break;
                            case 3:
                                String title3;
                                store.printStore();
                                System.out.print("Enter the title of the media: ");
                                title3 = scanner.nextLine();
                                Media item3 = store.searchTitle(title3);
                                if (item3 == null){
                                    System.out.println("Invalid title");
                                } else {
                                    if (item3 instanceof CompactDisc temp){
                                    	try {
                                    		temp.play();
                                    	} catch(PlayerException e) {
                                    		throw e;
                                    	}
                                    } else if (item3 instanceof DigitalVideoDisc temp){
                                    	try {
                                    		temp.play();
                                    	} catch(PlayerException e) {
                                    		throw e;
                                    	}
                                    } else {
                                        System.out.println("Cannot play");
                                    }
                                }
                                break;
                            case 4:
                                int cartChoice = -1;
                                cart.printCart();
                                do {
                                    cartMenu();
                                    try {
                                        cartChoice = scanner.nextInt();
                                        scanner.nextLine();
                                    } catch (Exception e){
                                        scanner.nextLine();
                                    }
                                    switch (cartChoice){
                                        case 1:
                                            cart.printCart();
                                            System.out.print("Enter choice (ID/Title): ");
                                            String filterChoice = scanner.nextLine();
                                            switch (filterChoice){
                                                case "ID":
                                                    int id = -1;
                                                     try {
                                                         System.out.print("Enter id: ");
                                                         id = scanner.nextInt();
                                                         scanner.nextLine();
                                                     } catch (Exception e){
                                                         scanner.nextLine();
                                                     }
                                                    if (cart.searchID(id) != null){
                                                        System.out.println(cart.searchID(id));
                                                    } else {
                                                        System.out.println("Cannot filter the given id");
                                                    }
                                                    break;
                                                case "Title":
                                                    System.out.print("Enter title: ");
                                                    String searchTitle = scanner.nextLine();
                                                    if (cart.searchTitle(searchTitle) != null){
                                                        System.out.println(cart.searchTitle(searchTitle));
                                                    } else {
                                                        System.out.println("Cannot filter the given title");
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Invalid Choice");
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            System.out.print("Enter choice (Title/Cost): ");
                                            String sortChoice = scanner.nextLine();
                                            switch (sortChoice){
                                                case "Title":
                                                    cart.sortByTitle();
                                                    cart.printCart();
                                                    break;
                                                case "Cost":
                                                    cart.sortByCost();
                                                    cart.printCart();
                                                    break;
                                                default:
                                                    System.out.println("Invalid Choice");
                                                    break;
                                            }
                                            break;
                                        case 3:
                                            cart.printCart();
                                            System.out.print("Enter the title of the media: ");
                                            String removeTitleInCart = scanner.nextLine();
                                            if (cart.searchTitle(removeTitleInCart) == null){
                                                System.out.println("Cannot remove the media");
                                            } else {
                                                cart.removeMedia(store.searchTitle(removeTitleInCart));
                                            }
                                            break;
                                        case 4:
                                            cart.printCart();
                                            String playTitle;
                                            System.out.print("Enter the title of the media: ");
                                            playTitle = scanner.nextLine();
                                            Media itemPlay = cart.searchTitle(playTitle);
                                            if (itemPlay == null){
                                                System.out.println("Invalid title");
                                            } else {
                                                if (itemPlay instanceof CompactDisc temp){
                                                    temp.play();
                                                } else if (itemPlay instanceof DigitalVideoDisc temp){
                                                    temp.play();
                                                } else {
                                                    System.out.println("Cannot play");
                                                }
                                            }
                                            break;
                                        case 5:
                                            if (cart.getSize() > 0){
                                                cart.clearItems();
                                                System.out.println("The order is created!!");
                                            } else {
                                                System.out.println("There's nothing in the cart");
                                            }
                                            break;
                                        case 0:
                                            System.out.println("BACK");
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                } while (cartChoice != 0);
                                break;
                            case 0:
                                System.out.println("BACK");
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                    }
                    break;
                case 2:
                    String updateStoreChoice = "";
                    while (!updateStoreChoice.equals("Add") && !updateStoreChoice.equals("Remove")){
                        System.out.print("Enter your choice (Add/Remove): ");
                        updateStoreChoice = scanner.nextLine();
                    }
                    switch (updateStoreChoice){
                        case "Add":
                            store.printStore();
                            String addTitle;
                            System.out.print("Enter the title of the media: ");
                            addTitle = scanner.nextLine();
                            if (store.searchTitle(addTitle) == null){
                                System.out.println("Please insert the details of the media: ");
                                System.out.println("--------------------------------");
                                System.out.println("Category: ");
                                String category = scanner.nextLine();
                                float cost = -1.0f;
                                do {
                                    try {
                                        System.out.println("Cost: ");
                                        cost = scanner.nextFloat();
                                        scanner.nextLine();
                                    } catch (Exception e){
                                        scanner.nextLine();
                                    }
                                } while (cost < 0);
                                int id = rand.nextInt(1000);
                                String typeChoice = "";
                                while (!typeChoice.equals("DVD") && !typeChoice.equals("CD") && !typeChoice.equals("Book")){
                                    System.out.print("Enter your choice (CD/DVD/Book): ");
                                    typeChoice = scanner.nextLine();
                                }
                                switch (typeChoice){
                                    case "DVD":
                                        String directorDVDName;
                                        System.out.print("Enter the director's name: ");
                                        directorDVDName = scanner.nextLine();
                                        int lengthDVD = -1;
                                        do{
                                            try {
                                                System.out.print("Enter the length: ");
                                                lengthDVD = scanner.nextInt();
                                                scanner.nextLine();
                                            } catch (Exception e){
                                                scanner.nextLine();
                                            }
                                        } while (lengthDVD < 0);
                                        DigitalVideoDisc dvd = new DigitalVideoDisc(id,addTitle,category,directorDVDName,lengthDVD,cost);
                                        store.addMedia(dvd);
                                        break;
                                    case "CD":
                                        String artistCDName;
                                        System.out.print("Enter the artist's name: ");
                                        artistCDName = scanner.nextLine();
                                        CompactDisc cd = new CompactDisc(id,addTitle,category,artistCDName, cost);
                                        int numOfTracks = 0;
                                        do {
                                            try {
                                                System.out.print("Enter the number of tracks: ");
                                                numOfTracks = scanner.nextInt();
                                                scanner.nextLine();
                                            } catch (Exception e){
                                                System.out.println("Invalid Integer");
                                            }
                                        } while(numOfTracks < 0);
                                        String trackTitle;
                                        for (int i = 1; i <= numOfTracks; i++){
                                            System.out.print("Enter title: ");
                                            trackTitle = scanner.nextLine();
                                            int trackLength = -1;
                                            do{
                                                try {
                                                    System.out.print("Enter length: ");
                                                    trackLength = scanner.nextInt();
                                                    scanner.nextLine();
                                                } catch (Exception e){
                                                    scanner.nextLine();
                                                }
                                            }while (trackLength < 0);
                                            Track track = new Track(trackTitle, trackLength);
                                            cd.addTrack(track);
                                        }
                                        store.addMedia(cd);
                                        break;
                                    case "Book":
                                        Book book = new Book(id,addTitle,category,cost);
                                        int numOfAuthors = -1;
                                        String authorName;
                                        do {
                                            try {
                                                System.out.print("Enter the number of authors: ");
                                                numOfAuthors = scanner.nextInt();
                                                scanner.nextLine();
                                            } catch (Exception e){
                                                scanner.nextLine();
                                            }
                                        } while(numOfAuthors < 0);
                                        for (int i= 1; i <= numOfAuthors; i++){
                                            System.out.print("Enter author's name: ");
                                            authorName = scanner.nextLine();
                                            book.addAuthor(authorName);
                                        }
                                        store.addMedia(book);
                                        break;
                                }
                                break;
                            } else {
                                System.out.println("This media exists in the store");
                            }
                            break;
                        case "Remove":
                            store.printStore();
                            String removeTitle;
                            System.out.print("Enter the title of the media: ");
                            removeTitle = scanner.nextLine();
                            if (store.searchTitle(removeTitle) == null){
                                System.out.println("Cannot remove the media");
                            } else {
                                store.removeMedia(store.searchTitle(removeTitle));
                            }
                            break;
                    }
                    break;
                case 3:
                    int cartChoice = -1;
                    do {
                        cart.printCart();
                        cartMenu();
                        try {
                            cartChoice = scanner.nextInt();
                            scanner.nextLine();
                        } catch (Exception e){
                            scanner.nextLine();
                        }
                        switch (cartChoice){
                            case 1:
                                cart.printCart();
                                System.out.print("Enter choice (ID/Title): ");
                                String filterChoice = scanner.nextLine();
                                switch (filterChoice){
                                    case "ID":
                                        System.out.print("Enter id: ");
                                        int id = scanner.nextInt();
                                        scanner.nextLine();
                                        if (cart.searchID(id) != null){
                                            System.out.println(cart.searchID(id));
                                        } else {
                                            System.out.println("Cannot filter the given id");
                                        }
                                        break;
                                    case "Title":
                                        System.out.print("Enter title: ");
                                        String searchTitle = scanner.nextLine();
                                        if (cart.searchTitle(searchTitle) != null){
                                            System.out.println(cart.searchTitle(searchTitle));
                                        } else {
                                            System.out.println("Cannot filter the given title");
                                        }
                                        break;
                                    default:
                                        System.out.println("Invalid Choice");
                                        break;
                                }
                                break;
                            case 2:
                                System.out.print("Enter choice (Title/Cost): ");
                                String sortChoice = scanner.nextLine();
                                switch (sortChoice){
                                    case "Title":
                                        cart.sortByTitle();
                                        cart.printCart();
                                        break;
                                    case "Cost":
                                        cart.sortByCost();
                                        cart.printCart();
                                        break;
                                    default:
                                        System.out.println("Invalid Choice");
                                        break;
                                }
                                break;
                            case 3:
                                cart.printCart();
                                System.out.print("Enter the title of the media: ");
                                String removeTitleInCart = scanner.nextLine();
                                if (cart.searchTitle(removeTitleInCart) == null){
                                    System.out.println("Cannot remove the media");
                                } else {
                                    cart.removeMedia(store.searchTitle(removeTitleInCart));
                                }
                                break;
                            case 4:
                                cart.printCart();
                                String playTitle;
                                System.out.print("Enter the title of the media: ");
                                playTitle = scanner.nextLine();
                                Media itemPlay = cart.searchTitle(playTitle);
                                if (itemPlay == null){
                                    System.out.println("Invalid title");
                                } else {
                                    if (itemPlay instanceof CompactDisc temp){
                                        temp.play();
                                    } else if (itemPlay instanceof DigitalVideoDisc temp){
                                        temp.play();
                                    } else {
                                        System.out.println("Cannot play");
                                    }
                                }
                                break;
                            case 5:
                                if (cart.getSize() > 0){
                                    cart.clearItems();
                                    System.out.println("The order is created!!");
                                } else {
                                    System.out.println("There's nothing in the cart");
                                }
                                break;
                            case 0:
                                System.out.println("BACK");
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                    } while (cartChoice != 0);
                    break;
                case 0:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            scanner.close();
        }
    }
    public static void showMenu(){
        System.out .println("AIMS: ");
        System.out .println("--------------------------------");
        System.out .println("1. View store");
        System.out .println("2. Update store");
        System.out .println("3. See current cart");
        System.out .println("0. Exit");
        System.out .println("--------------------------------");
        System.out .print("Please choose a number (0-1-2-3): ");
    }
    public static void storeMenu(){
        System.out .println("Options: ");
        System.out .println("--------------------------------");
        System.out .println("1. See a media’s details");
        System.out .println("2. Add a media to cart");
        System.out .println("3. Play a media");
        System.out .println("4. See current cart");
        System.out .println("0. Back");
        System.out .println("--------------------------------");
        System.out .print("Please choose a number (0-1-2-3-4): ");
    }
    public static void mediaDetailsMenu(){
        System.out .println("Options: ");
        System.out .println("--------------------------------");
        System.out .println("1. Add to cart");
        System.out .println("2. Play");
        System.out .println("0. Back");
        System.out .println("--------------------------------");
        System.out .print("Please choose a number (0-1-2): ");
    }
    public static void cartMenu(){
        System.out .println("Options: ");
        System.out .println("--------------------------------");
        System.out .println("1. Filter media in cart");
        System.out .println("2. Sort media in cart");
        System.out .println("3. Remove media from cart");
        System.out .println("4. Play a media");
        System.out .println("5. Place order");
        System.out .println("0. Back");
        System.out .println("--------------------------------");
        System.out .print("Please choose a number (0-1-2-3-4-5): ");
    }
}

