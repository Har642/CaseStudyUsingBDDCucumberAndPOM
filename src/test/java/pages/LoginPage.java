package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//input[@name='email']")
	WebElement username;

	@FindBy(xpath="//input[@name='password']")
	WebElement pwd;
	
	@FindBy(css="button.btn.btn-lg.btn-primary.pull-xs-right")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void ValidLogin(String strUser, String strPwd) {
		username.sendKeys(strUser);
		pwd.sendKeys(strPwd);
		loginBtn.click();
	}

}
