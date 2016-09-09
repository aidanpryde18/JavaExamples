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
//   Dog.java
//
//   Implements Animal interface
//--------------------------------------

public class Dog implements Animal {

//--------------------------------------
//  Instance data
//--------------------------------------

    protected String type;
    protected String sound;

//--------------------------------------
//  Constructor sets type and sound
//  for a dog.
//--------------------------------------
    
    public Dog (String dogType) {
        type = dogType;
        sound = "woof";
    }

//--------------------------------------
//  Accessors for Dog
//  These two are required because this
//  class implements the Animal interface
//--------------------------------------
    
    public String getAnimalSound() {
        return sound;
    }
    
    public String getAnimalType() {
        return type;
    }
}
