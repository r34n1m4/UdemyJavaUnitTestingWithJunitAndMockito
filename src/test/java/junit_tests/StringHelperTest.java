package junit_tests;

import junit.StringHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {
    //AACD => CD; ACD => CD; CDEF => CDEF; CDAA => CDAA;

    StringHelper helper;

    @Before
    public void before() {
        helper = new StringHelper();
    }

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
    //ABCD = > false, ABAB => true, AB => true, A => false;
    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }
    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }
    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_twoLettersPositiveScenario() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
    }
    @Test
    public void testAreFirstAndLastTwoCharactersTheSame_oneLetterPositiveScenario() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
    }
}
