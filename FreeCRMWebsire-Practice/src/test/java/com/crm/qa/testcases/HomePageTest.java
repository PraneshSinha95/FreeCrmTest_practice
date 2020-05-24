package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ContactsPage;
public class HomePageTest extends TestBase {
	LoginPage LoginPage;
	HomePage HomePage;
	ContactsPage ContactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		Intitalization();
		LoginPage = new LoginPage();
		HomePage = LoginPage.LogIn(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Test(priority=1)
	public void VerifyHompageTitleTest()
	{
		String HomePageTitle= HomePage.HomepageTitle();
		Assert.assertEquals(HomePageTitle, "Cogmento CRM","Home Page Not Matched");
	}
	
	@Test(priority=2)
	public void VerifyUserNameTest() throws InterruptedException
	{
		Thread.sleep(3000);
		String UserName=HomePage.VerifyUserName();
		Assert.assertEquals(UserName, "Pranesh Sinha");
	}
	@Test (priority=3)
	public void VerifyContactPageClick()
	{
		ContactsPage=HomePage.ContactClick();
		
		String ContactsPageTitle=ContactsPage.ContactsPageTitle();
		Assert.assertEquals(ContactsPageTitle, "Contacts","No title Page is wrong");
		
	}
	
	
	


	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
