package Final_Basic_Assessment_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class testcase_02 {

	@Test
	public void demoQS_slidder() throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
		Thread.sleep(2000);
		
		WebElement button = d.findElement(By.id("slide"));
		Actions act = new Actions(d);
		System.out.println(button.getLocation());
		act.clickAndHold(button).moveByOffset(200,0).release().perform();
		
		String text = d.findElement(By.xpath("(//h3[@class='text-sm font-bold pb-1'])[3]")).getText();
		if(text.equals("Mens Cotton Jacket..."))
			System.out.println("Mens Cotton Jacket is verified");
		d.quit();
	}
}
