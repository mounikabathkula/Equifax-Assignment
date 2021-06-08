package endTests;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTest extends BaseTest{
	
	@Test
	public void validationTestAmazon()
	{
		test=extent.startTest("validationTestAmazon");
		HomePage homePage=new HomePage(driver, test);
		homePage.searchtext("qa testing for beginners");
		String price =homePage.getPrice();
		System.out.println("price-"+price);
		ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver,test);
		productDetailsPage.validatePrice(price);
		extent.endTest(test);
		
	}
	
	@Test
	public void getEmployeeDetails()
	{
		test=extent.startTest("getEmployeeDetails");
		Response response=RestAssured.get();
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		extent.endTest(test);
	}
	@Test
	public void deleteEmployeeDEtails()
	{
		test=extent.startTest("deleteEmployeeDEtails");
		Response response=RestAssured.delete();
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		extent.endTest(test);
	}
}
