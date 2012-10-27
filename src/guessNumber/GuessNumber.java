package guessNumber;

public class GuessNumber {

    private String randomNumber;

    public GuessNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String validate(String userInput) {
        if(userInput.equals(randomNumber)){
            return "4a0b";
        }
        return "3a0b";
    }
}
