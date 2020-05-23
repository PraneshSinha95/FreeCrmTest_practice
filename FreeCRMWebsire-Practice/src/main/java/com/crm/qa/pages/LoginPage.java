package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase

{

	@FindBy(name="email")
	WebElement emailId;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement Login_Button;
	
	@FindBy(xpath="//a[contains(text(),'Sign')]")
	WebElement SignUpLink;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement ForgetPassLink;
	
	//initializing page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String ValidatePageLogin()
	{
		return driver.getTitle();
	}
	
	public boolean ForgetPassLink()
	{
		return ForgetPassLink.isEnabled();
	}
	public HomePage LogIn(String un,String Pass)
	{
		emailId.sendKeys(un);
		Password.sendKeys(Pass);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Login_Button);
		
		
		return new HomePage();
		
	}
	
	
	
	
	
	
}
