package com.jupitor.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jupitor.qa.base.TestBase;
import com.jupitor.qa.pages.ShopPage;
import com.jupitor.qa.pages.Toy_ContactsPage;
import com.jupitor.qa.pages.Toy_HomePage;

public class ShopPageTest extends TestBase{

	Toy_HomePage toy_homePageObj;
	ShopPage shopPageObj;
	public ShopPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		toy_homePageObj = new Toy_HomePage();
		shopPageObj = new ShopPage();
		Toy_ContactsPage toy_contactsPage = new Toy_ContactsPage();
	}

	@Test(priority=1)
	public void ShopPage_TitleTest(){
		toy_homePageObj.clickOnShopPage();
		boolean isDisplayed = shopPageObj.validateShopPageBuyBtn();
		Assert.assertTrue(isDisplayed);
	}
	@Test(priority=2)

	public void Validate_Buy_Animals_Test(){

		//Click on Shop Link 
		toy_homePageObj.clickOnShopPage();

		//Click on Funny cow buy btn for 2 times
		WebElement buttonElement = driver.findElement(By.xpath("//li[@id='product-6']//a[@class='btn btn-success'][normalize-space()='Buy']"));
		int i;
		for(i=0;i<=1;i++) {
			buttonElement.click();
		}

		//Click on Fluffy buy btn for 1 Time 
		shopPageObj.Click_Fluffy_bunny();
		//Click on Cart menu 
		shopPageObj.Click_CartMenu();

		//Verify Item are in cart
		String expected_Message = shopPageObj.verify_ItemAreInTheCart();
		System.out.println("Expected Message is " +expected_Message );
		Assert.assertEquals(expected_Message, "There are 3 items in your cart, you can Checkout or carry on Shopping.");
	}

	@Test(priority=3)
	public void Validate_Price_for_each_product() {

		//Click on Shop Link 
		toy_homePageObj.clickOnShopPage();

		//Click on Stuffed_Frog_buy_btn for 2 times
		WebElement Stuffed_Frog_buy_btn = driver.findElement(By.xpath("//li[@id='product-2']//a[@class='btn btn-success'][normalize-space()='Buy']"));

		for(int i=0;i<=1;i++)
		{
			Stuffed_Frog_buy_btn.click();
		}

		//Click on Fluffy_bunny_buy_btn for 2 times
		WebElement Fluffy_bunny_buy_btn = driver.findElement(By.xpath("//li[@id='product-4']//a[@class='btn btn-success'][normalize-space()='Buy']"));

		for(int j=0;j<=4;j++)
		{
			Fluffy_bunny_buy_btn.click();
		}

		//Click on Valentine_Bear_buy_btn for 2 times
		WebElement Valentine_Bear_buy_btn = driver.findElement(By.xpath("//li[@id='product-7']//a[@class='btn btn-success'][normalize-space()='Buy']"));

		for(int k=0;k<=2;k++)
		{
			Valentine_Bear_buy_btn.click();
		}

		//Click on Cart menu 
		shopPageObj.Click_CartMenu();

		//Verify Item are in cart
		String expected_Message = shopPageObj.verify_ItemAreInTheCart();
		System.out.println("Expected Message is " +expected_Message );
		Assert.assertEquals(expected_Message, "There are 10 items in your cart, you can Checkout or carry on Shopping.");


		//Verify the price for Stuffed Frog
		String expected_Stuffed_frog_price = "$10.99"; 
		String actualStuffed_frog_price = driver.findElement(By.xpath("//td[normalize-space()='$10.99']")).getText(); 
		Assert.assertEquals(expected_Stuffed_frog_price, actualStuffed_frog_price, "Verify Stuffed Frog Price");

		//Verify the price for Fluffy Bunny
		String expected_Fluffy_bunny_price = "$9.99"; 
		String actualFluffy_bunny_price = driver.findElement(By.xpath("//td[normalize-space()='$9.99']")).getText(); 
		Assert.assertEquals(expected_Fluffy_bunny_price, actualFluffy_bunny_price, "Verify Fluffy Bunny Price");

		//Verify the price for Valentine Bear
		String expected_Valentine_Bear_price = "$14.99"; 
		String actual_Valentine_Bear_price = driver.findElement(By.xpath("//td[normalize-space()='$14.99']")).getText(); 
		Assert.assertEquals(expected_Valentine_Bear_price, actual_Valentine_Bear_price, "Verify Fluffy Bunny Price");

		//verify each product sub total
		String Stuffed_frog_price = driver.findElement(By.xpath("//td[normalize-space()='$10.99']")).getText();
		String Stuffed_frog_quantity = driver.findElement(By.xpath("//input[@value='2']")).getText();
//		Stuffed_frog_price * Stuffed_frog_quantity;
		  
	}
	@Test(priority=3)
	public void Each_Product_sub_total() throws InterruptedException {

		//Click on Shop Link 
		toy_homePageObj.clickOnShopPage();

		//Click on Stuffed_Frog_buy_btn for 2 times
		WebElement Stuffed_Frog_buy_btn = driver.findElement(By.xpath("//li[@id='product-2']//a[@class='btn btn-success'][normalize-space()='Buy']"));

		for(int i=0;i<=1;i++)
		{
			Stuffed_Frog_buy_btn.click();
		}

		//Click on Fluffy_bunny_buy_btn for 2 times
		WebElement Fluffy_bunny_buy_btn = driver.findElement(By.xpath("//li[@id='product-4']//a[@class='btn btn-success'][normalize-space()='Buy']"));

		for(int j=0;j<=4;j++)
		{
			Fluffy_bunny_buy_btn.click();
		}

		//Click on Valentine_Bear_buy_btn for 2 times
		WebElement Valentine_Bear_buy_btn = driver.findElement(By.xpath("//li[@id='product-7']//a[@class='btn btn-success'][normalize-space()='Buy']"));

		for(int k=0;k<=2;k++)
		{
			Valentine_Bear_buy_btn.click();
		}

		//Click on Cart menu 
		shopPageObj.Click_CartMenu();



		//************ Sub Total for Fluffy Bunny ********************//

		//Fluffy Bunny Price
		String Actual_Fluufy_price = driver.findElement(By.xpath("//td[normalize-space()='$9.99']")).getText();
		Actual_Fluufy_price = Actual_Fluufy_price.substring(1);
		double Amount_Actual_Fluufy_price = Double.parseDouble(Actual_Fluufy_price);
		System.out.println("The Actual price of Fluffy bunny " + Amount_Actual_Fluufy_price );

		//Fluffy Bunny Quantity
		WebElement  Fluffy_element = driver.findElement(By.xpath("//input[@value='5']"));
		String Fluffy_Bunny_text = Fluffy_element.getAttribute("value");
		double Fluffy_text_value = Double.parseDouble(Fluffy_Bunny_text);
		System.out.println("The value of Fluffy bunny is  " + Fluffy_Bunny_text);

		//Sub Total of the Stuffed frog Price and Quantity
		double Fluffy_bunny_subTotal = Amount_Actual_Fluufy_price*Fluffy_text_value;
		System.out.println("Sub Total of the Fluffy bunny Price and Quantity are  "+ Fluffy_bunny_subTotal);

		//Validate Sub total 
		Assert.assertEquals(Fluffy_bunny_subTotal, 49.95);
		System.out.println("Test passed for Fluffy bunny sub total validation ");

		//************ Sub Total for Stuffed_Frog ********************//

		//Stuffed frog Price
		String actualStuffed_frog_price = driver.findElement(By.xpath("//td[normalize-space()='$10.99']")).getText(); 
		actualStuffed_frog_price = actualStuffed_frog_price.substring(1);
		double amount1value= Double.parseDouble(actualStuffed_frog_price);
		System.out.println("The Actual price of Stuffed_Frog " + amount1value );

		//Stuffed frog Quantity
		WebElement  element = driver.findElement(By.xpath("//input[@value='2']"));
		String text = element.getAttribute("value");
		double text_value = Double.parseDouble(text);
		System.out.println("text value is "+ text);

		//Sub Total of the Stuffed frog Price and Quantity
		double Stuffed_frog_subTotal = amount1value * text_value;
		System.out.println("Sub Total of the Stuffed frog Price and Quantity are  "+ Stuffed_frog_subTotal);

		//Validate Sub total 
		Assert.assertEquals(Stuffed_frog_subTotal, 21.98);
		System.out.println("Test passed for sub total validation ");


		//************ Sub Total for Valentine Bear********************//

		//Valentine BearPrice
		String Actual_Valentine_Bear_price = driver.findElement(By.xpath("//td[normalize-space()='$14.99']")).getText();
		Actual_Valentine_Bear_price = Actual_Valentine_Bear_price.substring(1);
		double Amount_Actual_Valentine_Bear_price = Double.parseDouble(Actual_Valentine_Bear_price);
		System.out.println("The Actual price of Valentine Bear " + Amount_Actual_Fluufy_price );

		//Valentine Bear Quantity
		WebElement  Valentine_Bear_element = driver.findElement(By.xpath("//input[@value='3']"));
		String Valentine_Bear_text = Valentine_Bear_element.getAttribute("value");
		double Valentine_Bear_text_value = Double.parseDouble(Valentine_Bear_text);
		System.out.println("The value of Valentine Bear is  " + Valentine_Bear_text);

		//Sub Total of the Valentine Bear Price and Quantity
		double Valentine_Bear_subTotal = Amount_Actual_Valentine_Bear_price * Valentine_Bear_text_value;
		System.out.println("Sub Total of the Valentine Bear Price and Quantity are  "+ Valentine_Bear_subTotal);

		//Validate Sub total 
		Assert.assertEquals(Valentine_Bear_subTotal, 44.97);
		System.out.println("Test passed for Valentine Bear sub total validation " + Valentine_Bear_subTotal);


		//************ Verify that total = sum(sub totals) ********************//
		
		double Total_amount_of_all_Products = Valentine_Bear_subTotal + Stuffed_frog_subTotal + Fluffy_bunny_subTotal; 
		String Total_all_products = driver.findElement(By.xpath("//tfoot//tr[1]//td[1]")).getText();
		Assert.assertEquals(Total_amount_of_all_Products , 116.9 );
		 
		System.out.println("*************** Total Amount of All The Products " + Total_amount_of_all_Products );
		
		
	}


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
