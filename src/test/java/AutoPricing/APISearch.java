package AutoPricing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/*
To check with API result come or not and close button in API search page   
*/

public class APISearch extends Login {

	@Test(alwaysRun = true)
	public void Search() throws Exception {

		Select storeName = new Select(driver.findElement(By.xpath("//*[@id=\"store\"]")));

		storeName.selectByValue("1");
		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class=\"edit-icons\"])[2]")));

		// Thread.sleep(60000);

		WebElement EditActionButton = driver.findElement(By.xpath("(//*[@class=\"edit-icons\"])[2]"));
		EditActionButton.click();
		System.out.println("i am here 1");

		// Thread.sleep(30000);
		WebDriverWait wait21 = new WebDriverWait(driver, 60);
		wait21.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value=\"Reset\"]")));
		System.out.println("i am here 2");
		// Click the <Reset> button
		driver.findElement(By.xpath("//input[@value=\"Reset\"]")).click();
		System.out.println("i am here 3");

		// Thread.sleep(30000);
		// WebDriverWait wait3 = new WebDriverWait(driver,60);
		// wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"crwlbtn\"]")));
		// driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		System.out.println("i am here 4");

		// Click the API search button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		System.out.println("i am here 5");
		Thread.sleep(30000);
		// driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		// Thread.sleep(60000);
		/*
		 * WebDriverWait wait33 = new WebDriverWait(driver,120);
		 * wait33.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//button[@id=\"crwlbtn\"]")));
		 */
		System.out.println("i am here 6");
		// js.executeScript("arguments[0].scrollIntoView();", APISearchButton);

		WebElement APISearchButton = driver.findElement(By.xpath("//button[@id=\"crwlbtn\"]"));
		APISearchButton.click();
		System.out.println("i am here 7");

		// Thread.sleep(30000);
		WebDriverWait wait4 = new WebDriverWait(driver, 60);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"ui-id-1\"]")));
		System.out.println("i am here 8");

		// Click the <API Search> tab button
		driver.findElement(By.xpath("//a[@id=\"ui-id-1\"]")).click();
		System.out.println("i am here 9");

		// Thread.sleep(30000);

		// Click the checkboxes of the first two records

		try {
			WebDriverWait wait5 = new WebDriverWait(driver, 60);
			wait5.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name=\"api_checkbox\"])[2]")));
			System.out.println("i am here 10");
			System.out.println("i am here 11");
			driver.findElement(By.xpath("(//input[@name=\"api_checkbox\"])[1]")).click();
			driver.findElement(By.xpath("(//input[@name=\"api_checkbox\"])[2]")).click();
			System.out.println("i am here 12");

			// Thread.sleep(30000);

			WebDriverWait wait6 = new WebDriverWait(driver, 60);
			wait6.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//button[@class=\"button-div button-exclude\"]")));
			System.out.println("i am here 13");
			// js.executeScript("window.scrollBy(0,1500)");
			WebElement ExcludeItemsButton = driver
					.findElement(By.xpath("//button[@class=\"button-div button-exclude\"]"));
			System.out.println("i am here 14");
			js.executeScript("arguments[0].scrollIntoView();", ExcludeItemsButton);
			ExcludeItemsButton.click();
			System.out.println("i am here 15");
		} catch (Exception e1) {
			System.out.println("i am here 16");
			System.out.println("No records found ... no checkbox can be selected");
		}
		// Thread.sleep(5000);
		System.out.println("i am here 17");
		WebDriverWait wait7 = new WebDriverWait(driver, 60);
		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id=\"close2\"]")));
		System.out.println("i am here 18");

		js.executeScript("window.scrollBy(0,-1500)");
		driver.findElement(By.xpath("//span[@id=\"close2\"]")).click();
		System.out.println("i am here 19");

		// Thread.sleep(10000);
		WebDriverWait wait8 = new WebDriverWait(driver, 60);
		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"crwlbtn\"]")));
		System.out.println("i am here 20");

		js.executeScript("arguments[0].scrollIntoView();", APISearchButton);
		APISearchButton.click();
		System.out.println("i am here 21");

		// Thread.sleep(30000);
		WebDriverWait wait9 = new WebDriverWait(driver, 60);
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"ui-id-2\"]")));
		System.out.println("i am here 22");

		try {
			System.out.println("i am here 23");
			WebElement ShowExcludeTab = driver.findElement(By.xpath("//a[@id=\"ui-id-2\"]"));
			ShowExcludeTab.click();
			// Thread.sleep(10000);
			WebDriverWait wait10 = new WebDriverWait(driver, 60);
			wait10.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//input[@name=\"api_checkbox_tab2\"])[2]")));

			System.out.println("i am here 24");
			// Click the checkboxes
			driver.findElement(By.xpath("(//input[@name=\"api_checkbox_tab2\"])[1]")).click();
			driver.findElement(By.xpath("(//input[@name=\"api_checkbox_tab2\"])[2]")).click();
			// Thread.sleep(5000);

			WebDriverWait wait11 = new WebDriverWait(driver, 60);
			wait11.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//button[@class=\"button-div button-search\"])[3]")));
			System.out.println("i am here 25");
			WebElement IncludeItemsButton = driver
					.findElement(By.xpath("(//button[@class=\"button-div button-search\"])[3]"));
			IncludeItemsButton.click();
			System.out.println("i am here 26");
		} catch (Exception e) {
			System.out.println("i am here 27");
			System.out.println("No records found to be included");
		}
		// Thread.sleep(10000);
		System.out.println("i am here 28");
		WebDriverWait wait12 = new WebDriverWait(driver, 60);
		wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id=\"close2\"]")));
		System.out.println("i am here 29");

		// Click the <Close> button
		driver.findElement(By.xpath("//span[@id=\"close2\"]")).click();
		System.out.println("i am here 30");

		// Thread.sleep(10000);
		WebDriverWait wait13 = new WebDriverWait(driver, 60);
		wait13.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"crwlbtn\"]")));
		System.out.println("i am here 31");

		js.executeScript("arguments[0].scrollIntoView();", APISearchButton);
		APISearchButton.click();
		System.out.println("i am here 32");

		// Thread.sleep(10000);
		WebDriverWait wait14 = new WebDriverWait(driver, 60);
		wait14.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"ui-id-1\"]")));
		System.out.println("i am here 33");

		WebElement APISearchTab = driver.findElement(By.xpath("//a[@id=\"ui-id-1\"]"));
		APISearchTab.click();
		System.out.println("i am here 34");

		// Thread.sleep(10000);
		WebDriverWait wait15 = new WebDriverWait(driver, 60);
		wait15.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"ui-id-2\"]")));
		System.out.println("i am here 35");

		System.out.println("I am here .... 14");

		// Click the <Show Exclude> tab button
		driver.findElement(By.xpath("//a[@id=\"ui-id-2\"]")).click();
		System.out.println("i am here 36");

		// Thread.sleep(10000);
		WebDriverWait wait16 = new WebDriverWait(driver, 60);
		wait16.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id=\"close2\"]")));
		System.out.println("i am here 37");
		System.out.println("I am here .... 15");

		// Click the <Close> button
		driver.findElement(By.xpath("//span[@id=\"close2\"]")).click();
		System.out.println("i am here 38");
		// Thread.sleep(10000);
		WebDriverWait wait17 = new WebDriverWait(driver, 60);
		wait17.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class=\"close\"])[2]")));
		System.out.println("i am here 39");
		js.executeScript("window.scrollBy(0,-1500)");
		System.out.println("i am here 40");
		// Click the <Close> button of the <Edit> screen
		driver.findElement(By.xpath("(//span[@class=\"close\"])[2]")).click();
		System.out.println("API search finsished...");
	}

}