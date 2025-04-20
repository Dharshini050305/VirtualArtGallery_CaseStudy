package com.hexaware.vag.test;


import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hexaware.vag.dao.IVirtualArtGallerydao;
import com.hexaware.vag.dao.VirtualArtGallerydaoImp;
import com.hexaware.vag.entity.Artwork;

public class VirtualArtGallerydaoTest {

static  IVirtualArtGallerydao dao;

@BeforeAll
static void setUpBeforeClass() throws Exception {
	
		dao = new VirtualArtGallerydaoImp();
	
}
@Test
public void testAddArtwork() throws Exception {
	Artwork artwork = new Artwork("Krishna", "A beautiful painting", LocalDate.now(), "Oil painting", "https://krishna.jpg",5);
	boolean n  =	dao.addArtwork(artwork);
	assertTrue(n);
    }

	@Test
    void testDeleteArtwork() throws Exception {
        // First, add a new artwork
        Artwork artwork = new Artwork(0, "Temporary Artwork", "A temporary painting", LocalDate.now(), "Oil", "https://art.com/TemporaryArtwork.jpg", 1);
        dao.addArtwork(artwork);
        
        // Retrieve all artworks to find the ID of the added artwork
        List<Artwork> allArtworks = dao.getAllArtworks();
        int artworkIdToDelete = allArtworks.stream()
                                            .filter(a -> a.getTitle().equals("Temporary Artwork"))
                                            .findFirst()
                                            .orElseThrow(() -> new Exception("Artwork not found"))
                                            .getArtworkID();
        
        // Delete the artwork
        dao.deleteArtwork(artworkIdToDelete);
        
        // Check if the artwork was deleted
        Artwork retrievedArtwork =dao.getArtwork(artworkIdToDelete);
        assertNull(retrievedArtwork, "Artwork should have been deleted successfully.");
    }
    @Test
    void testGetAllArtworks() throws Exception {
        List<Artwork> artworks = dao.getAllArtworks();
        assertNotEquals(null,artworks);
    }
	
}