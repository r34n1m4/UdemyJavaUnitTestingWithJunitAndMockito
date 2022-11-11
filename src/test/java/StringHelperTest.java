import junit.StringHelper;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {
    //AACD => CD; ACD => CD; CDEF => CDEF; CDAA => CDAA;

    StringHelper helper = new StringHelper();

    @Test
    public void testTruncateAInFirst2Positions_AinFrist2Positions() {
        StringHelper helper = new StringHelper();
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AinFristPosition() {
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    @Test
    public void testTruncateAInFirst2Positions_noA() {
        assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
    }

    @Test
    public void testTruncateAInFirst2Positions_AinLastPositions() {
        assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
    }
}
