package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.Utillity.TestUtil;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public TestBase()
	{
		try {
		 prop=new Properties();
		 FileInputStream fp=new FileInputStream("C:\\Users\\shrey\\Documents\\java_eclipse\\HybridFrameWork\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fp);
		}
		catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void Intitalization()
	{
		String BrowserName=prop.getProperty("Browser");
		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BrowserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "c:\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Implicitly_Wait_Timeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
	}
	
	
	

}
