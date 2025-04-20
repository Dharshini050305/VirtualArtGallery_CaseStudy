package com.hexaware.vag.service;

import java.util.List;

import com.hexaware.vag.dao.IVirtualArtGallerydao;
import com.hexaware.vag.dao.VirtualArtGallerydaoImp;
import com.hexaware.vag.entity.Artwork;
import com.hexaware.vag.entity.Gallery;


public class VirtualArtGalleryServiceImp  implements IVirtualArtGallery{
	
	IVirtualArtGallerydao dao = new VirtualArtGallerydaoImp();

	@Override
	public boolean addArtwork(Artwork artwork) throws Exception {
		
		return dao.addArtwork(artwork);
	}

	@Override
	public boolean updateArtwork(Artwork artwork) throws Exception {
		
		return dao.updateArtwork(artwork);
	}

	@Override
	public boolean deleteArtwork(int artworkID) throws Exception {
	
		return dao.deleteArtwork(artworkID);
	}

	@Override
	public Artwork getArtwork(int artworkID) throws Exception {
		
		return dao.getArtwork(artworkID);
	}

	@Override
	public List<Artwork> getAllArtworks() throws Exception {
		
		return dao.getAllArtworks();
	}

	@Override
	public boolean addArtworkToFavorite(int UserID, String artworkId) throws Exception {
		
		return dao.addArtworkToFavorite(UserID, artworkId);
	}

	@Override
	public boolean removeArtworkFromFavorite(int UserID, String artworkId) throws Exception {
		
		return dao.removeArtworkFromFavorite(UserID, artworkId);
	}

	@Override
	public List<String> getUserFavoriteArtworks(int UserID) throws Exception {
		
		return dao.getUserFavoriteArtworks(UserID);
	}

	@Override
	public boolean addGallery(Gallery gallery) throws Exception {
		return dao.addGallery(gallery);
		
	}

	@Override
	public boolean updateGallery(Gallery gallery) throws Exception {
		
		return dao.updateGallery(gallery);
	}

	@Override
	public boolean deleteGallery(int galleryID) throws Exception {
		return dao.deleteGallery(galleryID);
	}

	@Override
	public Gallery getGallery(int galleryID) throws Exception {
		return dao.getGallery(galleryID);
	}

	@Override
	public List<Gallery> getAllGalleries() throws Exception {
		return dao.getAllGalleries();
				
	}
	
	public static boolean validateArtworkData(Artwork artwork) {
	    boolean flag = false;

	    if (
	        artwork.getTitle() != null && artwork.getTitle().length() > 3 &&
	        artwork.getMedium() != null && artwork.getMedium().length() > 3 &&
	        artwork.getCreationDate() != null &&
	        artwork.getImageURL() != null && artwork.getImageURL().startsWith("http")
	    ) {
	        flag = true;
	    }

	    return flag;
	}

}
	    
	    

	    