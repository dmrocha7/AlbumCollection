
package albumcollection;

import java.util.ArrayList;

/**
 *
 * @author bb&cc
 */
public class CompactDisc extends Album implements Album.playable
{
    ArrayList<Tracks> tracks = new ArrayList<Tracks>();
    private int curTrack = 0;
    public CompactDisc(String artist, String title, int releaseYear, 
                       int currentTrackIndex) {
        super(artist, title, releaseYear);
                
    }
    
    public void play() { 
        
    }
    
    public void fastForward() {
        
    }
    
    public void rewind() {
        
    }
}
