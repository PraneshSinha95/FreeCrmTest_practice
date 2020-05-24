package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement ContactsPageTitle;
	
	@FindBy(xpath="//td[text()='Bipin Kumar']/preceding::div//input[contains(@name,'id')]")
	WebElement Select_Bipin;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ContactsPageTitle()
	{
		return ContactsPageTitle.getText();
		
	}
	public void SelectContactByName(String name)
	{
		 driver.findElement(By.xpath("//td[text()='"+name+"']")).click();
		
	}
	

}
