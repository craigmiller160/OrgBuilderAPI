package io.craigmiller160.orgbuilder.api.v1.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test case for the StringUtil
 * class and its methods.
 *
 * Created by Craig on 1/8/2016.
 */
public class StringUtilTest {

    @Test
    public void testEndsWithSpace(){
        String endsWithSpace = "Hello World ";
        String endsWithoutSpace = "Hello World";

        assertTrue(StringUtil.endsWithSpace(endsWithSpace));
        assertFalse(StringUtil.endsWithSpace(endsWithoutSpace));
    }

    @Test
    public void testEnsureEndsWithSpaceString(){
        String endsWithSpace = "Hello World ";
        String endsWithoutSpace = "Hello World";

        assertEquals(endsWithSpace,
                StringUtil.ensureEndsWithSpace(endsWithSpace));
        assertEquals(endsWithSpace,
                StringUtil.ensureEndsWithSpace(endsWithoutSpace));
    }

    @Test
    public void testEnsureEndsWithSpaceStringBuilder(){
        StringBuilder endsWithSpace = new StringBuilder("Hello World ");
        StringBuilder endsWithoutSpace = new StringBuilder("Hello World");

        assertEquals(endsWithSpace.toString(),
                StringUtil.ensureEndsWithSpace(endsWithSpace).toString());
        assertEquals(endsWithSpace.toString(),
                StringUtil.ensureEndsWithSpace(endsWithoutSpace).toString());
    }

    @Test
    public void testEnsureEndsWithSpaceStringBuffer(){
        StringBuffer endsWithSpace = new StringBuffer("Hello World ");
        StringBuffer endsWithoutSpace = new StringBuffer("Hello World");

        assertEquals(endsWithSpace.toString(),
                StringUtil.ensureEndsWithSpace(endsWithSpace).toString());
        assertEquals(endsWithSpace.toString(),
                StringUtil.ensureEndsWithSpace(endsWithoutSpace).toString());
    }

    /**
     * The method being tested here is used by
     * many of the other methods in StringUtil.
     * If this test fails, it is potentially
     * the cause of other test failures.
     */
    @Test
    public void testEnsureStringExists(){
        String exists = "Hello World";
        String emptyString = "";

        assertTrue(StringUtil.ensureStringExists(exists));
        assertFalse(StringUtil.ensureStringExists(null));
        assertFalse(StringUtil.ensureStringExists(emptyString));
    }

    @Test
    public void testEnsureEndsWithCommaSpaceString(){
        String endsWithCommaSpace = "Hello World, ";
        String endsWithSpace = "Hello World ";
        String noEndingChars = "Hello World";

        assertEquals(endsWithCommaSpace,
                StringUtil.ensureEndsWithCommaSpace(endsWithCommaSpace));
        assertEquals(endsWithCommaSpace,
                StringUtil.ensureEndsWithCommaSpace(endsWithSpace));
        assertEquals(endsWithCommaSpace,
                StringUtil.ensureEndsWithCommaSpace(noEndingChars));
    }

    @Test
    public void testEnsureEndsWithCommaSpaceStringBuilder(){
        StringBuilder endsWithCommaSpace = new StringBuilder("Hello World, ");
        StringBuilder endsWithSpace = new StringBuilder("Hello World ");
        StringBuilder noEndingChars = new StringBuilder("Hello World");

        assertEquals(endsWithCommaSpace.toString(),
                StringUtil.ensureEndsWithCommaSpace(endsWithCommaSpace).toString());
        assertEquals(endsWithCommaSpace.toString(),
                StringUtil.ensureEndsWithCommaSpace(endsWithSpace).toString());
        assertEquals(endsWithCommaSpace.toString(),
                StringUtil.ensureEndsWithCommaSpace(noEndingChars).toString());
    }

    @Test
    public void testEnsureEndsWithCommaSpaceStringBuffer(){
        StringBuffer endsWithCommaSpace = new StringBuffer("Hello World, ");
        StringBuffer endsWithSpace = new StringBuffer("Hello World ");
        StringBuffer noEndingChars = new StringBuffer("Hello World");

        assertEquals(endsWithCommaSpace.toString(),
                StringUtil.ensureEndsWithCommaSpace(endsWithCommaSpace).toString());
        assertEquals(endsWithCommaSpace.toString(),
                StringUtil.ensureEndsWithCommaSpace(endsWithSpace).toString());
        assertEquals(endsWithCommaSpace.toString(),
                StringUtil.ensureEndsWithCommaSpace(noEndingChars).toString());
    }

}
