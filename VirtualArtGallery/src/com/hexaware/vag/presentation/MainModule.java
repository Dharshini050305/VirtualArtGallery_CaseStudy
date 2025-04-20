package com.hexaware.vag.presentation;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.hexaware.vag.dao.IVirtualArtGallerydao;
import com.hexaware.vag.dao.VirtualArtGallerydaoImp;
import com.hexaware.vag.entity.Artwork;
import com.hexaware.vag.entity.Gallery;

public class MainModule {
	private static final Scanner scanner = new Scanner(System.in);
	private static final IVirtualArtGallerydao galleryDAO = new VirtualArtGallerydaoImp();

    public static void main(String[] args) {
    	while (true) {
   		 System.out.println("Welcome to Virtual Art Gallery");
   		 System.out.println("1.Add Artwork");
   		 System.out.println("2.update Artwork");
   		 System.out.println("3.Delete Artwork");
   		 System.out.println("4.Get Artwork");
   		 System.out.println("5.Get All Artwork");
   		 System.out.println("6.Add Gallery");
   		 System.out.println("7.Update Gallery");
   		 System.out.println("8.Delete Gallery");
   		 System.out.println("9.Get Gallery");
   		 System.out.println("10.Get All Gallery");
   		 System.out.println("11.Add Artwork to Favourite");
   		 System.out.println("12.Remove Artwork from Favourite");
   		 System.out.println("13.Get User Favourite Artwork");
   		 System.out.println("14.EXIT");
   		 System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
            case 1:
                addArtwork();
                break;
            case 2:
                updateArtwork();
                break;
            case 3:
                deleteArtwork();
                break;
            case 4:
                getArtwork();
                break;
            case 5:
                getAllArtworks();
                break;
            case 6:
                addGallery();
                break;
            case 7:
                updateGallery();
                break;
            case 8:
                deleteGallery();
                break;
            case 9:
                getGallery();
                break;
            case 10:
                getAllGalleries();
                break;
            case 11:
                addArtworkToFavorite();
                break;
            case 12:
                removeArtworkFromFavorite();
                break;
            case 13:
                getUserFavoriteArtworks();
                break;
            case 14:	
                System.out.println("Exiting...");
                System.out.println("Thank You! Visit Again:)");
                return;
            default:
                System.out.println("Invalid choice! Please try again.");
            }
   	 }
   }
   private static void addArtwork() {
       System.out.println("Enter Artwork Title:");
       String title = scanner.nextLine();
       System.out.println("Enter Artwork Description:");
       String description = scanner.nextLine();
       System.out.println("Enter Creation Date (YYYY-MM-DD):");
       LocalDate creationDate = LocalDate.parse(scanner.nextLine());
       System.out.println("Enter Medium:");
       String medium = scanner.nextLine();
       System.out.println("Enter Image URL:");
       String imageURL = scanner.nextLine();
       System.out.println("Enter Artist ID:");
       int artistID = scanner.nextInt();
       scanner.nextLine(); // Consume newline

       Artwork artwork = new Artwork(title, description, creationDate, medium, imageURL, artistID);
       try {
           galleryDAO.addArtwork(artwork);
           System.out.println("Artwork added successfully!");
       } catch (Exception e) {
           System.out.println("Error adding artwork: " + e.getMessage());
       }
   }
   private static void updateArtwork() {
       System.out.println("Enter Artwork ID to update:");
       int artworkID = scanner.nextInt();
       scanner.nextLine(); // Consume newline

       System.out.println("Enter new Artwork Title:");
       String title = scanner.nextLine();
       System.out.println("Enter new Artwork Description:");
       String description = scanner.nextLine();
       System.out.println("Enter new Creation Date (YYYY-MM-DD):");
       LocalDate creationDate = LocalDate.parse(scanner.nextLine());
       System.out.println("Enter new Medium:");
       String medium = scanner.nextLine();
       System.out.println("Enter new Image URL:");
       String imageURL = scanner.nextLine();
       System.out.println("Enter new Artist ID:");
       int artistID = scanner.nextInt();
       scanner.nextLine(); // Consume newline

       Artwork artwork = new Artwork(artworkID, title, description, creationDate, medium, imageURL, artistID);
       try {
           galleryDAO.updateArtwork(artwork);
           System.out.println("Artwork updated successfully!");
       } catch (Exception e) {
           System.out.println("Error updating artwork: " + e.getMessage());
       }
   }
   private static void deleteArtwork() {
       System.out.println("Enter Artwork ID to delete:");
       int artworkID = scanner.nextInt();
       scanner.nextLine(); // Consume newline

       try {
           galleryDAO.deleteArtwork(artworkID);
           System.out.println("Artwork deleted successfully!");
       } catch (Exception e) {
           System.out.println("Error deleting artwork: " + e.getMessage());
       }
   }
   
   private static void getArtwork() {
       System.out.println("Enter Artwork ID to retrieve:");
       int artworkID = scanner.nextInt();
       scanner.nextLine(); // Consume newline

       try {
           Artwork artwork = galleryDAO.getArtwork(artworkID);
           if (artwork != null) {
               System.out.println("Artwork Details: " + artwork);
           } else {
               System.out.println("Artwork not found.");
           }
       } catch (Exception e) {
           System.out.println("Error retrieving artwork: " + e.getMessage());
       }
   }
   private static void getAllArtworks() {
       try {
           List<Artwork> artworks = galleryDAO.getAllArtworks();
           if (artworks.isEmpty()) {
               System.out.println("No artworks found.");
           } else {
               artworks.forEach(System.out::println);
           }
       } catch (Exception e) {
           System.out.println("Error retrieving artworks: " + e.getMessage());
       }
   }
   private static void addGallery() {
       System.out.println("Enter Gallery Name:");
       String name = scanner.nextLine();
       System.out.println("Enter Gallery Description:");
       String description = scanner.nextLine();
       System.out.println("Enter Gallery Location:");
       String location = scanner.nextLine();
       System.out.println("Enter Curator (Artist ID):");
       int curator = scanner.nextInt();
       scanner.nextLine(); // Consume newline
       System.out.println("Enter Opening Hours:");
       String openingHours = scanner.nextLine();

       Gallery gallery = new Gallery(name, description, location, curator, openingHours);
       try {
           galleryDAO.addGallery(gallery);
           System.out.println("Gallery added successfully!");
       } catch (Exception e) {
           System.out.println("Error adding gallery: " + e.getMessage());
       }
   }
   
   private static void updateGallery() {
       System.out.println("Enter Gallery ID to update:");
       int galleryID = scanner.nextInt();
       scanner.nextLine(); // Consume newline

       System.out.println("Enter new Gallery Name:");
       String name = scanner.nextLine();
       System.out.println("Enter new Gallery Description:");
       String description = scanner.nextLine();
       System.out.println("Enter new Gallery Location:");
       String location = scanner.nextLine();
       System.out.println("Enter new Curator (Artist ID):");
       int curator = scanner.nextInt();
       scanner.nextLine(); // Consume newline
       System.out.println("Enter new Opening Hours:");
       String openingHours = scanner.nextLine();

       Gallery gallery = new Gallery(galleryID, name, description, location, curator, openingHours);
       try {
           galleryDAO.updateGallery(gallery);
           System.out.println("Gallery updated successfully!");
       } catch (Exception e) {
           System.out.println("Error updating gallery: " + e.getMessage());
       }
   }
   
   private static void deleteGallery() {
       System.out.println("Enter Gallery ID to delete:");
       int galleryID = scanner.nextInt();
       scanner.nextLine(); // Consume newline

       try {
           galleryDAO.deleteGallery(galleryID);
           System.out.println("Gallery deleted successfully!");
       } catch (Exception e) {
           System.out.println("Error deleting gallery: " + e.getMessage());
       }
   }
   private static void getGallery() {
       System.out.println("Enter Gallery ID to retrieve:");
       int galleryID = scanner.nextInt();
       scanner.nextLine(); // Consume newline

       try {
           Gallery gallery = galleryDAO.getGallery(galleryID);
           if (gallery != null) {
               System.out.println("Gallery Details: " + gallery);
           } else {
               System.out.println("Gallery not found.");
           }
       } catch (Exception e) {
           System.out.println("Error retrieving gallery: " + e.getMessage());
       }
   }
   
   private static void getAllGalleries() {
       try {
           List<Gallery> galleries = galleryDAO.getAllGalleries();
           if (galleries.isEmpty()) {
               System.out.println("No galleries found.");
           } else {
               galleries.forEach(System.out::println);
           }
       } catch (Exception e) {
           System.out.println("Error retrieving galleries: " + e.getMessage());
       }
   }
   
   private static void addArtworkToFavorite() {
       System.out.println("Enter UserID:");
       int UserID = scanner.nextInt();
       scanner.nextLine(); // Consume newline

       System.out.println("Enter Artwork ID to add to favorites:");
       String artworkId = scanner.nextLine();
       
       // Validate input
       if (artworkId.isEmpty() || !artworkId.matches("\\d+")) {
           System.out.println("Invalid Artwork ID. Please enter a valid number.");
           return;
       }

      // int artworkID = Integer.parseInt(artworkIdInput);
       
       try {
           galleryDAO.addArtworkToFavorite(UserID, artworkId);
           System.out.println("Artwork added to favorites successfully!");
       } catch (Exception e) {
           System.out.println("Error adding artwork to favorites: " + e.getMessage());
       }
   }
   
   private static void removeArtworkFromFavorite() {
       System.out.println("Enter UserID:");
       int userID = scanner.nextInt();
       scanner.nextLine(); // Consume the newline character

       System.out.println("Enter Artwork ID to remove from favorites:");
       String artworkId = scanner.nextLine(); // Now this will correctly read the user input

       // Validate the artworkId
       if (artworkId.isEmpty() || !artworkId.matches("\\d+")) {
           System.out.println("Invalid Artwork ID. Please enter a valid number.");
           return;
       }

       try {
           // Convert artworkId to integer before passing to the DAO method
           
           galleryDAO.removeArtworkFromFavorite(userID, artworkId);
           System.out.println("Artwork removed from favorites successfully!");
       } catch (Exception e) {
           System.out.println("Error removing artwork from favorites: " + e.getMessage());
       }
   }
   
   private static void getUserFavoriteArtworks() {
       System.out.println("Enter UserID:");
       int UserID = scanner.nextInt();

       try {
           List<String> favoriteArtworks = galleryDAO.getUserFavoriteArtworks(UserID);
           if (favoriteArtworks.isEmpty()) {
               System.out.println("No favorite artworks found for this user.");
           } else {
               System.out.println("Favorite Artworks for " + UserID + ":");
               for (String artworkId : favoriteArtworks) {
                   System.out.println("Artwork ID: " + artworkId);
               }
           }
       } catch (Exception e) {
           System.out.println("Error fetching favorite artworks: " + e.getMessage());
       }
   }


}
