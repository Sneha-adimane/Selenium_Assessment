package pomUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_Candidatespage {

	WebDriver driver;
	
	public OrangeHRM_Candidatespage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(xpath="(//div[text()='-- Select --'])[1]")
	private WebElement job_title;
	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[2]")
	private WebElement vacancy;
	
	@FindBy(xpath="(//div[text()='-- Select --'])[3]")
	private WebElement HR;
	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[4]")
	private WebElement status;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement C_name;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement search;

	public void getJob_title() throws AWTException {
		job_title.click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void getVacancy() throws AWTException {
		vacancy.click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void getHR() throws AWTException {
		HR.click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void getStatus() throws AWTException {
		status.click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void getC_name(String value) {
		C_name.sendKeys(value);
	}

	public void getSearch() {
		search.click();
	}
	
	
}
