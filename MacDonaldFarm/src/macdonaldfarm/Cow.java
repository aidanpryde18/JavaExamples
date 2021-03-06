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
//   Cow.java
//
//   Implements Animal interface
//--------------------------------------

public class Cow implements Animal {

//--------------------------------------
//  Instance data
//--------------------------------------

    private String type;
    private String sound;
    
//--------------------------------------
//  Constructor sets type and sound
//  for a cow.
//--------------------------------------
    
    public Cow () {
        type = "cow";
        sound = "moo";
    }

//--------------------------------------
//  Accessors for Cow
//  These two are required because this
//  class implements the Animal interface
//--------------------------------------
    
    public String getAnimalSound(){
        return sound;
    }
    
    public String getAnimalType() {
        return type;
    }
    
}
