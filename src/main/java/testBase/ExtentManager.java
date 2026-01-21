package testBase;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("target/extent-report/ExtentReport.html");

            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Cucumber TestNG Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Framework", "Cucumber + TestNG");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }
        return extent;
    }

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void flush() {
        extent.flush();
    }
}