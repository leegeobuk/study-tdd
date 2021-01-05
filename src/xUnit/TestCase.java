package xUnit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCase {
    protected String name;

    public TestCase(String name) {
        this.name = name;
    }

    public void setUp() {

    }

    public TestResult run(TestResult result) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        result.testStarted();
        setUp();
        try {
            Method method = Class.forName(this.getClass().toString().substring(6)).getMethod(this.name);
            method.invoke(this);
        }
        catch (Exception e){
            result.testFailed();
        }
        tearDown();
        return result;
    }

    public void tearDown() {

    }
}
