package com.OrangeHRM.Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	
	WebDriver ldriver;
	public Dashboard(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']")
	WebElement gettext;
	
	public String getText()
	{
		String text = gettext.getText();
		return text;
	}
}
