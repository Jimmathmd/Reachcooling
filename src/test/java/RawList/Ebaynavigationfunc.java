package RawList;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ebaynavigationfunc
{

			 /*
			 		1. To check with ebay naviagation Link redirected to new tab
			 */

	WebDriver driver;

	// To check the browser functionality
	
	@BeforeTest
	public void start() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://apapmt.com:90/reachcooling_qc/");
		
		try 
		{
			WebElement username = driver.findElement(By.name("loginid"));
			
			username.sendKeys("qc");
			
			WebElement Password = driver.findElement(By.id("password"));
			
			Password.sendKeys("qc");
			
			// driver.findElement(By.xpath("/html/body/section/div/div/div/div/div/div/div[2]/form/div[3]/div/button")).click();
			
			driver.findElement(By.xpath("//div[@class=\"col-md-12\"]//button[@type=\"submit\"]")).click();
			
			System.out.println("Page is successfully Login...");
			
		} 
		
		catch (Exception e1) 
		{
			
			e1.printStackTrace();
			
			System.out.println("Please check the Login page");
		}
		
		driver.manage().window().maximize();
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e1) 
		{
			
			e1.printStackTrace();
		}

	}

	/* To check the ebay site working fine or not in raw list */
	
	@Test
	public void Ebaynavagation() 
	{
		
		driver.findElement(By.xpath("//div[@class=\"col-md-6\"]//div[@class=\"menu-options\"]")).click();
		
		System.out.println("Menu List is displayed...");

		driver.findElement(By.xpath("(//div[@class=\"side-header slide-menu\"]//a[@class=\"dropdown-toggle active\"])[1]")).click();
		
		System.out.println("Manage List is displayed....");

		driver.findElement(By.xpath("//a[@href=\"http://apapmt.com:90/reachcooling_qc/Rawlist/index\"]")).click();
		
		System.out.println("Raw List Search page displayed opened...");
		
		try 
		{
			Thread.sleep(10000);
		} 
		
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}

		// Select the competitor
		WebElement category = driver.findElement(By.xpath("//*[@id=\"competitorname\"]"));
		
		Select category1 = new Select(category);
		
		category1.selectByIndex(1);
		
		try 
		{
			Thread.sleep(5000);
		}
		
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
		
		System.out.println("Competitor selected in drop down list..");

		// Select the competitor
		WebElement Exp1 = driver.findElement(By.xpath("//*[@id=\"compcat\"]"));
		
		Select Exp2 = new Select(Exp1);
		
		Exp2.selectByIndex(1);
		
		System.out.println("Category selected in drop down list...");
		
		try
		{
			Thread.sleep(5000);
		} 
		
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}

		
		// To click show button in the Raw List Search page displayed page
		
		driver.findElement(By.xpath("//*[@id=\"btnsearch\"]")).click();
		
		System.out.println("Show button selected..");
		
		try 
		{
			Thread.sleep(10000);
		} 
		
		catch (InterruptedException e1)
		{
			
			e1.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id=\"title\"][1]")).click();
		//driver.findElement(By.xpath("//*[@id=\"title\"]/div[2]/div/div/div[1]/table/tbody/tr[1]/td[6]")).click();
		
		//To use the parent and child window conversation
		String mainWindow = driver.getWindowHandle();
		
        System.out.println("The parent window handle is .... " + mainWindow);
		
		String actualtitle ="";

		
		Set<String> s1 = driver.getWindowHandles();
		
		Iterator<String> i1 = s1.iterator();
		
		while(i1.hasNext())
		{
			String childWindow = i1.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow))
				
			{
				driver.switchTo().window(childWindow);
				
				
				driver.manage().window().maximize();
				try 
				{
					Thread.sleep(5000);
				} 
				catch (InterruptedException e) 
				{
					
					e.printStackTrace();
				}
				JavascriptExecutor js = (JavascriptExecutor) driver;				
				js.executeScript("window.scrollBy(0,1000)");
				
                String itemTitle = driver.findElement(By.id("itemTitle")).getText();
				
				System.out.println("The title of the item is ..... " + itemTitle);
				
				actualtitle = driver.findElement(By.xpath("//*[@id=\"descItemNumber\"]")).getText();
										
				try 
				{
					Thread.sleep(10000);
				} 
				
				catch (InterruptedException e) 
				{
					
					e.printStackTrace();
				}
				
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		
		System.out.println("Ebay popup successfully closed....");
		
		//String Expecttitle = driver.findElement(By.xpath("//*[@id=\"removeform\"]/div[2]/div/div/div[1]/table/tbody/tr/td[2]")).getText();
		
		
		

		String  Expecttitle = driver.findElement(By.xpath("//*[@id=\"itemid\"]")).getText();
		
        System.out.println("Expect title is "+Expecttitle);
    
		Assert.assertEquals(actualtitle, Expecttitle,"Not match plz once check again...");
		
		System.out.println("item id in ebay site..."+actualtitle);
		
		System.out.println("item id in API search..."+Expecttitle);
		
		System.out.println("Ebay Link successfully verified....");
		
		try 
		{
			Thread.sleep(5000);
		} 
		
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
				
	
	}
	

		// To close the browser finally
	
		@AfterTest
		public void End() 
		
		{
			driver.quit();
		}

}
