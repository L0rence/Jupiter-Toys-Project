package com.jupitor.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jupitor.qa.base.TestBase;

public class ShopPage extends TestBase{

	// Buy Btn
	@FindBy(xpath="//li[@id='product-1']//a[@class='btn btn-success'][normalize-space()='Buy']")
	WebElement BuyBtn;
	
	// FunnyCow
	@FindBy(xpath="//li[@id='product-6']//a[@class='btn btn-success'][normalize-space()='Buy']")
	WebElement FunnyCow_Buy_btn;
	
	//Fluffy Bunny
	@FindBy(xpath="//li[@id='product-4']//a[@class='btn btn-success'][normalize-space()='Buy']")
	WebElement FluffyBunny_BuyBtn;
	
	// Cart Menu
	@FindBy(xpath="//a[@href='#/cart']")
	WebElement CartMenu;
	
	//Cart Message
	@FindBy(xpath="//p[@class='cart-msg']")
	WebElement Cart_Message;
	
	//Suffed_Frog_buy_btn
	@FindBy(xpath="//li[@id='product-2']//a[@class='btn btn-success'][normalize-space()='Buy']")
	WebElement Suffed_Frog_buy_btn;
	
	// Initializing the Page Objects:
	public ShopPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Action Methods 

	//Validate contact page title
	public boolean  validateShopPageBuyBtn() {
		return BuyBtn.isDisplayed();
	}
	
	//Click on Funny cow
	public void Click_FunnyCow() {
//		FunnyCow_Buy_btn.click();
		
	}
	
	//Click on Fluffy Bunny 
	public void Click_Fluffy_bunny() {
		FluffyBunny_BuyBtn.click();
	}
	
	//Click on CartMenu
	public void Click_CartMenu() {
		CartMenu.click();
	}
	
	//View Cart Message and Verify
	public String verify_ItemAreInTheCart() {
		return Cart_Message.getText();
	}
	
//	WebElement Stuffed_Frog_buy_btn 
	//Click on Stuffed_frog_buy_btn
	public void ClickOnStuffed_frog_buy_btn() {
		Suffed_Frog_buy_btn.click();
	}
	
	
	


}
