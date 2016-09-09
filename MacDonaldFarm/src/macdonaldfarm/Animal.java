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
//-----------------------------------------
//    Animal interface for Old MacDonald
//-----------------------------------------

public interface Animal {
	public String getAnimalSound();
	public String getAnimalType();
}