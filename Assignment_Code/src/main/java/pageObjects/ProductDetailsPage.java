package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import utils.SeleniumUtils;

public class ProductDetailsPage extends SeleniumUtils {

	@FindBy(how = How.ID, using = "newBuyBoxPrice")
	WebElement price;
	@FindBy(how = How.ID, using = "add-to-cart-button")
	WebElement addtoCart;
	@FindBy(how = How.XPATH, using = "//b[text()='Cart subtotal']/../../span[2]")
	WebElement cartprice;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),' Proceed to checkout')]")
	WebElement checkout;
	

	public ProductDetailsPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	public void validatePrice(String inputprice) {
		String priceValue=price.getText();
		System.out.println(priceValue);
		Assert.assertNotNull(price.getText());
		clickElement(addtoCart, "addtoCart");
		sleep();
		String cartpriceValue=cartprice.getText();
		System.out.println(cartpriceValue);
		clickElement(checkout, "checkout");
		Assert.assertEquals(priceValue, cartpriceValue);
	}

}
