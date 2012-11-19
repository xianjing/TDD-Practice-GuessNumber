import guessNumber.model.UniqueNumber;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

public class UniqueNumberTest {

    @Test
    public void should_create_a_unique_number_given_correct_input(){
        UniqueNumber uniqueNumber = new UniqueNumber(4);
        uniqueNumber.add(1);
        uniqueNumber.add(2);
        uniqueNumber.add(3);
        uniqueNumber.add(4);
        assertEquals(4,uniqueNumber.size());
    }

    @Test
    public void should_fail_when_add_duplicate_member(){
        UniqueNumber uniqueNumber = new UniqueNumber(4);
        uniqueNumber.add(1);
        boolean result = uniqueNumber.add(1);
        assertFalse(result);
    }

    @Test
    public void should_fail_when_new_member_not_number(){
        UniqueNumber uniqueNumber = new UniqueNumber(4);
        boolean result = uniqueNumber.add("A");
        assertFalse(result);
    }

    @Test
    public void should_fail_when_members_exceed_capacity(){
        UniqueNumber uniqueNumber = new UniqueNumber(4);
        uniqueNumber.add(1);
        uniqueNumber.add(2);
        uniqueNumber.add(3);
        uniqueNumber.add(4);
        boolean result = uniqueNumber.add(5);
        assertFalse(result);
    }
}
