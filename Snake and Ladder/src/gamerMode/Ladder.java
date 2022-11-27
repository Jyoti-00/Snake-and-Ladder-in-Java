package gamerMode;

/* In this class, The beginning and the finishing of Ladder object is created by taking
 * two integer instance variables
 */

public class Ladder {
	
int beginning;
int finishing;


/* This constructor takes the finishing(top) integer value and the beginning(bottom) integer value of ladder as arguments 
 * to use them as parameter and compares the argument. As the bottom(beginning) value of a ladder is always less than 
 * the top(finishing) value of the ladder, The constructor acts upon it and creates ladder
 */

public Ladder (int b,int f) { 
	
if(b<f) {
	
beginning = b;
finishing = f;

}

else {
beginning = f;
finishing = b;

     }

}

/* ladderUp is called after using BigStick and checks if the top of the ladder falls 
 * in the last row (91-100). If it does not, it adds one step (10 position square) to the 
 * ladder.
 */

public void ladderUp() {
	
	/* If the top of ladder is at 80th square, BigStick can be used as it will take the 
	 * top to 90th square (last square of 9th row)
	 * else, BigStick can not be used
	 * 
	 */
	
if (finishing>80) { 
	
	System.out.println("Ooopps...You can not use BigStick here");
	
} 
else {
	
finishing+=10;

        }

    }

}
