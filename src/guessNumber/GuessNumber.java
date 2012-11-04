package guessNumber;

public class GuessNumber {

    private String serverNumber;

    public GuessNumber(String serverNumber) {
        this.serverNumber = serverNumber;
    }

    public String validate(String userInput) {
        return String.format("%da%db",
                getNumberOfA(userInput, serverNumber),
                getNumberOfB(userInput, serverNumber));
    }

    private int getNumberOfB(String input, String originalNumber) {
        int number = 0;
        char[] inputChars = input.toCharArray();
        for(int position = 0; position < 4; position++){
            int index = originalNumber.indexOf(inputChars[position]);
            if(isDigitCorrectButPositionNot(position, index)) {
                number ++;
            }
        }
        return number;
    }

    private int getNumberOfA(String input, String originalNumber) {
        char[] inputChars = input.toCharArray();
        int number = 0;
        for(int position = 0; position < 4; position++){
            int index = originalNumber.indexOf(inputChars[position]);
            if(isDigitExactlyMatch(position, index)) {
                number++;
            }
        }
        return number;
    }

    private boolean isDigitCorrectButPositionNot(int i, int index) {
        return index != -1 && index != i;
    }

    private boolean isDigitExactlyMatch(int i, int index) {
        return index != -1 && index == i;
    }

}
