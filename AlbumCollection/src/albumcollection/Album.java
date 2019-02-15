package albumcollection;

/**
 *
 * @author David Rocha
 */
enum MusicGenre{
    ROCK, RAP, COUNTRY, POP;  
}

/**
 *
 * 
 */
public class Album {
    private String title;
    private String artist;
    private int releaseYear;
    private MusicGenre musicGenre;

    /**
     *
     * @param title
     * @param artist
     * @param releaseYear
     */
    public Album(String title, String artist, int releaseYear){
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.musicGenre = musicGenre;
    }
    
    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }
    
    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     *
     * @return
     */
    public String getArtist() {
        return artist;
    }
    
    /**
     *
     * @param artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    /**
     *
     * @return
     */
    public Integer getReleaseYear() {
        return releaseYear;
    }
    
    /**
     *
     * @param releaseYear
     */
    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    /**
     *
     * @param musicGenre
     */
    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }
    
    /**
     * Setter for Genre
     * @return
     */
    public MusicGenre getMusicGenre() {
        return musicGenre;
    }
    
    @Override
    public String toString() {
        return "Title: " + this.title + ", Artist: " + this.artist + ", Year: " +
        this.releaseYear + ", Genre: " + musicGenre;
    }
}