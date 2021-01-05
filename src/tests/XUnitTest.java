package tests;

import org.junit.jupiter.api.Test;
import xUnit.TestResult;
import xUnit.TestSuite;
import xUnit.WasRun;
import java.lang.reflect.InvocationTargetException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class XUnitTest {
    TestResult result = new TestResult();

    @Test
    public void testTemplateMethod() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        WasRun test = new WasRun("testMethod");
//        TestResult result = new TestResult();
        test.run(result);
        assertEquals("setUp testMethod tearDown ", test.log);
    }

    @Test
    public void testResult() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        WasRun test = new WasRun("testMethod");
//        TestResult result = new TestResult();
        test.run(result);
        assertEquals("1 run, 0 failed", result.summary());
    }

    @Test
    public void testFailedResult() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        WasRun test = new WasRun("testBrokenMethod");
//        TestResult result = new TestResult();
        test.run(result);
        assertEquals("1 run, 1 failed", result.summary());
    }

    @Test
    public void testFailedResultFormatting() {
//        TestResult result = new TestResult();
        result.testStarted();
        result.testFailed();
        assertEquals("1 run, 1 failed", result.summary());
    }

    @Test
    public void testSuite() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
//        TestResult result = new TestResult();
        suite.run(result);
        assertEquals("2 run, 1 failed", result.summary());
    }
}
