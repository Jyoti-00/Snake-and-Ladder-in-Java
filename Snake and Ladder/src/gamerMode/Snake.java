package gamerMode;

import java.util.*;

/* In this class, The beginning and the finishing of Ladder object is created by taking
 * two integer instance variables
 */

public class Snake {
	
int beginning;
int finishing;


/* This constructor takes the finishing(tail) integer value and the beginning(head) integer value of snake as arguments 
 * to use them as parameter and compares the argument. As the tail(finishing) value of a snake is always less than 
 * the head(beginning) value of the snake, The constructor acts upon it and creates snake
 */


public Snake (int b, int f) {
	
if (b>f){
	
beginning=b;
finishing=f;

}

   else {
	
beginning=f;
finishing=b;

        }

    }

}