package gamerMode;

import java.util.*;


/* This class contains the main method and is called while 
 * playing the game
 */

public class Main{
public static void main(String[]args){

//Variables are declared here and initialized
 
Scanner input = new Scanner (System.in);
 
boolean extraturn = false;
boolean endgame = false;

Ladder [] ladders = arrayofLadders();
Snake[] snakes = arrayofSnakes();


/* Position square of Biscuits and
 * BigSticks are declared
 */
Biscuit biscuit1 = new Biscuit (36);
Biscuit biscuit2 = new Biscuit (61);
BigStick bigstick1 = new BigStick(43);
BigStick bigstick2 = new BigStick(52);

// Asking the users about the number of players and storing the name of the players
//in an array

System.out.println("Helllooo, Most Welcome to the world of Deep's Snake and Ladders");
System.out.println("Please select the number of Players between [2-4]:");

int number = Integer.parseInt (input.nextLine()) ; // Taking Player numbers
Player [] playerr = new Player [number];


//Declaring and initializing the attribute of every player

System.out.println( "Please Enter the names of the Players Now:");

for (int i=0; i<number; i++) {
	
 int playerid = i+1;
System.out.println("please Enter the name of the player "+ playerid +":");

String playername = input.nextLine();

playerr[i]=new Player (playername) ;

}

System.out.println("Thank you, Happy Gaming... The World of Snake and Ladder is yours") ;

int i=0;
int dicerolling=0;


//Using endgame as a boolean variable and untill it is true, the game is played

int match_tracker = 0;

ArrayList<Integer> winners = new ArrayList<Integer>(); // arraylist to store the winner names

while (!endgame) {
	
	if(match_tracker>0 && winners.contains(i) ){
	    System.out.println(  "Someone already nailed it");
	      i++;
	      if(i>=playerr.length){
	          i=0;
	      }
	      continue;

	}
	

/*Players are told to press 'd' to roll the dice
 * anything except 'd' results the player in a lost turn
 */
	
	
System.out.println("["+playerr[i].playername+"]s turn now : Please Enter 'd' to Roll the Dice");

String userin = input.nextLine();
if(userin.length()<1){
  continue;
}

char userinput = userin. charAt (0) ;

if(userinput == 'd') {
	
	/*if 'd' is pressed, dicerolledoutput() method is called
	 * which generates a random integer between 1-6
	 */
	
dicerolling = dicerolledoutput();  
if(dicerolling==6){    // player gets extra turn if dicerollingoutput is 6 by turning a boolean variable 'extraturn' true
   extraturn=true;
}

}
else { 
System.out.println("Oooppss...wrong button pressed, You lost your turn unfortunately");

i++;

if(i>=playerr.length){
  i = 0;
}
continue;

}
int currentsquare = playerr[i].playermovement(dicerolling); // Storing the current square position of player


/*The player ascends by the diceroll number and if he reaches 100, loop terminates by turning the boolean variable to true and player wins*/

if (currentsquare==100){
	playerr[i].winningmoment();
	winners.add(i);
	match_tracker++;
	if(match_tracker==playerr.length-1) {
endgame=true;
final_output(winners, playerr);
break;

}
	i++;
	if (i>=playerr.length) {
		i = 0;
	}
	continue;
	
	}else{
	
/*Moving forward after each roll, it checks if the player reaches any
 * biscuits or BigSticks square. If it reaches any,
 * respective methods are called
 */
	
if (currentsquare==bigstick1.bigstksquare && bigstick1.operative) {
	
playerr[i].landOnBigStick(bigstick1);

}
if (currentsquare==bigstick2.bigstksquare && bigstick2.operative) {
	
playerr[i].landOnBigStick(bigstick2);

}
if(currentsquare==biscuit1.biscsquare && biscuit1.operative) {
	
playerr[i].landOnBiscuit(biscuit1);

}
if (currentsquare==biscuit2.biscsquare && biscuit2.operative) {
	
playerr[i].landOnBiscuit(biscuit2);

}

}


/*After moving based on the dice rolled output, if the player reaches a snake,
 * meetsWithSnake() method is called
 */

for (Snake s : snakes) {
	
if (playerr[i].newsquare==s.beginning) {
if (dicerolling==6){
extraturn=true;
}
currentsquare=playerr[i].meetsWithSnake(s);
break;
   }
}

if(currentsquare==100){
endgame=true;
playerr[i].winningmoment();
continue; // 
}else {
if (currentsquare==bigstick1.bigstksquare && bigstick1.operative) {
playerr[i].landOnBigStick(bigstick1);
}
if (currentsquare==bigstick2.bigstksquare && bigstick2.operative) {
playerr[i].landOnBigStick(bigstick2);
}
if (currentsquare==biscuit1.biscsquare && biscuit1.operative){
playerr[i].landOnBiscuit(biscuit1);
}
if (currentsquare==biscuit2.biscsquare && biscuit2.operative) {
playerr[i].landOnBiscuit(biscuit2);
}

}

/*After moving based on the dice rolled output, if the player reaches a ladder,
 * meetsWithLadder() method is called
 */

for (Ladder s : ladders) {
	
if (playerr[i].newsquare==s.beginning){
	
if (dicerolling==6) {
extraturn=true;

    }
currentsquare=playerr[i].meetsWithLadder(s);
break;

    }

}
if (currentsquare==100){
	
endgame=true;
playerr[i].winningmoment();
break;
}
else{
if(currentsquare==bigstick1.bigstksquare && bigstick1.operative) {
playerr[i].landOnBigStick(bigstick1);

}
if (currentsquare==bigstick2.bigstksquare && bigstick2.operative) {
	
playerr[i].landOnBigStick(bigstick2);
}
if(currentsquare==biscuit1.biscsquare && biscuit1.operative) {
	
playerr[i].landOnBiscuit(biscuit1);
}
if (currentsquare==biscuit2.biscsquare && biscuit2.operative) {
	
playerr[i].landOnBiscuit(biscuit2);


     }
}


/* If the player gets a 6 in the dice rolling and reaches a snake or a ladder,
 * the extraturn variable is true and current position of the player is not updated 
 current player gets extra turn to roll dice, otherwise the next player gets dice rolling chance
 */

if(!extraturn){
	
i++;

}

extraturn=false;

if(i>=playerr.length){
      i=0;
       }
    }

}


/*the dicerolledoutput() method generates a random number between 1 and 6 (Similiar to rolling a dice in real world game
 * and return the value as integer
 */
public static int dicerolledoutput() {
Random die = new Random();
int outputd=die.nextInt(6)+1;
return outputd;
}



/* The arrayofLadders() method initializes an array of ladders and 
 * returns the value
 */

public static Ladder[] arrayofLadders(){
Ladder[] aol = new Ladder[6];
aol[0]= new Ladder (20,38);
aol[1]= new Ladder (29,57);
aol[2]= new Ladder (45,78);
aol[3]= new Ladder (60,82);
aol[4]= new Ladder (73,90);
aol[5]= new Ladder (84,95);
return aol;

      }


/* The arrayofSnakes() method initializes an array of snakes and 
 * returns the value
 */

public static Snake[] arrayofSnakes(){
Snake[] aos = new Snake[6];
aos[0]= new Snake (64,19);
aos[1]= new Snake (33,6);
aos[2]= new Snake (75,27);
aos[3]= new Snake (81,23);
aos[4]= new Snake (86,59);
aos[5]= new Snake (92,18);
return aos;

     }

/* Winners names are stored here chronologically
 */

public static void final_output(ArrayList<Integer> list,Player []p){
    String result = "";
    System.out.println("Winners:> first>second>third");
    for (int i: list){
      result = result + p[i].playername+" \n";
    }
    System.out.println("Winners: \n"+result);
}


}