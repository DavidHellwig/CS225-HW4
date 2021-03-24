//David Hellwig
//Assignment 4
//CS 2235
//Due Date 2/16/2021
import java.util.Arrays;
import java.util.Random;
import java.io.*; // I do not understand what this does but something breaks without it.This is... not ideal
import java.util.Random;

//ScoreBoard class for Homework 4
// PLEASE NOTE THAT THE ADDED CODE STARTS ON LINE 54 AND ENDS ON LINE 77
//Define program class
public class ScoreBoard {
    //Instance Variables
    private int numEntries = 0;
    private GameEntry[] board;

    //Constructor
    //Making an Empty ScoreBoard
    public ScoreBoard(int capacity) {
        board = new GameEntry[capacity];
    }

    //Method
    public void add(GameEntry e) {
        //Check to see if the score is high enough
        int newScore = e.getScore();
        //This assumes our array is already sorted from highest to lowest
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) {//No score needs to be dropped
                numEntries++;
            }
            int j = numEntries - 1;
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = e;
        }
    }
    public int  getSize(){
        return numEntries;
    }

    //Remove Element Method
    //This method will return and remove the element
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        GameEntry temp = board[i];
        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }
        board[numEntries - 1] = null;
        numEntries--;
        return temp;
    }
    public void addEntries(ScoreBoard l,int n) {
        Random Randy = new Random();



        int controlLoop = 0; //Loop control variable

        String PlayerName = "Player "; //Building block to create random names

        while (controlLoop < n) { //A while loop that will create random names and scores and add them to the board

            Random rand = new Random();

            int randScore = rand.nextInt(1001);

            String tokenNum = String.valueOf(controlLoop); //Translate the int into text so it can be added to
            //the string
            String newName = PlayerName + tokenNum;

            GameEntry Player = new GameEntry(newName, randScore); //Create a randomly generated GameEntry object
            l.add(Player);
            controlLoop ++;
        }
    }

    public void printAll() {
        System.out.println("Name      Score");
        for (int j = 0; j < numEntries ; j++) {
          //  System.out.println(board[j].toString() );
        }
    }
    //This method prints a summary of info
    public void printSummary() {
        int elementCount = numEntries; //Make a variable so we can print numEntries
       System.out.println("The total number of elements in the board are: " + elementCount); //Print the count

        System.out.println("The lowest score was " + board[numEntries -1]); //The list is sorted from high to low
                                                                            //So we go in reverse order to get the
                                                                            //lowest score
        System.out.println("The highest score was " + board[0]);            //As above, so below, highest ins the first
                                                                            //element in the array
        int sum = 0;    //Create a variable sum so we can do math and get an average, must be 0
        for (int j = 0; j < numEntries ; j++) { //Add all the scores together
            sum = sum + board[j].getScore(); //Add sum to the scores
        }
        int average = Math.round(sum / numEntries); //Round the average to the nearest int
        System.out.println("The average score was " + average); //Print the average
        int range = board[0].getScore() - board[numEntries -1].getScore(); //Find the range, high - low
        System.out.println("The range for all scores was " + range); //Print the range

        }
    }
