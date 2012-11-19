package guessNumber.model;

import guessNumber.GuessResult;

import java.util.ArrayList;

public class UniqueNumber extends ArrayList {
    private int capacity;

    public UniqueNumber(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean add(Object o) {
        try{
            int member = Integer.valueOf(String.valueOf(o));
            if(size() >= capacity || contains(member)){
                return false;
            }
            return super.add(member);
        }catch(NumberFormatException cce){
            return false;
        }
    }

    public GuessResult verify(UniqueNumber anotherNumber) {
        int numberOfA = 0, numberOfB = 0;
        for(int index = 0; index < this.size(); index++){
            int actualPosition = anotherNumber.indexOf(get(index));
            if(actualPosition == index) {
                numberOfA++;
            }
            if(actualPosition >= 0 && actualPosition != index) {
                numberOfB++;
            }
        }
        return new GuessResult(numberOfA, numberOfB);
    }
}
