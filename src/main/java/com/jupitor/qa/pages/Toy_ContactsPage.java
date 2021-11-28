package com.jupitor.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jupitor.qa.base.TestBase;

public class Toy_ContactsPage extends TestBase{

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(xpath ="//span[@id='forename-err']")
	WebElement ForenameErrorDisplay_Txt;

	@FindBy(xpath="//a[normalize-space()='Submit']")
	WebElement clickSubmit;

	@FindBy(xpath="//span[@id='forename-err']")
	WebElement forename_error_txt;

	@FindBy(xpath="//span[@id='email-err']")
	WebElement EmailIsRequired_error_txt;

	@FindBy (xpath="//span[@id='message-err']")
	WebElement MessageRequired_error_txt;

	//Forename
	@FindBy(xpath="//input[@id='forename']")
	WebElement Forename;

	//Surname
	@FindBy(xpath="//input[@id='surname']")
	WebElement Surname;

	//Email
	@FindBy(xpath="//input[@id='email']")
	WebElement Email;

	//Telephone
	@FindBy(xpath="//input[@id='telephone']")
	WebElement Telephone;

	//Message
	@FindBy(xpath="//textarea[@id='message']")
	WebElement Message;
	
	//Welcome your feedback
	@FindBy(xpath="//strong[normalize-space()='We welcome your feedback']")
	WebElement Welcome_Message;
	
	//sucessful message
	@FindBy(xpath="//strong[@class='ng-binding']")
	WebElement feedback_Message;
	
	//FullMessage
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement fullmessage;

	// Initializing the Page Objects:
	public Toy_ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public String validate_Forenam_error_display_txt() {
		return ForenameErrorDisplay_Txt.getText();
	}

	public void clickSubmitBtn() {
		clickSubmit.click();
	}
	public String validateForename_erro() {
		return forename_error_txt.getText();
	}
	public String email_error_txt() {
		return EmailIsRequired_error_txt.getText();
	}
	public String message_error_txt() {
		return MessageRequired_error_txt.getText();
	}

	public void enterForename() {
		Forename.sendKeys("laurence");
	}
	public void enterSurname() {
		Surname.sendKeys("john");
	}
	public void enterEmail() {
		Email.sendKeys("lawrence@gmail.com");
	}
	public void enterTelephone() {
		Telephone.sendKeys("123132323");
	}
	public void enterMessage() {
		Message.sendKeys("This is the automation message");
	}
	
	public String welcomeMessage_txt() {
		 return Welcome_Message.getText();
	}
	public String feedback_txt() {
		return fullmessage.getText();
	}

}
