package com.hexaware.vag.service;

import java.util.List;

import com.hexaware.vag.entity.Artwork;
import com.hexaware.vag.entity.Gallery;

public interface IVirtualArtGallery {

	//artwork methods
	boolean addArtwork(Artwork artwork) throws Exception;
	 boolean updateArtwork(Artwork artwork) throws Exception;
	 boolean deleteArtwork(int artworkID) throws Exception;
	 Artwork getArtwork(int artworkID) throws Exception;
	 List<Artwork> getAllArtworks() throws Exception;
	 
	 //gallery methods
	 boolean addGallery(Gallery gallery) throws Exception;
	    boolean updateGallery(Gallery gallery) throws Exception;
	    boolean deleteGallery(int galleryID) throws Exception;
	    Gallery getGallery(int galleryID) throws Exception;
	    List<Gallery> getAllGalleries() throws Exception;
	    
	    //user favourites 
	    boolean addArtworkToFavorite(int UserID, String artworkId) throws Exception;
	    boolean removeArtworkFromFavorite(int UserID, String artworkId) throws Exception;
	    List<String> getUserFavoriteArtworks(int UserID) throws Exception;
		

}
