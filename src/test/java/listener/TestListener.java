package listener;


import org.testng.*;
import util.ExtentReportManager;
import util.ScreenshotUtil;


public class TestListener implements ITestListener  {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.startTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Option 1: File path screenshot
        String path = ScreenshotUtil.captureScreenshotAsFile(result.getName());


        if (path != null) {
            ExtentReportManager.getTest()
                    .fail(result.getThrowable())
                    .addScreenCaptureFromPath(path); // using file path
        }

    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.initReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReport();
    }

    @Override public void onTestSkipped(ITestResult result) {}
}
