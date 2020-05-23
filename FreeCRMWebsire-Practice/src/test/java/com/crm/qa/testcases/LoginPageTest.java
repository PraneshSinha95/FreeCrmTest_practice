package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.HomePage;

public class LoginPageTest extends TestBase
{
	LoginPage LoginPage;
	HomePage HomePage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		Intitalization();
		LoginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String Title= LoginPage.ValidatePageLogin();
		Assert.assertEquals(Title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void FogerPassLinkTest()
	{
		Boolean LinkTest= LoginPage.ForgetPassLink();
	Assert.assertTrue(LinkTest);
	}
	@Test(priority=3)
	public void Logintest()
	{
		HomePage= LoginPage.LogIn(prop.getProperty("username"),prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
