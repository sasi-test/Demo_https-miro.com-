package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LoginUsingSelenium {

	@Test
	public void login() throws InterruptedException {
		//Setting property file for running chrome browser exectuion
		System.setProperty("webdriver.chrome.driver", "C:\\sasi_mani\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Maximizing the window
		driver.manage().window().maximize();
		//login the application 
		driver.get("https://miro.com/login/");
		//login for main page
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.className("signup__submit"));
		//Global wait 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		username.sendKeys("sasistarts@gmail.com");
		password.sendKeys("Adarsh@0406");
		login.click();
		//Navigate to dashboard
		WebElement container = driver.findElement(By.xpath(
				"//div[@id='router-container-wrapper']/div/div/div[3]/div[2]/div[2]/div[2]/div/ng-transclude/div[2]/div/div[4]/div/div/div/div"));
		
		// WebElement close = driver.findElement(By.xpath("//div[16]/div[4]"));
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		container.click();

		// Mouse action to be performed by selenium webdriver

		WebElement From = driver.findElement(By.xpath("//div[@id='pixiCanvasContainer']/canvas"));
		WebElement To = driver.findElement(By.xpath("//div[@id='pixiCanvasContainer']/canvas"));

		Actions act = new Actions(driver);
		//Perform mouse over action 
		act.dragAndDrop(From, To).build().perform();
		//Explicit wait
		Thread.sleep(2000);
		WebElement menuOption = driver.findElement(By.xpath("//div[@id='pixiCanvasContainer']/canvas"));
		//Explicit wait
		Thread.sleep(2000);
		act.moveToElement(menuOption).perform();
		System.out.println("Done Mouse hover on 'pixiCanvas' from Menu");

		// Mouse hover action 
		WebElement mainMenu = driver.findElement(By.cssSelector(".view-type--selected"));
		act.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath(
				"//div[@id='router-container-wrapper']/div/div/div[3]/div[2]/div[2]/div[2]/div/ng-transclude/div[2]/div/div[4]/div/div/div/div")))
				.click().build().perform();
		driver.findElement(By.xpath("//div[@id='canvasContainer']/div[2]/div[3]/div/div[16]/div[4]")).click();

		driver.findElement(By.xpath("//div[@id='pixiCanvasContainer']/canvas")).click();

		driver.findElement(By.cssSelector(".icon-text-panel-bg:nth-child(2) > use")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("colorPalette_circle:nth-child(3)")).click();
		Thread.sleep(2000);
		WebElement edit_content = driver.findElement(By.cssSelector(".ql-editor"));
		edit_content.click();
		driver.findElement(By.xpath("//div[16]/div[4]")).click();
		driver.findElement(By.xpath("//div[@id='canvasContainer']/div[2]/div[3]/div/div[16]/div[4]")).click();
		driver.findElement(By.xpath("//div[@id='canvasContainer']/div[2]/div[3]/div/div[31]/div")).click();

		// Edit Content
		driver.findElement(By.xpath("//div[@id='widgetsOverlay']/div[2]/div/div/div")).click();
   
		driver.findElement(By.xpath("//div[16]/div[5]")).click();
		String actualUrl = "https://miro.com/app/dashboard/";
		String expectedUrl = driver.getCurrentUrl();

		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}

	}

}
