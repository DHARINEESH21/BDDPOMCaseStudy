package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewArticlePage {
	
   @FindBy(xpath="//a[@href='#/editor']")
	WebElement article_btn;
   
   
   @FindBy(xpath="//input[@placeholder='Article Title']")
   WebElement articleTitle;

   
   @FindBy(xpath="//input[@class='form-control ' and @name='description']")
   WebElement articleAbout; 
   
   @FindBy(xpath="//textArea[@rows='8']")
   WebElement textArea;
   
  @FindBy(xpath="//input[@placeholder='Enter tags']") 
  WebElement enterTags;
 
   @FindBy(xpath="//button[@type='submit']") 	
   WebElement publish_article_btn;
   
   @FindBy(xpath="//h1[contains(text(),'Testing13')]")
   WebElement headerBtn;

   @FindBy(xpath="//span[text()='Title already exists.. ']")
	WebElement invalidMsg;
   
 public NewArticlePage(WebDriver driver) {
	PageFactory.initElements(driver,this); 
	} 
 public void createArticle()
 {
	 article_btn.click();
 }
 public void newArticle(String ArtTitle,String Artabout,String Artarea,String Arttags) {
	
	 articleTitle.clear();
	 articleTitle.sendKeys(ArtTitle);
	 articleAbout.clear();
	 articleAbout.sendKeys(Artabout); 
	 textArea.clear();
	 textArea.sendKeys( Artarea);
	 enterTags.clear();
	 enterTags.sendKeys(Arttags); 
	 publish_article_btn.click(); 		
	 
	//   Assert.assertEquals(headerBtn.getText(),"Testing11");
 }
 public String articleName()
	{
		return headerBtn.getText();
	}
 
 public String duplicateArticleMsg()
	{
        
		return invalidMsg.getText();
	}
 
}
