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
//   FarmDog.java
//
//   Implements Animal interface
//   Inherits from Dog Class
//--------------------------------------

public class FarmDog extends Dog implements Animal {
    
//--------------------------------------
//  Instance data
//--------------------------------------

    private String name;
    
//--------------------------------------
//  Constructor sets type and name
//  for a farm dog.
//--------------------------------------
    
    public FarmDog (String dogName) {
        super("farm dog named " + dogName);
        name = dogName;
    }

//--------------------------------------
//  Accessor for Farm Dog
//  Only the getName is listed because
//  the others are inherited from Dog
//--------------------------------------
    
    public String getName() {
        return name;
    }
    
}
