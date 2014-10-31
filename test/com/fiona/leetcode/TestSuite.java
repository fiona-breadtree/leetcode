
package com.fiona.leetcode;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	PlusOneSolutionTest.class
})
//
public class TestSuite {
    private static Logger log = Logger.getLogger(TestSuite.class);
    private static String lastClassname = "";
    private static String lastMethodname = "";
    private static int methodCount = 1;

    /**
     * 
     * Prints the name of the current executing testcase to the log.<br/>
     * <em>Usage:</em><br/>
     * 
     * <p>
     * <blockquote>
     * 
     * <pre>
     * public class MyClassTest {
     *     &#064;Rule
     *     public TestName currentTestCaseName = new TestName();
     * 
     *     &#064;Before
     *     public void beforeTest() {
     *         TestSuite.printTestCaseStart(currentTestCaseName);
     *         // do other things...
     *     }
     * }
     * </pre>
     * 
     * </blockquote>
     * <p>
     * 
     * @param testCaseName {@link org.junit.rules.TestName}, see usage.
     */
    public static void printTestCaseStart(TestCaseName testCaseName) {
        updateLast(testCaseName);

        log.info("\n================== Running test: " + testCaseName.getCompleteTestName() + " (run: " + methodCount
            + "/" + testCaseName.getRepeatCount() + ")===========");
    }

    private static void updateLast(TestCaseName name) {
        if (!lastClassname.equals(name.getClassName())) {
            lastClassname = name.getClassName();
            printClassName();
        }
        if (!lastMethodname.equals(name.getMethodName())) {
            lastMethodname = name.getMethodName();
            methodCount = 1;
        } else {
            methodCount++;
        }
    }

    private static void printClassName() {
        final String msg = "                   Running class: " + lastClassname + "                   ";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            sb.append("=");
        }
        final String line = sb.toString();

        log.info("\n" + line + "\n" + msg + "\n" + line);
    }

    /**
     * For usage see: {@link TestSuite#printTestCaseStart(TestCaseName)}
     * @param name
     */
    public static void printTestCaseEnd(TestCaseName name) {
        log.info("\n================== End of test: " + name.getCompleteTestName() + "==================");
    }
}