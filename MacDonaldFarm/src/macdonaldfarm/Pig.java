/*
 * William Wyatt
 * 2/16/16
 * CIT 249 Java II
 * Song Assignment
 *
 * This program prints out the Old MacDonald Song.
 * It extends the song based on the number of animal classes created and called.
 */
package macdonaldfarm;

//--------------------------------------
//   Pig.java
//
//   Implements Animal interface
//--------------------------------------

public class Pig implements Animal {
    
//--------------------------------------
//  Instance data
//--------------------------------------

    private String type;
    private String sound;
    
//--------------------------------------
//  Constructor sets type and sound
//  for a pig.
//--------------------------------------
    
    public Pig () {
        type = "pig";
        sound = "oink";
    }

//--------------------------------------
//  Accessors for Pig
//  These two are required because this
//  class implements the Animal interface
//--------------------------------------
    
    public String getAnimalType(){
        return type;
    }
    
    public String getAnimalSound() {
        return sound;
    }
}
