package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginValidPage {
	
      @FindBy (xpath="//a[@href='#/login']")
      WebElement login_btn;
      
      
      @FindBy(xpath="//input[@name='email']")
      WebElement email;
      
      @FindBy(xpath="//input[@name='password']")
      WebElement password;
      
      @FindBy(xpath="//button[contains(text(),'Login')]")
      WebElement loginbtn;
      
      @FindBy(xpath="//img[@alt='Username']")
    	WebElement chckName;
      
      @FindBy(xpath="//ul[@class='error-messages']//li[text()='Wrong email/password combination']")
      WebElement invalidmsg;
      
     public  LoginValidPage (WebDriver driver) { 
    	 
    	 PageFactory.initElements(driver,this);
     
     }
     
     public void validloginTest(String stremail,String strpassword) {
    	login_btn.click(); 	
    	email.clear();
    	 email.sendKeys(stremail); 	 
    	 password.clear();
    	 password.sendKeys(strpassword); 	
    	 loginbtn.click(); 	
    	 
    	 }
    public boolean getUserNameElement() {
   	 return chckName.isDisplayed();
     }
     
     
     public String inValidMsg()
 	{
 		return invalidmsg.getText();
 	}
    }


 