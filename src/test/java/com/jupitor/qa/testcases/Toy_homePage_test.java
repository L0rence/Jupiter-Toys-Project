package com.jupitor.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jupitor.qa.base.TestBase;
import com.jupitor.qa.pages.Toy_ContactsPage;
import com.jupitor.qa.pages.Toy_HomePage;

public class Toy_homePage_test extends TestBase{

	Toy_HomePage toy_homePageObj;
	public Toy_homePage_test() {
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		toy_homePageObj = new Toy_HomePage();
		Toy_ContactsPage toy_contactsPage = new Toy_ContactsPage();
	}
	
	@Test(priority=1)
	public void contactPageTitleTest(){
		toy_homePageObj.clickOnContactLink();
		String title = toy_homePageObj.validateContactPageTitle();
		Assert.assertEquals(title,"Jupiter Toys");
	}
	

	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
