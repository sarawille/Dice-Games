#Dice Games
    Play a digital, one-player game of Yahtzee or modified (two-dice) Pig

##Motivation
I began this project to practice object-oriented design and reinforce concepts I learned during the Cincy Code IT bootcamp at MAX Technical Training in Cincinnati, OH.  My goal for this project is to demonstrate my command of Java, SOLID principles and object-oriented design, including abstraction and dependency injection.

##Project Set-Up
Run ui/GameApp.java to play the game.  

To switch between Yahtzee and Pig, change the dependency-injected file called on line 18 of ui/GameApp.java:
<ul>
<li>Yahtzee: "YahtzeeApplicationContext.xml"</li>
<li>Pig: "PigApplicationContext.xml"</li>
</ul>

Dependencies for both games are expressed in the xml files listed above.  
<ul>
<li>displayInjection: Controls the output location, whether in the Console or a GUI.</li>
<li>validatorInjection: Controls how user inputs are evaluated (what is acceptable when asking for an integer, String, etc.).</li>
<li>scoreInjection: Controls how the game is scored.</li> 
</ul>

For more information on the program, see the <a href="https://github.com/sarawille/Yahtzee/tree/master/doc">JavaDoc files</a>.

##Testing
Unit tests are stored in the testing package.

##Game Rules
###_Pig_
Modified Pig requires a Hand of two dice.  The player rolls the Hand then chooses whether or not to roll again, as many times as wanted. The score is a running sum of the dice values. If one of the die turns up 1, the game ends immediately and the score for that turn is 0.  If both dice are 1, the game ends immediately and the final score is automatically 0.

###_Yahtzee_
Yahtzee requires a Hand of five dice.  The player rolls the Hand then has the option to re-roll any combination of dice up to two more times on each turn. The game lasts for 13 turns. The score is calculated depending on the face up values of each Hand and the user's choice of which scoring category to use at the end of each turn.  See <a href="https://github.com/sarawille/Yahtzee/blob/master/scoring/YahtzeeScore.java">YahtzeeScore.java</a> to learn more about the scoring categories and calculations.

##Author
<a href="http://www.linkedin.com/in/sarawille">Sara Wille</a>
