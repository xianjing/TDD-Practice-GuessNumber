package guessNumber;

public class GuesserGame {

    private GuessNumber guessNumber;
    public GuesserGame(INumberGenerator numberGenerator) {
        guessNumber = new GuessNumber(numberGenerator.generate());
    }

    public String accept(String input) {
        String result = guessNumber.validate(input);
        if(result.equals("4a0b")){
            return "You win";
        }
        return result;
    }
}
