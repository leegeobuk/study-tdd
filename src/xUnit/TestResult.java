package xUnit;

public class TestResult {
    public int runCount;
    public int failureCount;

    public TestResult() {
        runCount = 0;
        failureCount = 0;
    }

    public void testStarted() {
        runCount++;
    }

    public void testFailed() {
        failureCount++;
    }

    public String summary() {
        return String.format("%d run, %d failed", runCount, failureCount);
    }
}
