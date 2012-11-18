package guessNumber;

import guessNumber.exception.MaximumTriesExceedException;
import guessNumber.generator.INumberGenerator;
import guessNumber.generator.RandomNumberGenerator;
import guessNumber.guessor.GuessResult;

import java.util.Scanner;

public class Game {

    private static Guesser guesser;

    public Game() {
        INumberGenerator numberGenerator = new RandomNumberGenerator();
        guesser = new Guesser(numberGenerator);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String input = scanner.nextLine();
            try{
                GuessResult result = guesser.validate(input);
                System.out.println(result.toString());
                if(result.isCorrect()){
                    System.exit(0);
                }
            }catch (MaximumTriesExceedException exception){
                System.out.println("Game Over");
                System.exit(0);
            }
        }
    }
}
