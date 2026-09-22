package Final_Basic_Assessment_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testcase_01 {

	
	@Test
	public void demoQS() throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://demoapps.qspiders.com/ui/toggle?sublist=0");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)d;
		WebElement button1 = d.findElement(By.id("tog"));
		js.executeScript("arguments[0].removeAttribute('disabled');",button1);
		js.executeScript("arguments[0].click()",button1);
		Thread.sleep(2000);
		WebElement button2 = d.findElement(By.id("togg"));
		js.executeScript("arguments[0].removeAttribute('diabled');",button2);
		js.executeScript("arguments[0].click()",button2);
		Thread.sleep(2000);
		WebElement button3 = d.findElement(By.id("toggl"));
		js.executeScript("arguments[0].removeAttribute('disabled');",button3);
		js.executeScript("arguments[0].click()",button3);
		Thread.sleep(2000);
		WebElement button4 = d.findElement(By.id("toggler"));
		js.executeScript("arguments[0].removeAttribute('disabled');",button4);
		js.executeScript("arguments[0].click()",button4);
		
		d.findElement(By.xpath("//button[text()='Place Order']")).click();
		String text = d.findElement(By.xpath("//p[@class='text-center pt-3 text-lg']")).getText();
		System.out.println(text);
		if(d.getCurrentUrl().equals("https://demoapps.qspiders.com/ui/image?sublist=0"))
			System.out.println("Order is placed and verified");
		d.quit();
	}
}
