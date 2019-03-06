/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package albumcollection;

/**
 *
 * @author bb&cc
 */
public class Tracks {
    private double currentPosition = 0;
    private double lengthInSeconds = 0;
    
    public Tracks(String trackName, int length) {
        this.currentPosition = currentPosition;
        this.lengthInSeconds = length;
    }

    public double getcurrentPosition() {
        return currentPosition;
    }
    
    public double getLength() {
        return lengthInSeconds;
    }
    
}
