package guessNumber;

import guessNumber.exception.MaximumTriesExceedException;
import guessNumber.generator.INumberGenerator;
import guessNumber.generator.RandomNumberGenerator;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Game {

    private static Guesser guesser;
    private final InputStream inputStream;
    private final PrintStream out;

    public Game(INumberGenerator numberGenerator, InputStream in, PrintStream out) {
        guesser = new Guesser(numberGenerator);
        inputStream = in;
        this.out = out;
    }

    public static void main(String[] args){
        new Game(new RandomNumberGenerator(), System.in, System.out).run();
    }

    public void run() {
        Scanner scanner = new Scanner(inputStream);
        while(scanner.hasNext()) {
            String input = scanner.nextLine();
            try{
                GuessResult result = guesser.validate(input);
                out.println(result.toString());
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
