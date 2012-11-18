import guessNumber.model.UniqueNumber;

public class UniqueNumberBuilder {
    private int[] numbers;
    
    public UniqueNumberBuilder withNumbers(int[] numbers){
        this.numbers = numbers;
        return this;
    }

    public UniqueNumber build(){
        UniqueNumber uniqueNumber = new UniqueNumber(numbers.length);
        for (int i : numbers){
            uniqueNumber.add(i);
        }
        return uniqueNumber;
    }
}
