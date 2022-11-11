package junit_tests;

import junit.StringHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {
    //AACD => CD; ACD => CD; CDEF => CDEF; CDAA => CDAA;

    StringHelper helper = new StringHelper();

    private String input;
    private String expectedOutput;

    public StringHelperParameterizedTest(String input, String expectedOutput) {
        super();
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<String[]> testConditions() {
        String expectedOutput [] [] = {
            {"AACD", "CD"}, {"ACD", "CD"}, {"CDEF", "CDEF"}, {"CDAA", "CDAA"}
        };
        return Arrays.asList(expectedOutput);
    }

    @Test
    public void testTruncateAInFirst2Positions() {
        StringHelper helper = new StringHelper();
        assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
    }


//    //ABCD = > false, ABAB => true, AB => true, A => false;
//    @Test
//    public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
//        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
//    }
//    @Test
//    public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
//        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
//    }
//    @Test
//    public void testAreFirstAndLastTwoCharactersTheSame_twoLettersPositiveScenario() {
//        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
//    }
//    @Test
//    public void testAreFirstAndLastTwoCharactersTheSame_oneLetterPositiveScenario() {
//        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
//    }
}
