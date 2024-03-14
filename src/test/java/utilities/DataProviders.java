package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviders {
	@DataProvider(name="logindata")
	public String [][]getdata() throws IOException
	{
		String path=".\\testdata\\logindata.xlsx";
		ExcelUtility xlutils=new ExcelUtility(path);
		
		int rows=xlutils.getRowCount("sheet1");
		int cols=xlutils.getCellCount("sheet1", 1);
		
		String LoginData[][]=new String[rows][cols];
		
		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				LoginData[i-1][j]=xlutils.getCellData("sheet1", i, j);
			}
		}
		
		return LoginData;
	}
	
}
