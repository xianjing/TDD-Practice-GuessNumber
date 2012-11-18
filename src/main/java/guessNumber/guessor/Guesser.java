package guessNumber.guessor;

import guessNumber.model.UniqueNumber;

import java.util.Arrays;

public class Guesser {

    private UniqueNumber randomNumber;

    public Guesser(UniqueNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String verify(UniqueNumber input) {
        int numberOfA = 0, numberOfB = 0;
        for(int index = 0; index < input.size(); index++){
            int expectedPosition = search(input.get(index), randomNumber.toArray());
            if(expectedPosition == index) {
                numberOfA++;
            }
            if(expectedPosition >= 0 && expectedPosition != index) {
                numberOfB++;
            }
        }

        return String.format("%da%db",numberOfA,numberOfB);
    }

    private int search(Object inputInt, Object[] number) {
        Arrays.sort(number);
        return Arrays.binarySearch(number, inputInt);
    }

}
