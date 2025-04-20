package com.hexaware.vag.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hexaware.vag.dao.IVirtualArtGallerydao;
import com.hexaware.vag.dao.VirtualArtGallerydaoImp;
import com.hexaware.vag.entity.Gallery;

public class VirtualArtGallerydoaGalleryTest {
    
    private IVirtualArtGallerydao artGalleryDAO;

    @BeforeEach
    void setUp() {
        artGalleryDAO = new VirtualArtGallerydaoImp();
    }

    @Test
    public void testAddGallery() throws Exception {
        Gallery gallery = new Gallery(0, "Modern Art Gallery", "A gallery for modern art", "NYC", 1, "9 AM - 5 PM");
        artGalleryDAO.addGallery(gallery);
        List<Gallery> allGalleries = artGalleryDAO.getAllGalleries();
        boolean galleryExists = allGalleries.stream()
                                            .anyMatch(g -> g.getName().equals("Modern Art Gallery"));
        assertTrue(galleryExists, "Gallery should have been added successfully.");
    }

    @Test
    public void testUpdateGallery() throws Exception {
        Gallery gallery = new Gallery(31, "Modern Art Gallery", "A gallery for modern art", "NYC", 1, "9 AM - 5 PM");
        artGalleryDAO.addGallery(gallery);
        gallery.setName("Contemporary Art Gallery");
        artGalleryDAO.updateGallery(gallery);
        Gallery updatedGallery = artGalleryDAO.getGallery(gallery.getGalleryID());
        assertEquals("Contemporary Art Gallery", updatedGallery.getName());
    }

    @Test
    public void testDeleteGallery() throws Exception {
        Gallery gallery = new Gallery(0, "Temporary Gallery", "A temporary gallery", "NYC", 1, "9 AM - 5 PM");
        artGalleryDAO.addGallery(gallery);
        List<Gallery> allGalleries = artGalleryDAO.getAllGalleries();
        int galleryIdToDelete = allGalleries.stream()
                                            .filter(g -> g.getName().equals("Temporary Gallery"))
                                            .findFirst()
                                            .orElseThrow(() -> new Exception("Gallery not found"))
                                            .getGalleryID();
        artGalleryDAO.deleteGallery(galleryIdToDelete);
        Gallery retrievedGallery = artGalleryDAO.getGallery(galleryIdToDelete);
        assertNull(retrievedGallery, "Gallery should have been deleted successfully.");
    }

    @Test
    public void testGetAllGalleries() throws Exception {
        List<Gallery> galleries = artGalleryDAO.getAllGalleries();
        assertFalse(galleries.isEmpty());
    }
}
