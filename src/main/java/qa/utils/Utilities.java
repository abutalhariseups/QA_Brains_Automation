package qa.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=55;
	
	public static String generateEmailWithTimeStamp() {
		
		Date date = new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		return "amotoori"+timestamp+"@gmail.com";
		
	}
	
	public static boolean isFontSizeAcceptable(String fontSize) {
        // Convert font size to a numeric value (remove "px" if present)
        fontSize = fontSize.replaceAll("[^\\d.]", "");
        double size = Double.parseDouble(fontSize);

        // Define your criteria for acceptable font sizes
        double minFontSize = 0.0; // Example: Minimum acceptable font size
        double maxFontSize = 150.0; // Example: Maximum acc0ptable font size

        // Check if the font size falls within the acceptable range
        return size >= minFontSize && size <= maxFontSize;
    }
	
	public static String captureScreenshot(WebDriver driver,String testName) {
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		
		try {
			FileHandler.copy(srcScreenshot,new File(destinationScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinationScreenshotPath;
	}
	
}
