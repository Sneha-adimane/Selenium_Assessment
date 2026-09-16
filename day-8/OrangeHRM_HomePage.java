package pomUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRM_HomePage {

	WebDriver driver;
	
	public OrangeHRM_HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Recruitment']")
	private WebElement RecruitmentLink;

	public void getRecruitmentLink() {
		RecruitmentLink.click();
	}
}
