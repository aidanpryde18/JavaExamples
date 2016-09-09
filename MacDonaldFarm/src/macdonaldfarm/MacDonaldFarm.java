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
//   MacDonaldFarm
//
//   Class of all animals on Old
//   MacDonald's farm
//--------------------------------------

public class MacDonaldFarm
{
	   private Animal[] hisFarm;

	   //-----------------------------------------------------------------
	   //  Constructor: Sets up the list of staff members.
	   //-----------------------------------------------------------------
	   public MacDonaldFarm ()   {
      		hisFarm = new Animal[5];

      		hisFarm[0] = new Chick();
                hisFarm[1] = new Cow();
                hisFarm[2] = new Pig();
                hisFarm[3] = new Dog("dog");
                hisFarm[4] = new FarmDog("Sparky");

		}

		public String toString() {

			Animal currentAnimal;
			String song = "";
			String sound = "";

			song = "Old MacDonald had a farm\nE I E I E\n";
			for (int i = 0; i < hisFarm.length; i++)
			{	currentAnimal = hisFarm[i];
				sound = currentAnimal.getAnimalSound();
				song += "And on the farm he has a " + currentAnimal.getAnimalType() + "\nE I E I O!\nWith a ";
				song += sound + "-" + sound + " here \nand a " + sound + "-" + sound + " there\nHere a " + sound;
				song += " -- there a " + sound + "\nEverywhere a " + sound + "-" + sound + "\nOld MacDonald had a farm\nE I E I O\n\n";
			}

			return song;
		}
	}




