package Final_Basic_Assessment_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class testcase_03 {

	@Test
	public void Drag_Drop_Multiple() throws InterruptedException
	{
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");
		Thread.sleep(2000);
		WebElement mouse = d.findElement(By.id("dropZone1"));
		WebElement laptop = d.findElement(By.id("dropZone2"));
		WebElement laptopcharger = d.findElement(By.id("dragElement1"));
		WebElement mobilecover = d.findElement(By.id("dragElement2"));
		WebElement laptopcover = d.findElement(By.id("dragElement3"));
		WebElement mobilecharger = d.findElement(By.id("dragElement4"));
		Actions act = new Actions(d);
		
		laptopcharger.click();
		laptopcover.click();
		act.dragAndDrop(laptopcharger, laptop).perform();
		
		Thread.sleep(3000);
		
		mobilecover.click();
		mobilecharger.click();
		act.dragAndDrop(mobilecover, mouse).perform();
	
		Thread.sleep(3000);
		d.quit();
	}
}
