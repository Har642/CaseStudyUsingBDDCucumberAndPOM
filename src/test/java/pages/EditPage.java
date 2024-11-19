package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage {
	@FindBy(css = "input[name='title']")
	WebElement articleTitle;
	
	@FindBy(css = "input[name='description']")
	WebElement articleDesc;

	@FindBy(css = "textarea[name='body']")
	WebElement writeArticle;
	
	@FindBy(css = "input[name='tags']")
	WebElement enterTags;
	
	@FindBy(css = "button.btn")
	WebElement UpdateBtn;
	
	public EditPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void removeTxt1() {
		articleTitle.clear();
	}
	public void removeTxt2() {
		writeArticle.clear();
	
	}
//	public void removeTxt3() {
//		enterTags.clear();
//	}
//	
	
	public void updateData1(String editTitleName) {
		articleTitle.sendKeys(editTitleName);
	}
	public void updateData2(String editArticleTxt) {
		writeArticle.sendKeys(editArticleTxt);

	}
//	public void updateData3(String editTags) {
//
//		enterTags.sendKeys(editTags);
//	}
//	
	public void clickOnUpdateBtn() {
		UpdateBtn.click();
	}
	

}
