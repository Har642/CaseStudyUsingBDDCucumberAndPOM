package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewArticleHomePage {
	@FindBy(css = "nav>div ul:nth-child(3) li:nth-child(2)")
	WebElement newArticleBtn;
	
	@FindBy(xpath="//h6[contains(text(),'Popular')]")
	WebElement popularTags;
	
	@FindBy(xpath="//div[contains(text(),'Hari')]")
	WebElement UsernameText;
	
	public NewArticleHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void goToNewArticle() {
		newArticleBtn.click();
	}
	
	public boolean isPopularTagsVisible() {
		System.out.println("The display Text..."+popularTags.getText());
		return popularTags.isDisplayed();
	}
	
	public boolean isUsernameIsVisible() {
		System.out.println("The display Text..."+UsernameText.getText());
		return UsernameText.isDisplayed();
	}
}
