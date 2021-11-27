package baseclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{

	public static String getTestData(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file =new FileInputStream("C:\\Users\\sanjay\\eclipse-workspace\\Apr21B_Selenium\\TestData\\Apr21B.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		
		return value;
	}
	
	
	public static void captureScreenshot(WebDriver driver,int TCID) throws IOException  
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest =new File("C:\\Users\\sanjay\\eclipse-workspace\\Apr21B_Selenium\\Screenshot\\TestCaseID"+TCID+".jpg");		
		FileHandler.copy(src, dest);
	}
	
	public static String readPropertyFileData(String key) throws IOException 
	{
		Properties obj=new Properties();
		FileInputStream file= new FileInputStream("C:\\Users\\balaji\\eclipse-workspace6\\augBatchVelocity\\src\\main\\resources\\Credetials\\login.properties");
		obj.load(file);
	
		String value = obj.getProperty(key);
		System.out.println("-----reading property file---------");
		return value;
	}

}