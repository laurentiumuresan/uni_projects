package isp.lab2.Exercise4StringSearch;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SubstringSearchTest {
    @Test
    public void testSubstringSearch() {
        String input = "apples,computer,bread,tea,car";
        String substring = "te";
        String[] expected = {"computer", "tea"};
        String[] actual = Exercise4StringSearch.searchSubstrings(input, substring);
        assertArrayEquals(expected, actual);
    }
}
