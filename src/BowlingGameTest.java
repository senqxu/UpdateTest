
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {

    @Test
    public void test_all_strike() throws Exception{
        String bowlingCode = "X|X|X|X|X|X|X|X|X|X||XX";
        assertEquals(300, new BowlingGame().getBowlingScoere(bowlingCode));
    }

    @Test
    public void test_second_spare() throws Exception{
        String bowlingCode = "5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5"; //150
        assertEquals(150, new BowlingGame().getBowlingScoere(bowlingCode));
    }

    @Test
    public void test_second_miss() throws Exception{
        String bowlingCode = "9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||"; //90
        assertEquals(90, new BowlingGame().getBowlingScoere(bowlingCode));
    }
}