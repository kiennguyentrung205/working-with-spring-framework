package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Album")
public class Album {
    @Id
    @Column(name = "AlbumId")
    private int id;
    private String Title;
    @ManyToOne
    @JoinColumn(name = "artistid")
    private Artist arId;

    public Album() {
    }

    public Album(int id, String title) {
        this.id = id;
        Title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Artist getArId() {
        return arId;
    }

    public void setArId(Artist arId) {
        this.arId = arId;
    }
}