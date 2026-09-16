package pomUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_RecruitmentPage {

	WebDriver driver;

	public OrangeHRM_RecruitmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement addBtn;
	
	@FindBy(name="firstName")
	private WebElement FN;
	
	@FindBy(name="lastName")
	private WebElement LN;
	
	@FindBy(xpath="//div[text()='-- Select --']")
	private WebElement vacancy;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement email;
	
	@FindBy(xpath="(//input[@placeholder='Type here'])[2]")
	private WebElement contact_num;
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement Resume;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement savebtn;
	
	@FindBy(xpath="//a[text()='Candidates']")
	private WebElement candidates_btn;
	
	public void getAddBtn() {
		addBtn.click();
	}

	public void getFN(String value) {
		FN.sendKeys(value);;
	}

	public void getLN(String value) {
		LN.sendKeys(value);;
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

	public void getEmail(String value) {
		email.sendKeys(value);;
	}

	public void getContact_num(String value) {
		contact_num.sendKeys(value);;
	}

	public void getResume(String value) {
		Resume.sendKeys(value);
	}
	
	public void getSavebtn() {
		savebtn.click();
	}
	
	public void getCandidates_btn() {
		candidates_btn.click();
	}
}
