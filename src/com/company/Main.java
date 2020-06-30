package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println();
        System.out.println("###############################----WELCOME TO BOLLYWOOD GAME----##################################");

        System.out.println("Please Enter the movie name all in Capital Letter or numbers only , No special characters allowed.");
        System.out.println();
        System.out.print("So Enter the name of the movie here: ");

        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        String[] nameOfMovie = str.split("[\\s | . | , | ! | ? | ;  | : | @ |  * |']+");

        System.out.println();
        System.out.print("So the name of your movie is: ");
        for (int i=0;i<nameOfMovie.length;i++){
            System.out.print(nameOfMovie[i]+" ");
        }
        System.out.println();

        System.out.println("If this movie is correct then we can proceed further");
        System.out.println("Enter 'Y' or 'y' to proceed further to start with the game else 'N' or 'n' to resubmit movie name correctly");
        char yourAns=sc.next().charAt(0);
        switch (yourAns){

            case 'Y' :
            case 'y' :
                System.out.println("So lets start the game");
                        break;

            case 'N' :
            case 'n' :
                System.out.println("Re-enter the movie name");
                        break;

            default:    System.out.println("Invalid Input");
                        System.out.println("Re-Enter the value in either 'y' or 'n'");

        }

        if (yourAns=='Y' || yourAns=='y'){
            System.out.println();
            System.out.println();
            System.out.println("###############################--The game has started---############################");
            System.out.println();
            System.out.println();
            System.out.println("Fill in the blank below to find the name of the movie");
            System.out.println("The movie is as follows");
            System.out.println();
            System.out.println();
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
        System.out.println("So now you start guessing the movie by using any capital alphabet or numbers");
        System.out.println();


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
            System.out.print("Guess the alphabet or number here : ");
            char guess=sc.next().charAt(0);
            sc.nextLine();

            //TestCases will be if the guess is correct, if the guess is incorrect, if the guess is already guessed, and if the guess is invalid

            //If the guess is invalid
            if ((guess<=65 || guess>=90) && (guess<=48 || guess>=57)){
                System.out.println("Invalid Guess : Enter only capital letter alphabets or numbers");
            }
            //If the guess is already guessed
            else if (guessedCorrectly.contains(guess) || incorrectGuessed.contains(guess)){
                System.out.println("This alphabet is already guessed : Guess again");
            }
            //If the guess is incorrect
            else if (!movieSet.contains(guess)){
                System.out.println("Wrong guess");
                incorrectGuessed.add(guess);
            }
            //If the guess is correct
            else{
                System.out.println("Right guess");
                guessedCorrectly.add(guess);

                System.out.println("The name of the movie after this guess is as");
                for (int i=0;i<nameOfMovie.length;i++){
                    for (int j=0;j<nameOfMovie[i].length();j++){
                        if (guessedCorrectly.contains(guess) && nameOfMovie[i].charAt(j)==guess){
                            System.out.print(guess+" ");
                        }else{
                            System.out.print("_ ");
                        }

                    }
                    System.out.print("        ");
                }
            }


        }

    }
}
