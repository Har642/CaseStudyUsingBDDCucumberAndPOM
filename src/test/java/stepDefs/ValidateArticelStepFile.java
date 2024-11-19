package stepDefs;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AfterEditTitleChk;
import pages.ArticlePage;
import pages.EditPage;
import pages.LoginPage;
import pages.NewArticleDataEntry;
import pages.NewArticleHomePage;

public class ValidateArticelStepFile {
	WebDriver driver = TestBase.getDriver();
	LoginPage loginPage;
	NewArticleHomePage newArticleHomePage;
	NewArticleDataEntry dataEntry;
	ArticlePage articlePage;
	EditPage editPage;
	AfterEditTitleChk finalPageCheck;

	Actions actions = new Actions(driver);

	public ValidateArticelStepFile() {
		loginPage = new LoginPage(driver);
		newArticleHomePage = new NewArticleHomePage(driver);
		dataEntry = new NewArticleDataEntry(driver);
		articlePage = new ArticlePage(driver);
		editPage = new EditPage(driver);
		finalPageCheck = new AfterEditTitleChk(driver);
	}

	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");

	}

	@When("User provide {string} and {string}")
	public void user_provide_and(String strUser, String strPwd) {
		loginPage.ValidLogin(strUser, strPwd);

	}

	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
		Assert.assertTrue(newArticleHomePage.isUsernameIsVisible());

		Assert.assertTrue(newArticleHomePage.isPopularTagsVisible());

		newArticleHomePage.goToNewArticle();
	}

	@Given("User should be on New Article Page")
	public void user_should_be_on_new_article_page() {
		String isOnNewArtPage = dataEntry.isOnNewArticlePage();
		Assert.assertEquals(isOnNewArtPage, "Publish Article");

	}

	@When("User enters Article details")
	public void user_enters_article_details(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		String title = data.get(1).get(0);
		String desc = data.get(1).get(1);
		String content = data.get(1).get(2);
		String tags = data.get(1).get(3);

		dataEntry.enterDataIntoFields(title, desc, content, tags);

		dataEntry.clickSubmitBtn();

	}

	@Then("Article must be created")
	public void article_must_be_created() throws InterruptedException {
		String articleCreated = articlePage.tName();
		Assert.assertEquals(articleCreated, "Critical Thinking Skills.");
		Thread.sleep(2000);
		articlePage.profileClick().click();

	}

	@Given("User must be on My Article page")
	public void user_must_be_on_my_article_page() throws InterruptedException {
		String myArticleTitle = articlePage.isMyArticlesVisible();
		Thread.sleep(2000);

		System.out.println("title..." + myArticleTitle);
		Assert.assertEquals(myArticleTitle, "My Articles");

	}

	@When("User select an Article {string}")
	public void user_select_an_article(String strVal) throws InterruptedException {
		if (strVal.equalsIgnoreCase(articlePage.selectArticle())) {
			articlePage.clickOnTxt();

		}
		Thread.sleep(2000);
	}

	@Then("Article datail page must be displayed")
	public void article_datail_page_must_be_displayed() {
		boolean articleCreated = articlePage.titleTxtCheck();
		Assert.assertTrue(articleCreated);
	}

	@When("User update article detail")
	public void user_update_article_detail() throws InterruptedException {
		articlePage.clickOnEditBtn();
		Thread.sleep(2000);
	}

	@Then("Article detail must be updated")
	public void article_detail_must_be_updated() throws InterruptedException {
		editPage.removeTxt1();
		editPage.updateData1("Critical Thinking Skills in IT.");
		Thread.sleep(3000);

		editPage.removeTxt2();
		editPage.updateData2("Cucumber Implementation");

		editPage.clickOnUpdateBtn();

	}

	
	@When("User delete Article")
	public void user_delete_article() throws InterruptedException {

		Thread.sleep(2000);
		finalPageCheck.clickOnDeleteBtn();

		Alert alert = driver.switchTo().alert();
		System.out.println("Alert Text:..." + alert.getText());
		Thread.sleep(1000);
		alert.accept();
		Thread.sleep(2000);

	}

	@Then("Article must be deleted")
	public void article_must_be_deleted() throws InterruptedException {
		Assert.assertTrue(newArticleHomePage.isUsernameIsVisible());

		Assert.assertTrue(newArticleHomePage.isPopularTagsVisible());
		Thread.sleep(2000);
		
		TestBase.tearDown();

	}
}
