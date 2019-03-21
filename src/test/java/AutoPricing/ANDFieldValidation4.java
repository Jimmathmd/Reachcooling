package AutoPricing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
AutoPrice Edit Functionality:
"AND field: Need to check the below options
1. Empty (Without Keywrods)"
Check withAND keywords and show the result withchoosing AND keywords in API result page  
 */

public class ANDFieldValidation4 extends Login {

	@Test(alwaysRun = true)
	public void EmptyCharacters() {

		// Click the Action button
		WebElement EditActionButton = driver.findElement(By.xpath("(//*[@class=\"edit-icons\"])[1]"));
		EditActionButton.click();

		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Click the [Reset] button
		driver.findElement(By.xpath("//input[@value=\"Reset\"]")).click();

		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("andinput")).sendKeys("test");

		driver.findElement(By.id("andinput")).clear();

		driver.findElement(By.id("andinput")).sendKeys(" ");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("crwlbtn")));
		driver.findElement(By.id("crwlbtn")).click();

		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement closeButton = driver.findElement(By.id("close2"));
		if (closeButton.isEnabled()) {
			Assert.assertEquals(true, true);
			closeButton.click();
		} else {
			Assert.assertEquals(false, true);
		}

		// Click the close button

		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//*[@id=\"Pnopopup2\"]//span[@ng-click=\"popupclose()\"]")));
		// driver.findElement(By.xpath("//*[@id=\"Pnopopup2\"]/div/div/div[1]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"Pnopopup2\"]//span[@ng-click=\"popupclose()\"]")).click();

		// Click the <Yes> option button
		driver.findElement(By.xpath("//*[@id=\"savechange1\"]/div/div/div[3]/button[1]")).click();

		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// CLick the <Close> button again
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("//*[@id=\"Pnopopup2\"]//span[@ng-click=\"popupclose()\"]")));
		driver.findElement(By.xpath("//*[@id=\"Pnopopup2\"]//span[@ng-click=\"popupclose()\"]")).click();
		System.out.println("Empty characters completed...");
	}

}