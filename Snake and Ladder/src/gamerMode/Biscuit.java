package gamerMode;


/*The attributes of Biscuits is defined in this class
 *Biscuit is given a certain position square number before the game starts. If player
 * lands on the particular square, the boolean value of Biscuit activates
 */ 


public class Biscuit {
	
boolean operative;

int biscsquare;

public Biscuit(int n) {
	
biscsquare = n;

operative = true; // Boolean value to check availability 

      }
  
}