package com.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ChessGameTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ChessGameTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ChessGameTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testChessGame() {
        assertTrue(true);
    }
}
