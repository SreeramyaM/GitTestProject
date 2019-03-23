package org.fwcms.initiators;

import org.fwcms.pages.tc.LoginPage;
import org.fwcms.util.BestinetOperatorUserCredentialsProp;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TCOperatorLoginInitiator extends TCConfiguration{
	
	protected ThreadLocal<WebDriver> threadDriver = new InheritableThreadLocal<WebDriver>();
	
	@BeforeMethod
	public void beforeTestMethod(ITestContext ctx) throws Exception{
		threadDriver.set(driverConfig.getDriverBySetTimeOuts(ctx));
		openUrl(getDriver(), tcUrl);
		new LoginPage(getDriver()).initElements().loginToTC(BestinetOperatorUserCredentialsProp.getBestInetOperatorUserName(), BestinetOperatorUserCredentialsProp.getBestInetOperatorPassword());
	}
	
	public WebDriver getDriver() {
        return threadDriver.get();
    }
	
	@AfterMethod(alwaysRun=true)
	public void afterTestMethod(ITestResult result){
		handleAfterMethod(getDriver(), result);
	}
	
}


