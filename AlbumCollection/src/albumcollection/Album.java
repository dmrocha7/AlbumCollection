package albumcollection;

/**
 *
 * @author David Rocha
 */
    enum MusicGenre{
        ROCK, RAP, COUNTRY, POP;  
    }

public class Album {
    private String title;
    private String artist;
    private int releaseYear;
    private MusicGenre musicGenre;


public Album(String title, String artist){
    this.title = title;
    this.artist = artist;
    this.releaseYear = releaseYear;
    this.musicGenre = musicGenre;
}
}