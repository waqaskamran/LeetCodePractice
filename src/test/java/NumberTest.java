import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTest {

    @Test
    public void getThirdHighestNumber(){
        int[] numbers ={2,4,6,8,9,10,10} ;
        int expectedNumber = 8;
        int thirdLargestNumber = NumberUtils.findThirdLargestNumber(numbers);
        assertEquals(expectedNumber,thirdLargestNumber);
    }
}
