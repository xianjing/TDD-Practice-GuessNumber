package guessNumber;

import guessNumber.exception.MaximumTriesExceedException;
import guessNumber.generator.INumberGenerator;
import guessNumber.generator.RandomNumberGenerator;

import java.util.Scanner;

public class Game {

    private static GuessNumberApp guessNumberApp;

    public Game() {
        INumberGenerator numberGenerator = new RandomNumberGenerator();
        guessNumberApp = new GuessNumberApp(numberGenerator);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String input = scanner.nextLine();
            try{
                String result = guessNumberApp.accept(input);
                if(result.equalsIgnoreCase("4a0b")){
                    System.out.println("You Win");
                    System.exit(0);
                }
                System.out.println(result);
            }catch (MaximumTriesExceedException exception){
                System.out.println("Game Over");
                System.exit(0);
            }
        }
    }
}
