package xUnit;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class TestSuite {
    ArrayList<TestCase> tests;

    public TestSuite() {
        this.tests = new ArrayList<>();
    }

    public void add(TestCase testCase) {
        tests.add(testCase);
    }

    public TestResult run(TestResult result) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (TestCase test : tests) {
            test.run(result);
        }
        return result;
    }
}
