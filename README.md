# Snake and Ladder Game in Java

## Overview

This project is a Java-based implementation of the classic **Snake and Ladder** board game, enriched with unique features to enhance gameplay. Designed for 2 to 4 players, it offers an engaging experience with additional elements like biscuits and bigsticks, providing strategic depth beyond the traditional game.

## Gameplay Features

- **Standard Mechanics**: Players roll a dice to advance on a 100-square board, aiming to reach the final square exactly to win.
- **Snakes and Ladders**: Landing on a snake's head moves the player down to its tail, while landing at the base of a ladder climbs the player up to its top.
- **Exact Roll Requirement**: Players must roll the exact number needed to land on the 100th square to win.
- **Bonus Rolls**: Rolling a 6 grants an additional dice roll.
- **Biscuits**: Collectible items that, when held, allow players to neutralise the effect of the next snake they encounter.
- **Bigsticks**: Tools that enable players to extend a ladder by one step, except in the final row (squares 91-100).

## Installation and Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Jyoti-00/Snake-and-Ladder-in-Java.git
   cd Snake-and-Ladder-in-Java
   
2. Open in Eclipse IDE:
Launch Eclipse.
Navigate to File > Open Projects from File System....
Click Directory... and select the cloned repository folder.
Click Finish to load the project.
3. Build and Run the Application:
In the Project Explorer, locate the main class file, typically named SnakeAndLadder.java.
Right-click on the file and select Run As > Java Application.

How to Play

1. Start the Game: Launch the application to display the game board.
2. Roll the Dice: Players take turns clicking the roll button to generate a dice outcome.
3. Move Tokens: Advance your token based on the dice roll, following the board's numbering.
4. Encounter Snakes and Ladders:
Snakes: Landing on a snake's head moves your token down to its tail.
Ladders: Landing at the base of a ladder moves your token up to its top.
5. Utilise Biscuits and Bigsticks:
Biscuits: Automatically used to prevent the effect of a snake when encountered.
Bigsticks: Applied to extend a ladder by one step when landed upon, except in the final row.
6. Winning the Game: The first player to land exactly on the 100th square wins. If a player's roll exceeds the required number to reach 100, their token remains in place until a suitable roll is achieved.

