package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Utillity.TestUtil;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTestClass extends TestBase
{
	LoginPage LoginPage;
	HomePage Homepage;
	TestUtil TestUtil;
	ContactsPage ContactsPage;
	
	public ContactsPageTestClass()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		Intitalization();
		LoginPage=new LoginPage();
		Homepage=LoginPage.LogIn(prop.getProperty("username"), prop.getProperty("password"));
		ContactsPage=Homepage.ContactClick();
		ContactsPage=new ContactsPage();
	}
	@Test(priority=1)
	public void VerifyContactLabel()
	{
		Assert.assertEquals(ContactsPage.ContactsPageTitle(), "Contacts","Name is not Contacts");
	}
	
	@Test(priority=2)
	public void SelectContactTest()
	{
	ContactsPage.SelectContactByName("alok nath");
	}
	@Test(priority=3)
	public void SelectMultipleContactTest()
	{
		ContactsPage.SelectContactByName("Bipin Kumar");
		ContactsPage.SelectContactByName("alok nath");
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.close();
	}
}
