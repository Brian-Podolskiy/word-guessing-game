import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] words = {"HARP", "EAST", "WEST", "BOOM", "MOOD", "DOOM", "BUZZ", "FUZZ", "JAZZ", "LOVE", "QUIZ"};
        int random = new Random().nextInt(words.length), attempts = 5;
        GuessingGame word = new GuessingGame(words[random]);
        Scanner in = new Scanner(System.in);
        boolean end = false;
        String input = "";

        do{
            while (input.length() != word.getWordLength()){
                System.out.print("Enter a guess for the word, the word has " + word.getWordLength() + " characters in it: ");
                input = in.nextLine();
                input = input.toUpperCase();
            }

            System.out.println(word.userGuess(input));

            if (!(word.userGuess(input).equals(input.toUpperCase()))){
                attempts--;
                System.out.println(attempts + " attempts remaining");

                while (!(input.equals("y") && !(input.equals("n")))){

                    System.out.print("Do you want to try again? ");
                    input = in.nextLine();
                    input = input.toLowerCase();

                    if (input.equals("y")){
                        end = false;
                    }

                    else if (input.equals("n")){
                        end = true;
                        break;
                    }

                    else{
                        System.out.println("Either enter 'y' or 'n'.");
                    }
                }
            }

            else if (word.userGuess(input).equals(input.toUpperCase())){
                System.out.println("Correct! Would you like to play again? ");
                input = in.nextLine();
                input = input.toLowerCase();

                if (input.equals("y")){
                    end = false;
                    random = new Random().nextInt(words.length);
                    attempts = 5;
                    word = new GuessingGame(words[random]);
                }

                else if (input.equals("n")){
                    end = true;
                    break;
                }

                else{
                    System.out.println("Either enter 'y' or 'n'.");
                }

            }

        } while(end == false && attempts > 0);
    }
}