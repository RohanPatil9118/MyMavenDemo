package com.OrangeHRM.Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements( rdriver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Loginclk;
	
	public void EnterUsername()
	{
		username.sendKeys("Admin");
	}
	public void EnterPassword()
	{
		password.sendKeys("admin123");
	}
	public void ClickOnLogin()
	{
		Loginclk.click();
	}
}
