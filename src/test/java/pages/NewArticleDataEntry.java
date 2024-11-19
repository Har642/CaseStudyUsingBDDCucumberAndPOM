package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewArticleDataEntry {
	@FindBy(css = "input[name='title']")
	WebElement articleTitle;
	
	@FindBy(css = "input[name='description']")
	WebElement articleDesc;

	@FindBy(css = "textarea[name='body']")
	WebElement writeArticle;
	
	@FindBy(css = "input[name='tags']")
	WebElement enterTags;
	
	@FindBy(css = "button.btn")
	WebElement submitBtn;
	
	
	public NewArticleDataEntry(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterDataIntoFields(String titleName, String description, String articleTxt, String tags) {
		articleTitle.sendKeys(titleName);
		articleDesc.sendKeys(description);
		writeArticle.sendKeys(articleTxt);
		enterTags.sendKeys(tags);
	}
	
	public String isOnNewArticlePage() {
		System.out.println("The display Text..."+submitBtn.getText());
		return submitBtn.getText();
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
}
