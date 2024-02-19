package stepDefs;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DeleteArticlePage;
import pages.LoginValidPage;
import pages.NewArticlePage;
import pages.UpdateArticlePage;

public class ArticleFunctions {
	
	WebDriver driver = TestBase.getDriver();
	NewArticlePage newArticlePage;
	DeleteArticlePage deleteArticlePage;
	LoginValidPage loginPage;
	UpdateArticlePage updateArticlePage;
	
	public ArticleFunctions()
	{
		newArticlePage = new NewArticlePage(driver);
		deleteArticlePage = new DeleteArticlePage(driver);
		loginPage = new LoginValidPage(driver);
		updateArticlePage = new UpdateArticlePage(driver);
		
	}

	
	@Given("User is on login Page")
	public void user_is_on_login_page() {
		driver.get("https://conduit-realworld-example-app.fly.dev/#/");
	}
	
	@When("User enter inValid credentials")
	public void user_enter_in_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> users = dataTable.asLists();
		
		String strUser = users.get(1).get(0);
		String strPwd = users.get(1).get(1);
		loginPage.validloginTest(strUser, strPwd);
	}
	
	@Then("Should display the invalid login message")
	public void should_display_the_invalid_login_message(io.cucumber.datatable.DataTable dataTable) {
		Assert.assertEquals(loginPage.inValidMsg(),"Wrong email/password combination");
	   
	}
	
	@When("User enter Valid Credentials")
	public void user_enter_valid_credentials(io.cucumber.datatable.DataTable dataTable) {
 
		List<List<String>> users = dataTable.asLists();
		String strUser = users.get(1).get(0);
		String strPwd = users.get(1).get(1);
		loginPage.validloginTest(strUser, strPwd);
	}
	
	@Then("Should display the success login message")
	public void should_display_the_success_login_message(io.cucumber.datatable.DataTable dataTable) {
	  
		List<List<String>> user = dataTable.asLists();
		String userName=user.get(0).get(0);
		Assert.assertTrue(loginPage.getUserNameElement());
	}
	
	
	@Given("User is on newArticleCreationPage")
	public void User_is_on_new_article_creation_page() {
		newArticlePage.createArticle();
	}
	
	@When("User Create the duplicate article")
	public void user_create_the_duplicate_article(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> duplicateArticle = dataTable.asLists();
		String strTitle = duplicateArticle.get(1).get(0);
		String strAbout = duplicateArticle.get(1).get(1);
		String strDesc = duplicateArticle.get(1).get(2);
		String strTags = duplicateArticle.get(1).get(3);
		newArticlePage.newArticle(strTitle, strAbout, strDesc,strTags);
	}
	
	
	@Then("Should display the duplicate article message")
	public void should_display_the_duplicate_article_message() {
		Assert.assertEquals(newArticlePage.duplicateArticleMsg(),"Title already exists..");
	}

	
	@When("User create the new Article")
	public void user_create_the_new_article(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> duplicateArticle = dataTable.asLists();
		String strTitle = duplicateArticle.get(1).get(0);
		String strAbout = duplicateArticle.get(1).get(1);
		String strDesc = duplicateArticle.get(1).get(2);
		String strTags = duplicateArticle.get(1).get(3);
		newArticlePage.newArticle(strTitle, strAbout, strDesc,strTags);
	}
	
	
	@Then("Should display the new Article Title")
	public void should_display_the_new_article_title(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> duplicateArticle = dataTable.asLists();
		String strTitle = duplicateArticle.get(0).get(0);
		Assert.assertEquals(newArticlePage.articleName(),strTitle);
	}

	@Given("User is on updateArticlePage")
	public void user_is_on_update_article_page(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> articleNameToUpdate = dataTable.asLists();
		String strUpdateTitle = articleNameToUpdate.get(1).get(0);
		updateArticlePage.navigateToProfile();
	    updateArticlePage.locateTitle(strUpdateTitle).click();
	}
	
	@When("User Update the Article")
	public void user_update_the_article(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> articleUpdateDetails = dataTable.asLists();
		String strUpdateTitle = articleUpdateDetails.get(1).get(0);
		String strUpdateAbout = articleUpdateDetails.get(1).get(1);
		updateArticlePage.updateArticle(strUpdateTitle, strUpdateAbout);
	}
	
	@Then("Should display the updated Article Title")
	public void should_display_the_updated_article_title(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> articleUpdatedName= dataTable.asLists();
		String strUpdateTitle = articleUpdatedName.get(1).get(0);
		String updatedTitle = updateArticlePage.updatedName(strUpdateTitle);
		Assert.assertEquals(updatedTitle,strUpdateTitle);
	}
	
	@Given("User is on deleteArticlePage")
	public void user_is_on_delete_article_page(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> articleNameToDelete = dataTable.asLists();
		String strArticleToDelete = articleNameToDelete.get(1).get(0);
		deleteArticlePage.navigateToProfile();
		deleteArticlePage.locateTitle(strArticleToDelete).click();
	}
	
	@When("User delete the Article")
	public void user_delete_the_article() {
	   deleteArticlePage.deleteArticle();
	}

	@Then("Should display the article deletion msg")
	public void Should_display_the_article_deletion_msg(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> deletionMsg = dataTable.asLists();
		String deletionText = deletionMsg.get(1).get(0);
		Assert.assertEquals(deleteArticlePage.deleteCheck(deletionText),deletionText);
	}
	


}
