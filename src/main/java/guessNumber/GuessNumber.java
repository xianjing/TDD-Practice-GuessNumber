package guessNumber;

import java.util.Arrays;

public class GuessNumber {

    private int[] randomNumber;

    public GuessNumber(INumberGenerator generator) {
        this.randomNumber = generator.generate();
    }

    public String validate(String userInput) {
        int[] inputAsInt = toInt(userInput);
        
        int numberOfA = 0, numberOfB = 0;

        for(int index = 0; index < inputAsInt.length; index++){
            int expectedPosition = search(inputAsInt[index], randomNumber);
            if(expectedPosition == index) {
                numberOfA++;
            }
            if(expectedPosition >= 0 && expectedPosition != index) {
                numberOfB++;
            }
        }

        return String.format("%da%db",numberOfA,numberOfB);
    }

    private int search(int inputInt, int[] number) {
        Arrays.sort(number);
        return Arrays.binarySearch(randomNumber, inputInt);
    }

    private int[] toInt(String input){
        int[] result = new int[4];
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++){
            result[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return result;
    }
}
