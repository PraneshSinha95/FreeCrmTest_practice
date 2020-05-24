package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	@FindBy (xpath="//span[text()='Pranesh Sinha']")
	WebElement Login_Home_Page_User_Name;
	
	@FindBy (xpath="//span[text()='Contacts']")
	WebElement Contacts_links;
	
	@FindBy(xpath="//span[text()='Deals']")
	WebElement Deals_Link;
	
	@FindBy(xpath="//span[text()='Tasks']")
	WebElement Task_Link;
	
	
	
	//initializing HomePage
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String HomepageTitle()
	{
		return driver.getTitle();
	}
	public String VerifyUserName()
	{
		return Login_Home_Page_User_Name.getText();
	}
	
	public ContactsPage ContactClick()
	{
		Contacts_links.click();
		
		return new ContactsPage();
	}
	
	public DealsPage DealsClick()
	{
		Deals_Link.click();
		return new DealsPage();
	}
	
	public TasksPage TaskPageClick()
	{
		Task_Link.click();
		return new TasksPage();
	}
}
