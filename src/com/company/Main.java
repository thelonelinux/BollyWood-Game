package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println();
        System.out.println("########################################################################     -------     WELCOME   TO   BOLLYWOOD   GAME     -------     #####################################################################");
        System.out.println();
        System.out.println();
        System.out.print("ENTER THE NAME OF YOUR MOVIE HERE (USE ONLY CAPITAL LETTER OR NUMERICAL DIGITS ONLY, NO SPECIAL CHARACTERS ALLOWED->>");

        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        String[] nameOfMovie = str.split("[\\s | . | , | ! | ? | ;  | : | @ |  * |']+");

        System.out.println();
        System.out.print("YOUR MOVIE NAME IS-------> ");
        for (int i=0;i<nameOfMovie.length;i++){
            System.out.print(nameOfMovie[i]+" ");
        }
        System.out.print(" <-------");

        System.out.println(" ####################-----> CHECK THE NAME IF ALL SPELLINGS ARE CORRECT AND AUTHENTICATE <---------");
        System.out.print("ENTER 'Y' OR 'y' TO PROCEED FURTHER TO START WITH THE GAME ELSE 'N' OR 'n' TO RESUBMIT MOVIE NAME CORRECTLY-->>");
        char yourAns=sc.next().charAt(0);
        switch (yourAns){

            case 'Y' :
            case 'y' :
                System.out.println();
                System.out.println("LETS BEGIN WITH THE GAME...........");
                        break;

            case 'N' :
            case 'n' :
                System.out.println("Re-enter the movie name");
                        break;

            default:    System.out.println("Invalid Input");
                        System.out.println("Re-Enter the value in either 'y' or 'n'");

        }

        if (yourAns=='Y' || yourAns=='y'){
            System.out.println("######################################################################   -----------    THE   GAME   HAS   STARTED   ----------   #########################################################################");
            System.out.println();
            System.out.println();
            System.out.print("Fill in the blank below to find the name of the movie :   ");
            System.out.print("THE MOVIE NAME IS AS FOLLOWS:-       ");
            for (int i=0;i<nameOfMovie.length;i++){
                for (int j=0;j<nameOfMovie[i].length();j++){
                    System.out.print("_ ");
                }
                System.out.print("         ");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("GUESS YOUR CHARACTER HERE (EITHER NUMBER OR CAPITAL LETTER ALPHABET)");

        Set<Character> movieSet=new HashSet<>();
        for (int i=0;i<nameOfMovie.length;i++){
            for (int j=0;j<nameOfMovie[i].length();j++){
                movieSet.add(nameOfMovie[i].charAt(j));
            }
        }

        //Till now alphabet you have discovered correctly
        Set<Character> guessedCorrectly=new HashSet<>();
        Set<Character> incorrectGuessed=new HashSet<>();
        while (!guessedCorrectly.equals(movieSet)){
            System.out.print("INCORRECT GUESSED LIST ----->"+incorrectGuessed+"            CORRECT GUESSED LIST ------>"+guessedCorrectly);
            System.out.print("          TYPE YOUR GUESSED CHARACTER HERE--->>");
            char guess=sc.next().charAt(0);
            sc.nextLine();
            System.out.println();

            //TestCases will be if the guess is correct, if the guess is incorrect, if the guess is already guessed, and if the guess is invalid

            //If the guess is invalid
            if ((guess<65 || guess>90) && (guess<48 || guess>57)){
                System.out.println("INVALID GUESS : ENTER ONLY CAPITAL LETTER ALPHABETS OR NUMBERS");
            }
            //If the guess is already guessed
            else if (guessedCorrectly.contains(guess) || incorrectGuessed.contains(guess)){
                System.out.println("THIS ALPHABET IS ALREADY BEING GUESSED : GUESS SOME NEW CHARACTER");
            }
            //If the guess is incorrect
            else if (!movieSet.contains(guess)){
                System.out.print("WRONG GUESS ------->");
                incorrectGuessed.add(guess);
            }
            //If the guess is correct
            else{
                System.out.print("RIGHT GUESS -------> ");
                guessedCorrectly.add(guess);

                System.out.print("NAME OF THE MOVIE NOW IS ---->>   ");


                //THIS WILL RUN ONLY ONCE , FIRST TO GET OUR STRING NAME
                for (int i=0;i<nameOfMovie.length;i++){
                    for (int j=0;j<nameOfMovie[i].length();j++){
                        if (guessedCorrectly.contains(guess) && nameOfMovie[i].charAt(j)==guess){
                            System.out.print(guess+" ");
                        }
                        else if(guessedCorrectly.contains(nameOfMovie[i].charAt(j))){
                            System.out.print(nameOfMovie[i].charAt(j)+" ");
                        }
                        else{
                            System.out.print("_ ");
                        }
                    }
                    System.out.print("        ");
                }
                System.out.println();
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Yahoo...! You won the game");

    }
}
