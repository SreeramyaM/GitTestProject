package org.fwcms.initiators;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class GmailInitiator extends GmailConfiguration{

	protected ThreadLocal<WebDriver> threadDriver = new InheritableThreadLocal<WebDriver>();
	
	@BeforeMethod
	public void beforeTestMethod(ITestContext ctx) throws Exception{
		threadDriver.set(driverConfig.getDriverBySetTimeOuts(ctx));
		openUrl(getDriver(), gmailUrl);
	}
	
	public WebDriver getDriver() {
        return threadDriver.get();
    }
	
	@AfterMethod(alwaysRun=true)
	public void afterTestMethod(ITestResult result){
		handleAfterMethod(getDriver(), result);
	}
	
}
