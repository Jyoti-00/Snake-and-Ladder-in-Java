package gamerMode;

import java.util.Scanner; // for taking players' keyboard input


/* In this class, the attributes of players are defined
  */

public class Player {
	
int newsquare; // Square position as integer
String playername; // String value to store playername

Biscuit biscuit1,biscuit2;
BigStick bigstick1,bigstick2;


/* The name of the players are passed as argument in this constructor 
 * and the constructor takes them as parameter to create the initial state 
 * of the players
 * 
 */

public Player (String pname) {
	
playername = pname;
newsquare = 1; // the starting square of the game is 1 and last square number of the first row is 10

/*Declaring initial state of 
 * biscuits and BigSticks
 */

biscuit1=null; 
biscuit2=null;
bigstick1=null;
bigstick2=null;

}

/* The method playermovement() collects an integer value as argument and after the player moves,
 * this method returns the square number of the players' final position after movement
 */

public int playermovement(int dicevalue) {
	
int current = newsquare;
newsquare += dicevalue;

/*Player needs to reach EXACT 100th square to win
 */

if (newsquare>100) { 
System.out.println("["+playername+"] rolled a ["+dicevalue+"] but no movement as more is not better always");
newsquare=current;
}
else {
System.out.println("["+playername+"] rolled a ["+dicevalue+"] and moved from square ["+current+"] to ["+newsquare+"].");
}

return newsquare; // returning players' new position

}


	
	
/* The landOnBigStick() method is called when a player reaches a square that holds the position of a BigStick.
 * This method assigns the BigStick to the player and the BigStick gets removed from that position so that 
 * player who comes after in that position square, does not get a BigStick
 */

public void landOnBigStick(BigStick bgstck) {
	
if (bigstick1==null)	 {

bigstick1=bgstck;
bgstck.operative=false;

System.out.println("Yaaayy...you just got a BigStick...use it on ladder and gooo all the wayyy high");

}
else if (bigstick2==null){
	
bigstick2=bgstck;
bgstck.operative=false;

System.out.println("Yaaayy...you just got a BigStick...use it on ladder and gooo all the wayyy high");
    }
}


/* The landOnBiscuit() method is called when a player reaches a square that holds the position of a biscuit.
 * This method assigns the biscuit to the player and the biscuit gets removed from that position so that 
 * player who comes after in that position square, does not get a biscuit
 */

public void landOnBiscuit(Biscuit bisc) {
	
	if (biscuit1==null) {
		
	biscuit1=bisc;
	bisc.operative = false;
	
	System.out.println("yaaayy...you just got a biscuit...feed it to the snake and make it happy");
	
	}
	else if (biscuit2==null){
		
		biscuit2=bisc;
		bisc.operative= false;
		
		System.out.println("yaaayy...you just got a biscuit...feed it to the snake and make it happy");
		
	}
	
}



/* When a player reaches a ladder Bottom, this meetsWithLadder() method is called and it Uses Ladder object as argument.
 * It checks if the player has a BigStick or not. If the player does not have any BigStick, it takes the player
 * to the top of the ladder. If the player has a BigStick, it asks if he wants to use it. If the player uses the 
 * BigStick, ladderUp() is called and after checking if the top of the ladder does not fall in the last row,
 * it adds one-row (10 square) with the ladder top
 */

public int meetsWithLadder (Ladder ladd) {
	
int current = newsquare;

Scanner input = new Scanner (System.in);

if(bigstick1!= null||bigstick2!=null) {
	
	int bgstk = 0;
	if (bigstick1!=null) {bgstk++;}
	if (bigstick2!=null) {bgstk++;}
	
	System.out.println( "Yaayy...it is a ladder, it will take you from ["+ladd.beginning+"] to ["+ladd.finishing+"]");
	System.out.println("Mmmm... "+bgstk+" BigSticks there in your BagPack, you sure want to use them? (Will take you 10 more square ahead)");
	System.out.println("Please Enter 2 to use BigSticks and go higher...press any other digit to skip.");
	
	int playerinput = input.nextInt();
	if (playerinput==2){
		if(bigstick2!=null){
		bigstick2=null;
		ladd.ladderUp();
		newsquare=ladd.finishing;
		
		
		return newsquare;
		} else if(bigstick1!=null) {
		bigstick1=null;
		ladd.ladderUp();
		newsquare=ladd.finishing;
		return newsquare;
		} else  {
		System.out.println("Ooopps... you do not have any BigStick");
		        }
		    }
}	
	newsquare=ladd.finishing;
if (newsquare>100) {
System.out.println("["+playername+"] got to a Ladder but no movement as more is not better always.");
newsquare=current;
}else {
System.out.println("Yaayy... ["+playername+"] got to a Ladder and moved from square ["+current+"] to square["+newsquare+"].");
}
return newsquare;

}



/* When a player reaches a Snake Head, this meetsWithSnake() method is called and it Uses Snake object as argument.
 * It checks if the player has a Biscuit or not. If the player does not have any Biscuit, it takes the player
 * to the tail of the snake. If the player has a Biscuit, it asks if he wants to use it. If the player uses the 
 * Biscuit, the position of the player stays same (does not go to the snake tail)
 * 
 */

public int meetsWithSnake (Snake snk){
	
int current = newsquare;
Scanner input = new Scanner (System.in);

if(biscuit1!= null||biscuit2!=null){
int bisct=0;

if (biscuit1!=null) {bisct++;}
if(biscuit2!=null) {bisct++ ;}

System.out.println( "Oooppss...Unfortunately, a snake has biten you and will move you from square ["+snk.beginning+"] to ["+snk.finishing+"]");
System.out.println("Mmmm... "+bisct+" Biscuits there in your BagPack, you sure want to use them?"); 
System.out.println("Please Enter 1 to use biscuits, press any other digit to skip.");

int playerinput = input.nextInt();

if (playerinput==1){
	
if (biscuit2!= null){
	
biscuit2 = null;

return newsquare;

} else if (biscuit1!=null) {
	
biscuit1=null;
return newsquare;

}
    else{
System.out.println("Ooopps... you do not have any Biscuits.");
        }
    }
}
newsquare=snk.finishing;

if (newsquare<1) {
	
System.out.println("Oooppss...["+playername+"] bitten by a snake but fortunately is not Eaten ");

newsquare=current;

} else{
System.out.println("Ooopss..["+playername+"] bitten by a snake and got from square ["+current+"] to square["+newsquare+"].");
      }
return newsquare;

    }



/* The winningmoment() method is called when a player reaches the 100th square, thus, winning the game*/

public void winningmoment() {
	
System.out.println("Congrrraaaatuulatiooonnsss ["+playername+"]!!!  you just won the world of Deep's Snake and Ladder! ");

      }


}

