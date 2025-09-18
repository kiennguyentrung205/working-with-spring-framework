package service;

import entities.Album;
import entities.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AlbumService {
    public int addNewAlbumToArtist(int artistId, int albumId, String albumTitle){
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            //Find artist (sau khi find thi artist nhan dc se o trang thai persistent)
            Artist ar = em.find(Artist.class, artistId);
            Album album = new Album(albumId,albumTitle);
            ar.addAlbum(album);
            em.persist(ar);
            tx.commit();
            return album.getId();
        }
    }
}
