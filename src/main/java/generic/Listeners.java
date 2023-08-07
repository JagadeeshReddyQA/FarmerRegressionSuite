package generic;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	public void onTestStart(ITestResult result) {
		
		throw new UnsupportedOperationException();

	}

	public void onTestSuccess(ITestResult result) {
	
		throw new UnsupportedOperationException();

	}

	public void onTestFailure(ITestResult result) {
		try {
			BaseTest.getScreenshot1(result.getName());
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
	
		throw new UnsupportedOperationException();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		throw new UnsupportedOperationException();

	}

	public void onStart(ITestContext context) {
	
		throw new UnsupportedOperationException();

	}

	public void onFinish(ITestContext context) {
		
		throw new UnsupportedOperationException();

	}

}
