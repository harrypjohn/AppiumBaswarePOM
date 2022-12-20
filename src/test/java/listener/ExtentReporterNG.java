package listener;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.TestUtil;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;
	 
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        extent = new ExtentReports(outputDirectory + File.separator + "ExtentReport.html", true);
 
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
 
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
 
                try {
					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                try {
					buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                try {
					buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
 
        extent.flush();
        extent.close();
    }
 
    private void buildTestNodes(IResultMap tests, LogStatus status) throws IOException {
        ExtentTest test;
 
        if (tests.size() > 0) {
        	for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName());
 
                test.setStartedTime(getTime(result.getStartMillis()));
                test.setEndedTime(getTime(result.getEndMillis()));
 
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
 
                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                }
                else {
                    test.log(status, result.getName()+" Test Case is " + status.toString().toLowerCase() + "ed");
                }
 
                if(status.equals(LogStatus.FAIL))
                {
                	//  String screenshotPath =  TestUtil.takeScreenShot(result.getName());;
                     // System.out.println(screenshotPath);
                    // test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenshotPath));
                }
                if(status.equals(LogStatus.PASS))
                {
              //  String screenshotPath =  TestUtil.takeScreenShot(result.getName());
                  //   System.out.println(screenshotPath);
                  //  test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenshotPath));

                }
               
                extent.endTest(test);
            }
        }
    }
 
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();        
    }
}
