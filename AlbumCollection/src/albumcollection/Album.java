package albumcollection;

/**
 * This enum represents the music genre of the album.
 */
enum MusicGenre{
    ROCK, RAP, COUNTRY, POP;  
}

/**
 * This class is a representation of an Album. 
 * 
 */
public class Album {
    private String artist;
    private String title;
    private int releaseYear;
    private MusicGenre musicGenre;

/**
* This constructor initializes the item object. The constructor provides no
* user input validation. That should be handled by the class that creates a
* item object.
*
* @param title a <b><CODE>String</CODE></b> that represents the title of the album
*
* @param artist a <b><CODE>String</CODE></b> that represents the artist name.
*
* @param releaseYear a <b><CODE>int</CODE></b> that represents the category.
*                 Door&Window, Cabinet&Furniture, Fasteners, Structural, Other.
*
* @param musicGenre a <b><CODE>MusicGenre</CODE></b> that represents the quantity
*
*/
    public Album(String artist, String title, int releaseYear){
        this.artist = artist;
        this.title = title;
        this.releaseYear = releaseYear;
        this.musicGenre = musicGenre;
    }
    
    /**
     *
     * @return title a <b><CODE>String</CODE></b> represents Title of album.
     */
    public String getTitle() {
        return title;
    }
    
    /**
     *
     * @param title a <b><CODE>int</CODE></b> that represents the title of the album.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     *
     * @return a <b><CODE>String</CODE></b> represents Title of album.
     */
    public String getArtist() {
        return artist;
    }
    
    /**
     *
     * @param artist a <b><CODE>String</CODE></b> that represents the artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    /**
     *
     * @return a <b><CODE>int</CODE></b> represents release date of album.
     */
    public int getReleaseYear() {
        return releaseYear;
    }
    
    /**
     *
     * @param releaseYear a <b><CODE>int</CODE></b> that represents the quantity
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
     * @return musicGenre a <b><CODE>MusicGenre</CODE></b> 
     */
    public MusicGenre getMusicGenre() {
        return musicGenre;
    }
    
    /**
     * 
     * @return a <b><CODE>String</CODE></b> that prints a formatted album.
     */
    @Override
    public String toString() {
        return "Title: " + this.title + ", Artist: " + this.artist + ", Year: " +
        this.releaseYear + ", Genre: " + musicGenre;
    }
}