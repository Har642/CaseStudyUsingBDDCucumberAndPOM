package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterEditTitleChk {
	@FindBy(xpath="//h1[contains(text(),'Critical')]")
	WebElement titleChk;
	
	@FindBy(xpath="(//button[contains(text(),'Delete')])[1]")
	WebElement dltBtn;
	
	public AfterEditTitleChk(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String titleCheck() {
		System.out.println("The display Text.."+titleChk.getText());
		return titleChk.getText();
	}
	
	public void clickOnDeleteBtn() {
		dltBtn.click();
	}
	

}
