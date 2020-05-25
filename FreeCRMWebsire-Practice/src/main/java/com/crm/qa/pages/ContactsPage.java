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
	
	@FindBy(xpath="//button[@class='ui linkedin button' and text()='New']")
	WebElement New_button;
	
	@FindBy(xpath="//input[@name='first_name']")
	public static WebElement First_name;
	
	
	@FindBy(name="last_name")
	WebElement Last_name;
	
	@FindBy(name="middle_name")
	WebElement Middle_name;
	
	@FindBy (xpath="//button[@class='ui linkedin button']")
	WebElement Save_Button;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void FirstNameFiled()
	{
		 First_name.isEnabled();
	}
	
	public String ContactsPageTitle()
	{
		return ContactsPageTitle.getText();
		
	}
	public void SelectContactByName(String name)
	{
		 driver.findElement(By.xpath("//td[text()='"+name+"']")).click();
		
	}
	
	public void NewButtonClick()
	{
		New_button.click();	
	}
	
	public void CreateNewContact(String Ft,String LastN, String MidN)
	{
		First_name.sendKeys(Ft);
		Last_name.sendKeys(LastN);
		Middle_name.sendKeys(MidN);
		Save_Button.click();
	}

}
