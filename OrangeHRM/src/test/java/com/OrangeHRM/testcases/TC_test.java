package com.OrangeHRM.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.Pageobject.Dashboard;
import com.OrangeHRM.Pageobject.LoginPage;



public class TC_test extends BaseClass {

	
	@Test
	public void Login() throws IOException
	{
		LoginPage lg = new LoginPage(driver);
		logger.info("Start Login....");
		lg.EnterUsername();
		lg.EnterPassword();
		lg.ClickOnLogin();
		
		logger.info("Login successful....");
		
		Dashboard db = new Dashboard(driver);
		
		String text = db.getText();
		//Assert.assertEquals(text, "Dashboard");
		
		if(text.equals("Dashbord"))
		{
			logger.info("Login - passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Login - failed");
			captureScreenShot(driver,"Login");
			Assert.assertTrue(false);
		}
		
		
	}
}
