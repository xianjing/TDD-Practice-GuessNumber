package guessNumber.generator;

import guessNumber.model.UniqueNumber;

public interface INumberGenerator {
    public int ALLOWED_DIGITS = 4;
    UniqueNumber generate();
}
