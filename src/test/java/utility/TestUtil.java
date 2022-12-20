package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class TestUtil extends TestBase {
	public static String folder_name;
	public static String file_name;
	public static DateFormat dateformat;
	public static String dest;
	
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\BaswareApp.xlsx");
	
	public static Object[][] getDataFromTestUtil(String sheetname)
	{
		
		int rows=excel.getRowCount(sheetname);
		int cols=excel.getColumnCount(sheetname);
		Object[][] data=new Object[rows-1][cols];
		for(int rowNum=2; rowNum<=rows; rowNum++)
		{
			for(int colNum=0;colNum<cols;colNum++)
			{
				data[rowNum-2][colNum]=excel.getCellData(sheetname, colNum, rowNum);
			}
		}
		
		
		return data;
		
	}
	
	public static String takeScreenShot() throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        dateformat =  new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        String dest = System.getProperty("user.dir") +"\\Screenshots\\"+dateformat.format(new Date())+".png";
     
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
		
		
	}

	/*
	 * public static String takeScreenShot(String screenshotName) throws IOException
	 * {
	 * 
	 * TakesScreenshot ts = (TakesScreenshot)driver; File source =
	 * ts.getScreenshotAs(OutputType.FILE); dateformat = new
	 * SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa"); String dest =
	 * System.getProperty("user.dir")
	 * +"\\Screenshots\\"+screenshotName+dateformat.format(new Date())+".png";
	 * 
	 * File destination = new File(dest); FileUtils.copyFile(source, destination);
	 * 
	 * return dest;
	 * 
	 * 
	 * }
	 */
	public static String passdest()
	{
		String abc=dest;
		return abc;
	}
	public static String elementScreenshot(WebElement loginButton)
	{

	File screenshotLocation = null;
	try{
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	java.awt.image.BufferedImage  fullImg = ImageIO.read(scrFile);
	//Get the location of element on the page
	org.openqa.selenium.Point point = loginButton.getLocation();
	//Get width and height of the element
	int eleWidth = loginButton.getSize().getWidth();
	int eleHeight = loginButton.getSize().getHeight();
	//Crop the entire page screenshot to get only element screenshot
	java.awt.image.BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth,
	    eleHeight);
	ImageIO.write(eleScreenshot, "png", scrFile);

	DateFormat dateformat;
	dateformat =  new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	String fileName =dateformat.format(new Date())+".png";
	screenshotLocation = new File("./screenshots/" + fileName);

	FileUtils.copyFile(scrFile, screenshotLocation);

	     System.out.println(screenshotLocation.toString());
	 
	 
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return screenshotLocation.toString();


	 }
}
