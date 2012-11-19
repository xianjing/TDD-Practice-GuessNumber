package guessNumber;

import guessNumber.generator.INumberGenerator;

public class GuessResult {
    private int numberOfA;
    private int numberOfB;

    public GuessResult(int numberOfA, int numberOfB) {
        this.numberOfA = numberOfA;
        this.numberOfB = numberOfB;
    }

    public boolean isCorrect(){
        return this.numberOfA == INumberGenerator.ALLOWED_DIGITS && this.numberOfB == 0;
    }

    @Override
    public String toString() {
        if(isCorrect()){
            return "You win";
        }
        return String.format("%da%db", this.numberOfA, this.numberOfB);
    }

    @Override
    public boolean equals(Object o) {
        GuessResult that = (GuessResult) o;

        if(this.numberOfA == that.numberOfA
                && this.numberOfB == that.numberOfB){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = numberOfA;
        result = 31 * result + numberOfB;
        return result;
    }
}
