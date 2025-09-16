package app;

import entities.Artist;
import service.ArtistService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ArtistService artistService = new ArtistService();
        //CRUD
        //ReadList
        List<Artist> artistList = new ArtistService().getArtists();
        for(Artist a: artistList){
            System.out.println(String.format("Id: %d, name: %s",a.getArtistId(),a.getName()));
        }
        //Read by id
//         Artist artist = artistService.getArtist(50000);
//         if(artist!=null){
//             System.out.println(String.format("ID: %s, Name: %s",artist.getArtistId(),artist.getName()));
//         }else {
//             System.out.println("Not found");
//         }
        //Create Artist
//        Artist ar = new Artist(999, "Son Tung MTP");
//        int id = artistService.addArtist(ar);
//        System.out.println("Create artist");
        //Update
//        artistService.updateArtist(777,"Minh Vuong");
        //Delete
//        artistService.removeArtist(777);
    }

}
