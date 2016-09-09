import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Billy on 9/7/2016.
 */
public class SearchTest {
    private Search sTest;
    Integer intCase;
    Integer[] evenArray, oddArray, emptyArray;

    @Before
    public void setUp() throws Exception {
        sTest = new Search();
        oddArray = new Integer[]{3, 4, 5, 7, 8, 12, 15};
        evenArray = new Integer[]{4, 5, 7, 8, 12, 15};
        emptyArray = new Integer[]{};

    }

    @After
    public void tearDown() throws Exception {
        sTest = null;
        evenArray = null;
        oddArray = null;
        emptyArray = null;
    }

    @Test
    public void test111() throws Exception {
        intCase = 3;

        assertEquals(0, sTest.binarySearch(oddArray, intCase));
    }

    @Test
    public void test112() throws Exception {
        intCase = 4;

        assertEquals(0, sTest.binarySearch(evenArray, intCase));
    }

    @Test
    public void test121() throws Exception {
        intCase = 2;
        assertEquals(0, sTest.binarySearch(oddArray, intCase));
    }

    @Test
    public void test122() throws Exception {
        intCase = 2;

        assertEquals(0, sTest.binarySearch(evenArray, intCase));

    }

    @Test
    public void test211() throws Exception {
        intCase = 15;

        assertEquals(6, sTest.binarySearch(oddArray, intCase));

    }

    @Test
    public void test212() throws Exception {
        intCase = 15;

        assertEquals(5, sTest.binarySearch(evenArray, intCase));

    }

    @Test
    public void test221() throws Exception {
        intCase = 16;

        assertEquals(6, sTest.binarySearch(oddArray, intCase));

    }

    @Test
    public void test222() throws Exception {
        intCase = 16;

        assertEquals(5, sTest.binarySearch(evenArray, intCase));
    }

    @Test
    public void test311() throws Exception {
        intCase = 8;

        assertEquals(4, sTest.binarySearch(oddArray, intCase));
    }

    @Test
    public void test312() throws Exception {
        intCase = 8;

        assertEquals(3, sTest.binarySearch(evenArray, intCase));
    }

    @Test
    public void test321() throws Exception {
        intCase = 11;

        assertEquals(5, sTest.binarySearch(oddArray, intCase));
    }

    @Test
    public void test322() throws Exception {
        intCase = 11;

        assertEquals(4, sTest.binarySearch(evenArray, intCase));
    }

    @Test
    public void test13() throws Exception {
        intCase = 6;

        assertEquals(0, sTest.binarySearch(emptyArray, intCase));

    }
}