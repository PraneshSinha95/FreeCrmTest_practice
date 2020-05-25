package com.crm.qa.Utillity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.formula.WorkbookDependentFormula;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase
{

	public static long Page_Load_Timeout=20;
	public static long Implicitly_Wait_Timeout=30;
	
	
	//Here we have to write all the common methods
	
	public static String TESTDATA_Sheet_Path="C:\\Users\\shrey\\git\\repository\\FreeCRMWebsire-Practice\\src\\main\\java\\com\\crm\\qa\\testdata\\Free_Crm_Test_Data.xlsx";
	
	public static Workbook book;
	public static Sheet sheet;
	public static Object[][] getTestData(String SheetName)
	{
		FileInputStream file=null;
		try {
		file=new FileInputStream(TESTDATA_Sheet_Path);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		sheet=book.getSheet(SheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			for(int k=0;k<=sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
						}
		}
		return data;
		
		
		
	}
	
}
