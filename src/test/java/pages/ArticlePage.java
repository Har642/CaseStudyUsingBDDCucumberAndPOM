package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage {
	@FindBy(xpath="(//button//a[contains(text(),'Edit')])[1]")
	WebElement editBtn;
	
	@FindBy(xpath="//h1[contains(text(),'Critical')]")
	WebElement titleChk;
	
	@FindBy(css ="div.container>div>div>div>ul li a.nav-link.active")
	WebElement myArticleList;
	
	@FindBy(xpath ="(//div//a[contains(text(),'Hari')])[1]")
	WebElement profile;
	
//	@FindBy(css="i.ion-person")
//	WebElement profileIcon;
//	
	@FindBy(xpath="//h1[contains(text(),'Critical')]")
	WebElement selectFirstArticle;
	
	public ArticlePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean titleTxtCheck() {
		System.out.println("The display Txt.."+titleChk.getText());
		return titleChk.isDisplayed();
	}
	
	public String tName() {
		return titleChk.getText();
	}
	
	public void clickOnEditBtn() {
		editBtn.click();
	}
	
	public String isMyArticlesVisible() {
		return myArticleList.getText();
	}
	
	
	public String selectArticle() {
		String textVal = selectFirstArticle.getText();
		return textVal;
	}
	
	public void clickOnTxt() {
		selectFirstArticle.click();;
	}
	
	public WebElement profileClick() {
		return profile;
	}
	
	
//	public void insideCheck() {
//		profileIcon.click();
//	}
}

	