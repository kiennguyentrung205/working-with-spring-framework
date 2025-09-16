package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @Column(name = "artistId")
    private int artistId;
    private String name;
//    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Album> albums;
    @Transient // cai nay dung de them thuoc tinh rieng o ngoai khong co trong bang database
    private String displayName;

    public Artist(int ArtistId, String name) {
        this.artistId = ArtistId;
        this.name = name;
    }

    public Artist() {
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
