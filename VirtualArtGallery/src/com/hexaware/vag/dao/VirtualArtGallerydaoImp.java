package com.hexaware.vag.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.vag.entity.Artwork;
import com.hexaware.vag.entity.Gallery;
import com.hexaware.vag.util.DBConnUtil;

public class VirtualArtGallerydaoImp implements IVirtualArtGallerydao {


	//add artwork
	@Override
	public boolean addArtwork(Artwork artwork) throws Exception {
        String query = "INSERT INTO Artwork (Title, Description, CreationDate, Medium, ImageURL, ArtistID) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, artwork.getTitle());
            preparedStatement.setString(2, artwork.getDescription());
            preparedStatement.setDate(3, Date.valueOf(artwork.getCreationDate()));
            preparedStatement.setString(4, artwork.getMedium());
            preparedStatement.setString(5, artwork.getImageURL());
            preparedStatement.setInt(6, artwork.getArtistID());
            preparedStatement.executeUpdate();
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0; // 

        } catch (Exception e) {
            e.printStackTrace();
            return false; 
        }

        }
    
	@Override
	//update artwork
	public boolean updateArtwork(Artwork artwork) throws Exception {
        String query = "UPDATE Artwork SET Title=?, Description=?, CreationDate=?, Medium=?, ImageURL=?, ArtistID=? WHERE ArtworkID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, artwork.getTitle());
            preparedStatement.setString(2, artwork.getDescription());
            preparedStatement.setDate(3, Date.valueOf(artwork.getCreationDate()));
            preparedStatement.setString(4, artwork.getMedium());
            preparedStatement.setString(5, artwork.getImageURL());
            preparedStatement.setInt(6, artwork.getArtistID());
            preparedStatement.setInt(7, artwork.getArtworkID());
            preparedStatement.executeUpdate();
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

        
    
	
	
	//delete artwork
	@Override
    public boolean deleteArtwork(int artworkID) throws Exception {
        String query = "DELETE FROM Artwork WHERE ArtworkID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, artworkID);
            preparedStatement.executeUpdate();
            int rowsDeleted=preparedStatement.executeUpdate();
            return rowsDeleted>0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
	
	
	// get artwork
	@Override
    public Artwork getArtwork(int artworkID) throws Exception {
        String query = "SELECT * FROM Artwork WHERE ArtworkID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, artworkID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Artwork(
                    resultSet.getInt("ArtworkID"),
                    resultSet.getString("Title"),
                    resultSet.getString("Description"),
                    resultSet.getDate("CreationDate").toLocalDate(),
                    resultSet.getString("Medium"),
                    resultSet.getString("ImageURL"),
                    resultSet.getInt("ArtistID")
                );
            }
        }
        return null; 
	}
	
	
	//get all artworks
	@Override
    public List<Artwork> getAllArtworks() throws Exception {
        List<Artwork> artworks = new ArrayList<>();
        String query = "SELECT * FROM Artwork";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                artworks.add(new Artwork(
                    resultSet.getInt("ArtworkID"),
                    resultSet.getString("Title"),
                    resultSet.getString("Description"),
                    resultSet.getDate("CreationDate").toLocalDate(),
                    resultSet.getString("Medium"),
                    resultSet.getString("ImageURL"),
                    resultSet.getInt("ArtistID")
                ));
            }
        }
        return artworks;
    }
	
	//add gallery
	@Override
    public boolean addGallery(Gallery gallery) throws Exception {
        String query = "INSERT INTO Gallery (Name, Description, Location, Curator, OpeningHours) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, gallery.getName());
            preparedStatement.setString(2, gallery.getDescription());
            preparedStatement.setString(3, gallery.getLocation());
            preparedStatement.setInt(4, gallery.getCurator());
            preparedStatement.setString(5, gallery.getOpeningHours());
            preparedStatement.executeUpdate();
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0; 

        } catch (Exception e) {
            e.printStackTrace();
            return false; 

        }
    }
	
	//update gallery
	@Override
    public boolean updateGallery(Gallery gallery) throws Exception {
        String query = "UPDATE Gallery SET Name=?, Description=?, Location=?, Curator=?, OpeningHours=? WHERE GalleryID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, gallery.getName());
            preparedStatement.setString(2, gallery.getDescription());
            preparedStatement.setString(3, gallery.getLocation());
            preparedStatement.setInt(4, gallery.getCurator());
            preparedStatement.setString(5, gallery.getOpeningHours());
            preparedStatement.setInt(6, gallery.getGalleryID());
            preparedStatement.executeUpdate();
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
	
	//delete gallery 
	@Override
    public boolean deleteGallery(int galleryID) throws Exception {
        String query = "DELETE FROM Gallery WHERE GalleryID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, galleryID);
            preparedStatement.executeUpdate();
            int rowsDeleted=preparedStatement.executeUpdate();
            return rowsDeleted>0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
	
    }
	
	// get gallery
	@Override
    public Gallery getGallery(int galleryID) throws Exception {
        String query = "SELECT * FROM Gallery WHERE GalleryID=?";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, galleryID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Gallery(
                    resultSet.getInt("GalleryID"),
                    resultSet.getString("Name"),
                    resultSet.getString("Description"),
                    resultSet.getString("Location"),
                    resultSet.getInt("Curator"),
                    resultSet.getString("OpeningHours")
                );
            }
        }
        return null; // Gallery not found
    }
	
	@Override
	//get all gallery
    public List<Gallery> getAllGalleries() throws Exception {
        List<Gallery> galleries = new ArrayList<>();
        String query = "SELECT * FROM Gallery";
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                galleries.add(new Gallery(
                    resultSet.getInt("GalleryID"),
                    resultSet.getString("Name"),
                    resultSet.getString("Description"),
                    resultSet.getString("Location"),
                    resultSet.getInt("Curator"),
                    resultSet.getString("OpeningHours")
                ));
            }
        }
        return galleries;
    }
	
	@Override
    public boolean addArtworkToFavorite(int UserID, String artworkId) throws Exception {
        String query = "INSERT INTO UserFavoriteArtworks (UserID, ArtworkID) VALUES (?, ?)";
        
        try (Connection conn = DBConnUtil.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, UserID);
            pstmt.setString(2, artworkId);
            pstmt.executeUpdate();
            int artworkInserted = pstmt.executeUpdate();
            return  artworkInserted> 0; // Return true if at least one row inserted

        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false if any exception occurs
        }
        }

        
    
	
	 @Override
	    public boolean removeArtworkFromFavorite(int UserID, String artworkId) throws Exception {
	        String query = "DELETE FROM UserFavoriteArtworks WHERE UserID = ? AND ArtworkID = ?";
	        
	        try (Connection conn = DBConnUtil.getConnection(); 
	             PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setInt(1, UserID);
	            pstmt.setString(2, artworkId);
	            pstmt.executeUpdate();
	            int artworkRemoved = pstmt.executeUpdate();
	            return  artworkRemoved> 0; // Return true if at least one row inserted

	        } catch (Exception e) {
	            e.printStackTrace();
	            return false; // Return false if any exception occurs
	        }
	        }

	        
	    
	 @Override
	    public List<String> getUserFavoriteArtworks(int UserID) throws Exception {
	        List<String> favoriteArtworks = new ArrayList<>();
	        String query = "SELECT ArtworkID FROM UserFavorite"
	        		+ "Artworks WHERE UserID = ?";
	        
	        try (Connection conn = DBConnUtil.getConnection(); 
	             PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setInt(1, UserID);
	            ResultSet rs = pstmt.executeQuery();
	            
	            while (rs.next()) {
	                favoriteArtworks.add(rs.getString("ArtworkID"));
	            }
	        }
	        return favoriteArtworks;
	    }    

	

}


	
    
