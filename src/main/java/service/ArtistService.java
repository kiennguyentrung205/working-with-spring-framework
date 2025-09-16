package service;

import entities.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

import java.util.List;

public class ArtistService {
    //CRUD
    public List<Artist> getArtists() {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
             EntityManager em = emf.createEntityManager()) {
            return em.createQuery("FROM Artist a", Artist.class).getResultList();
        }
    }

    //Read: Single
    public Artist getArtist(int id) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
             EntityManager em = emf.createEntityManager()) {
            return em.find(Artist.class, id); //find no nhu la select
        }
    }

    //Create
    public int addArtist(Artist artist) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(artist); // persist la them
            tx.commit();
            return artist.getArtistId();
        }
    }

    //Update
    public int updateArtist(int id, String newName) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Artist artist = em.find(Artist.class,id);
            if(artist!=null){
                artist.setName(newName);
                em.persist(artist); // persist la them
            }
            tx.commit();
            return artist.getArtistId();
        }
    }
    //Delete
    public void removeArtist(int id){
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Artist artist = em.find(Artist.class,id);
            if(artist!=null){
                em.remove(artist);
            }
            tx.commit();
        }
    }
}
