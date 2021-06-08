package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumUtils;

import com.relevantcodes.extentreports.ExtentTest;

public class HomePage extends SeleniumUtils {

	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	WebElement searchtext;
	@FindBy(how = How.ID, using = "nav-search-submit-button")
	WebElement Search;
	@FindBy(how = How.XPATH, using = "//h2/a")
	WebElement items;
	@FindBy(how = How.XPATH, using = "//span[@class='a-price-whole']")
	WebElement whole;
	@FindBy(how = How.XPATH, using = "//span[@class='a-price-fraction']")
	WebElement fraction;

	public HomePage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void searchtext(String text) {
		sendKeys(searchtext, text, "searchtext");
		clickElement(Search, "Search");
		sleep();
		clickElement(items, "items");
		sleep();       
		sleep();         
	}
	
	public String getPrice()
	{
		PageFactory.initElements(driver, this);
		String res="";
		
		try{
			res= whole.getText()+"."+fraction.getText();
		}catch(Exception e){
	}
		return res;
		}

}
