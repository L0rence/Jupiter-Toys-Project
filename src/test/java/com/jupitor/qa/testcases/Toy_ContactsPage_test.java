package com.jupitor.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jupitor.qa.base.TestBase;

import com.jupitor.qa.pages.Toy_ContactsPage;
import com.jupitor.qa.pages.Toy_HomePage;
import com.jupitor.qa.util.TestUtil;

public class Toy_ContactsPage_test extends TestBase{

	TestUtil testUtil;
	Toy_HomePage toy_homePageObj;
	Toy_ContactsPage toy_contactsPage;
	
	public Toy_ContactsPage_test() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		toy_homePageObj = new Toy_HomePage();
		Toy_ContactsPage toy_contactsPage = new Toy_ContactsPage();
	
	}
	
	
	@Test(priority=5)
	public void verifyContactsLinkTest(){
//		testUtil.switchToFrame();
		toy_contactsPage = toy_homePageObj.clickOnContactLink();
		String title = toy_homePageObj.validateContactPageTitle();
		Assert.assertEquals(title,"Jupiter Toys");
		toy_contactsPage.clickSubmitBtn();
		
		
		
	}
	
	@Test(priority=2)
	public void validateErrors() {
		
		toy_contactsPage = toy_homePageObj.clickOnContactLink();
		toy_contactsPage.clickSubmitBtn();
		
		//Validate Forename error displayed 
		String error_txt =  toy_contactsPage.validateForename_erro();
		System.out.println("title is " + error_txt);
		Assert.assertEquals(error_txt, "Forename is required");
		
		// Validate Email error displayed
		String Expected_Email_error_txt = toy_contactsPage.email_error_txt();
		System.out.println("title is " + Expected_Email_error_txt);
		Assert.assertEquals(Expected_Email_error_txt, "Email is required");
		
		//Validate Message error is displayed 
		String Expected_message_error_txt = toy_contactsPage.message_error_txt();
		System.out.println("Title is " + Expected_message_error_txt);
		Assert.assertEquals(Expected_message_error_txt, "Message is required");
		
	}
	
 
	@Test(priority=3)
	public void Populate_mandatory_filelds() {
		toy_contactsPage = toy_homePageObj.clickOnContactLink();
//		toy_contactsPage.clickSubmitBtn();
		toy_contactsPage.enterForename();
		toy_contactsPage.enterSurname();
		toy_contactsPage.enterEmail();
		toy_contactsPage.enterTelephone();
		toy_contactsPage.enterMessage();
	}
	
	@Test(priority=4)
	public void Validate_Errors_Are_Gone() {
		toy_contactsPage = toy_homePageObj.clickOnContactLink();
//		String Expected_message = toy_contactsPage.welcomeMessage_txt();
//		Assert.assertEquals(Expected_message, "We welcome your feedback");
	}
	
	@Test(priority=1, invocationCount = 2)
	public void ValidateSuccessfullSubmission() {
		toy_contactsPage = toy_homePageObj.clickOnContactLink();
		toy_contactsPage = toy_homePageObj.clickOnContactLink();
		toy_contactsPage.enterForename();
		toy_contactsPage.enterSurname();
		toy_contactsPage.enterEmail();
		toy_contactsPage.enterTelephone();
		toy_contactsPage.enterMessage();
 		toy_contactsPage.clickSubmitBtn();
 		String Expected_message =toy_contactsPage.feedback_txt();
 		System.out.println("Expected message " + Expected_message);
 		Assert.assertEquals(Expected_message, "Thanks laurence, we appreciate your feedback.");
 		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
}
