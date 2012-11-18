package guessNumber.model;

import guessNumber.exception.InvalidInputException;

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

    public static UniqueNumber toUniqueNumber(String input){
        UniqueNumber number = new UniqueNumber(4);
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(!number.add(chars[i])){
                throw new InvalidInputException();
            }
        }
        return number;

    }
}
