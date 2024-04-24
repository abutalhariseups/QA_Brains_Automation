package qa.testcases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import qa.base.Base;

public class PageTextSizeAutomation extends Base {

	public PageTextSizeAutomation() {
		super();
	}

	public WebDriver driver;

	@BeforeClass
	public void setup() throws InterruptedException {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}

	@AfterClass
	public void tearDown() {

		driver.quit();

	}

	@Test(priority = 1)
	public void verifyWebpageTextSizeAndFontName() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

	        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[not(self::script) and not(self::style)]//*[text()]")));

	        List<WebElement> allElements = driver.findElements(By.xpath("//*[not(self::script) and not(self::style)]//*[text()]"));

	        File directory = new File("C:\\Users\\Riseup Labs\\eclipse-workspace\\QA_Brains\\src\\test\\java\\FontTestOutput\\");
	        if (!directory.exists()) {
	            directory.mkdirs();
	        }

	        FileWriter writer = new FileWriter(directory.getAbsolutePath() + "\\FontNameText.txt");

	        Set<String> seenTexts = new HashSet<>();

	        for (WebElement element : allElements) {
	            try {
	                String text = element.getText().trim();
	                String fontSize = element.getCssValue("font-size");
	                String fontName = element.getCssValue("font-family");

	                if (!text.isEmpty() && !seenTexts.contains(text)) {
	                    String line = "Text: " + text + ", Font Size: " + fontSize + ", Font Name: " + fontName + "\n";
	                    System.out.println(line);
	                    writer.write(line);
	                    seenTexts.add(text);
	                }
	            } catch (StaleElementReferenceException e) {
	                System.out.println("Element is stale: " + e.getMessage());
	            }
	        }

	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

//	@Test(priority = 2)
//	public void printAllTextWithFontName() {
//	    try {
//	        List<WebElement> allElements = driver.findElements(By.xpath("//*"));
//
//	        File directory = new File("C:\\Users\\Riseup Labs\\eclipse-workspace\\QA_Brains\\src\\test\\java\\FontTestOutput\\");
//	        if (!directory.exists()) {
//	            directory.mkdirs(); 
//	        }
//
//	        FileWriter writer = new FileWriter(directory.getAbsolutePath() + "\\FontNameText.txt");
//
//	        Set<String> seenTexts = new HashSet<>();
//
//	        for (WebElement element : allElements) {
//	            try {
//	                @SuppressWarnings("unused")
//					String tagName = element.getTagName();          
//	                String text = element.getText().trim();
//	                String fontName = element.getCssValue("font-family");
//
//	                if (!text.isEmpty() && !seenTexts.contains(text)) {
//	                    String line = text + "-" + fontName + "\n";
//	                    System.out.println(line); 
//	                    writer.write(line); 
//	                    seenTexts.add(text); 
//	                }
//	            } catch (StaleElementReferenceException e) {
//	                System.out.println("Element is stale: " + e.getMessage());
//	            }
//	        }
//
//	        writer.close();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}




	@Test(priority = 3)
	public void verifyPageColor() {
		List<WebElement> allElements = driver.findElements(By.cssSelector("*"));

		Set<String> colorNames = new HashSet<>();

		for (WebElement element : allElements) {
			try {
				String backgroundColor = element.getCssValue("background-color");

				colorNames.add(getColorName(backgroundColor));
			} catch (StaleElementReferenceException e) {
				allElements = driver.findElements(By.cssSelector("*"));
			}
		}

		for (String colorName : colorNames) {
			System.out.println(colorName);
		}
	}

	private String getColorName(String colorCode) {
		if (colorCode.startsWith("rgba")) {
			String[] rgbaValues = colorCode.substring(colorCode.indexOf("(") + 1, colorCode.lastIndexOf(")"))
					.split(",");
			int red = Integer.parseInt(rgbaValues[0].trim());
			int green = Integer.parseInt(rgbaValues[1].trim());
			int blue = Integer.parseInt(rgbaValues[2].trim());

			if (isRed(red, green, blue)) {
				return "Red";
			} else if (isGreen(red, green, blue)) {
				return "Green";
			} else if (isBlue(red, green, blue)) {
				return "Blue";
			} else if (isWhite(red, green, blue)) {
				return "White";
			} else if (isBlack(red, green, blue)) {
				return "Black";
			} else if (isYellow(red, green, blue)) {
				return "Yellow";
			} else if (isCyan(red, green, blue)) {
				return "Cyan";
			} else if (isMagenta(red, green, blue)) {
				return "Magenta";
			} else if (isOrange(red, green, blue)) {
				return "Orange";
			} else if (isPink(red, green, blue)) {
				return "Pink";
			} else if (isBrown(red, green, blue)) {
				return "Brown";
			} else if (isPurple(red, green, blue)) {
				return "Purple";
			} else if (isTurquoise(red, green, blue)) {
				return "Turquoise";
			} else if (isLime(red, green, blue)) {
				return "Lime";
			} else if (isMaroon(red, green, blue)) {
				return "Maroon";
			} else if (isTeal(red, green, blue)) {
				return "Teal";
			} else if (isOlive(red, green, blue)) {
				return "Olive";
			} else if (isIndigo(red, green, blue)) {
				return "Indigo";
			} else if (isViolet(red, green, blue)) {
				return "Violet";
			} else if (isGold(red, green, blue)) {
				return "Gold";
			} else if (isSilver(red, green, blue)) {
				return "Silver";
			} else if (isSkyBlue(red, green, blue)) {
				return "Sky Blue";
			} else if (isPeach(red, green, blue)) {
				return "Peach";
			} else if (isLavender(red, green, blue)) {
				return "Lavender";
			} else if (isSalmon(red, green, blue)) {
				return "Salmon";
			} else if (isCoral(red, green, blue)) {
				return "Coral";
			} else if (isAquamarine(red, green, blue)) {
				return "Aquamarine";
			} else if (isBeige(red, green, blue)) {
				return "Beige";
			} else if (isCrimson(red, green, blue)) {
				return "Crimson";
			} else if (isNavy(red, green, blue)) {
				return "Navy";
			} else if (isCerulean(red, green, blue)) {
				return "Cerulean";
			} else if (isMauve(red, green, blue)) {
				return "Mauve";
			} else if (isAzure(red, green, blue)) {
				return "Azure";
			} else if (isChartreuse(red, green, blue)) {
				return "Chartreuse";
			} else if (isCopper(red, green, blue)) {
				return "Copper";
			} else if (isCrimson(red, green, blue)) {
				return "Crimson";
			} else if (isKhaki(red, green, blue)) {
				return "Khaki";
			} else if (isCyan(red, green, blue)) {
				return "Cyan";
			} else if (isOliveDrab(red, green, blue)) {
				return "Olive Drab";
			} else {
				return "Unknown";
			}
		} else {
			return "Unknown";
		}
	}

	// Method to check if the color is within the red range
	private boolean isRed(int red, int green, int blue) {
		return red >= 200 && green <= 50 && blue <= 50;
	}

	// Method to check if the color is within the green range
	private boolean isGreen(int red, int green, int blue) {
		return red <= 50 && green >= 150 && blue <= 50;
	}

	// Method to check if the color is within the blue range
	private boolean isBlue(int red, int green, int blue) {
		return red <= 50 && green <= 50 && blue >= 150;
	}

	// Method to check if the color is within the white range
	private boolean isWhite(int red, int green, int blue) {
		return red >= 200 && green >= 200 && blue >= 200;
	}

	// Method to check if the color is within the black range
	private boolean isBlack(int red, int green, int blue) {
		return red <= 50 && green <= 50 && blue <= 50;
	}

	// Method to check if the color is within the yellow range
	private boolean isYellow(int red, int green, int blue) {
		return red >= 150 && green >= 150 && blue <= 50;
	}

	// Method to check if the color is within the cyan range
	private boolean isCyan(int red, int green, int blue) {
		return red <= 50 && green >= 150 && blue >= 150;
	}

	// Method to check if the color is within the magenta range
	private boolean isMagenta(int red, int green, int blue) {
		return red >= 150 && green <= 50 && blue >= 150;
	}

	// Method to check if the color is within the orange range
	private boolean isOrange(int red, int green, int blue) {
		return red >= 200 && green >= 100 && blue <= 50;
	}

	// Method to check if the color is within the pink range
	private boolean isPink(int red, int green, int blue) {
		return red >= 200 && green <= 100 && blue >= 150;
	}

	// Method to check if the color is within the brown range
	private boolean isBrown(int red, int green, int blue) {
		return red >= 100 && red <= 150 && green >= 50 && green <= 100 && blue <= 50;
	}

	// Method to check if the color is within the purple range
	private boolean isPurple(int red, int green, int blue) {
		return red >= 100 && red <= 150 && green <= 50 && blue >= 100;
	}

	// Method to check if the color is within the turquoise range
	private boolean isTurquoise(int red, int green, int blue) {
		return red <= 50 && green >= 200 && blue >= 200;
	}

	// Method to check if the color is within the lime range
	private boolean isLime(int red, int green, int blue) {
		return red <= 50 && green >= 200 && blue <= 50;
	}

	// Method to check if the color is within the maroon range
	private boolean isMaroon(int red, int green, int blue) {
		return red >= 100 && green <= 50 && blue <= 50;
	}

	// Method to check if the color is within the teal range
	private boolean isTeal(int red, int green, int blue) {
		return red <= 50 && green <= 100 && blue <= 100;
	}

	// Method to check if the color is within the olive range
	private boolean isOlive(int red, int green, int blue) {
		return red >= 100 && green >= 100 && blue <= 50;
	}

	private boolean isIndigo(int red, int green, int blue) {
		return red <= 75 && green <= 0 && blue >= 130 && blue <= 150;
	}

	private boolean isViolet(int red, int green, int blue) {
		return red >= 150 && green <= 0 && blue >= 150;
	}

	private boolean isGold(int red, int green, int blue) {
		return red >= 200 && green >= 165 && green <= 170 && blue <= 40;
	}

	private boolean isSilver(int red, int green, int blue) {
		return red >= 192 && green >= 192 && blue >= 192 && red <= 215 && green <= 215 && blue <= 215;
	}

	private boolean isSkyBlue(int red, int green, int blue) {
		return red <= 135 && green >= 206 && blue >= 235;
	}

	private boolean isPeach(int red, int green, int blue) {
		return red >= 255 && green >= 218 && green <= 229 && blue >= 185 && blue <= 218;
	}

	private boolean isLavender(int red, int green, int blue) {
		return red >= 230 && green >= 230 && blue >= 250 && red <= 255 && green <= 255 && blue <= 255;
	}

	private boolean isSalmon(int red, int green, int blue) {
		return red >= 250 && green >= 128 && blue >= 114;
	}

	private boolean isCoral(int red, int green, int blue) {
		return red >= 255 && green >= 127 && blue <= 80;
	}

	private boolean isAquamarine(int red, int green, int blue) {
		return red >= 127 && green >= 255 && blue >= 212;
	}

	private boolean isBeige(int red, int green, int blue) {
		return red >= 245 && green >= 245 && blue <= 220;
	}

	private boolean isCrimson(int red, int green, int blue) {
		return red >= 220 && green <= 20 && blue <= 60;
	}

	private boolean isNavy(int red, int green, int blue) {
		return red == 0 && green == 0 && blue == 128;
	}

	private boolean isCerulean(int red, int green, int blue) {
		return red == 0 && green == 123 && blue == 167;
	}

	private boolean isMauve(int red, int green, int blue) {
		return red == 224 && green == 176 && blue == 255;
	}

	private boolean isAzure(int red, int green, int blue) {
		return red == 240 && green == 255 && blue == 255;
	}

	private boolean isChartreuse(int red, int green, int blue) {
		return red == 127 && green == 255 && blue == 0;
	}

	private boolean isCopper(int red, int green, int blue) {
		return red == 184 && green == 115 && blue == 51;
	}

	private boolean isKhaki(int red, int green, int blue) {
		return red == 240 && green == 230 && blue == 140;
	}

	private boolean isOliveDrab(int red, int green, int blue) {
		return red == 107 && green == 142 && blue == 35;
	}
}