
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {

    @Test
    public void test_all_strike() throws Exception{
        String bowlingCode = "X|X|X|X|X|X|X|X|X|X||XX";
        assertEquals(300, new BowlingGame().getBowlingScoere(bowlingCode));
    }
}