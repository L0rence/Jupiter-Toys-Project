package com.jupitor.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jupitor.qa.base.TestBase;

public class Toy_HomePage extends TestBase{

	@FindBy(xpath = "//a[normalize-space()='Contact']")
	WebElement contactsLink;

	@FindBy(xpath ="//div[@class='alert alert-info ng-scope']")
	WebElement contactsDisplayTxt;

	// Shop Link 
	@FindBy (xpath="//a[normalize-space()='Shop']")
	WebElement Shop_Link;



	// Initializing the Page Objects:
	public Toy_HomePage() {
		PageFactory.initElements(driver, this);
	}

	//Actions 
	// Click on Contact Page link 
	public Toy_ContactsPage clickOnContactLink() {
		contactsLink.click();
		return new Toy_ContactsPage();
	}
	//Validate contact page title
	public String  validateContactPageTitle() {
		return driver.getTitle();
	}
	//Validate Display txt
	public String validateDisplayTxt() {
		return contactsDisplayTxt.getText();
	}

	//Click on Shop Page 
	public ShopPage clickOnShopPage() {
		Shop_Link.click();
		return new ShopPage();
	}

	



}
