package xUnit;

public class WasRun extends TestCase {
    public boolean wasRun;
    public String log;

    public WasRun(String name) {
        super(name);
        wasRun = false;
        log = "setUp ";
    }

    public void setUp() {
        wasRun = false;
    }

    public void testMethod() {
        wasRun = true;
        log += "testMethod ";
    }

    public void testBrokenMethod() throws Exception {
        throw new Exception();
    }

    public void tearDown() {
        log += "tearDown ";
    }
}
