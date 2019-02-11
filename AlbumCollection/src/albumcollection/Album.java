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
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getArtist() {
        return artist;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    public Integer releaseYear() {
        return releaseYear;
    }
    
    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }
    
    public MusicGenre getMusicGenre() {
        return musicGenre;
    }
}