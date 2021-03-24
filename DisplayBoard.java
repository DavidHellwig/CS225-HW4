//David Hellwig
//Assignment 4
//CS 2235
//Due Date 2/16/2021
import java.util.Random;    //Import random so we can randomly do things later

public class DisplayBoard { //Begin the main class that will output things
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Random Randy = new Random();

        int randIndexRemoval = Randy.nextInt(20); //Create a random int with a limit so we get no errors

        ScoreBoard SpaceInvader = new ScoreBoard(500000);

        int controlLoop = 0; //Loop control variable

        String PlayerName = "Player "; //Building block to create random names

        while (controlLoop < 500000) { //A while loop that will create random names and scores and add them to the board

            Random rand = new Random();

            int randScore = rand.nextInt(1001);

            String tokenNum = String.valueOf(controlLoop); //Translate the int into text so it can be added to
            //the string
            String newName = PlayerName + tokenNum;

            GameEntry Player = new GameEntry(newName, randScore); //Create a randomly generated GameEntry object


            SpaceInvader.add(Player);

            controlLoop ++;
        }
        long time2 = System.currentTimeMillis();
        long test = time2 - time;
        System.out.println(test);

            //Display code that calls all the methods required to display the board and summary
            // SpaceInvader.printAll();

            //SpaceInvader.printSummary();

            //Remove a random GameEntry object
            // SpaceInvader.remove(randIndexRemoval);


            //SpaceInvader.printAll();

            //SpaceInvader.printSummary();
        }
    }
