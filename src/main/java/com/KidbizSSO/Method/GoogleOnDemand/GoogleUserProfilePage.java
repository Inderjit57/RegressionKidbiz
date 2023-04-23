package com.KidbizSSO.Method.GoogleOnDemand;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class GoogleUserProfilePage extends BaseClass {
	/*
	 * User profile page
	 * Reset Password / Add to group
	 */
	public GoogleUserProfilePage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	// Add user to group
	@FindBy(xpath = "//li[@id='node-N745-51641']//a[text()='Groups']")
	private WebElement groupBtn;
	
	@FindBy(css = "tr[data-group-name='Classroom Teachers'] div[data-tooltip='Add members']")
	private WebElement addMemberBtn;
	
	@FindBy(css = "input[aria-label='Find a user or group']")
	private WebElement findUserField;
	
	@FindBy(xpath = "//div[@class=' tWfTvb'] /div[@role='listbox']/ div/div[1]")
	private WebElement searchUserClick;
	
	@FindBy(css = "div[class='nL3Jpb J9fJmf'] div:nth-of-type(3)")
	private WebElement addToGroupBtn;
	
	
	//Reset User Login Password
	@FindBy(css = ".ojtXsd.lfCds div[aria-label='Reset password']")
	private WebElement resetPassword;
	
	@FindBy(css = "div[data-label='Create password']")
	private WebElement createPasswordBtn;
	
	@FindBy(css = "input[type='password']")
	private WebElement passwordField;
	
	@FindBy(css = "div[role='checkbox']")
	private WebElement permissionCheckbox;
	
	@FindBy(css = "div[class='nL3Jpb J9fJmf'] div[role='button']:nth-of-type(2)")
	private WebElement resetBtn;
	
	public void addUserToGroup() {
		Utils.clickOnElement(groupBtn);
		
		Utils.moveToElement(addMemberBtn);
		Utils.actionClick(addMemberBtn);
		
		Utils.sendData(findUserField, GoogleAdminHomepage.firstName);
		Utils.waitForElementToBeClickable(searchUserClick, Utils.Explicit_Wait);
		Utils.clickOnElement(addToGroupBtn);		
	}
	
	public void resetUserPassword() {
		Utils.clickOnElement(resetPassword);
		Utils.clickOnElement(createPasswordBtn);
		Utils.sendData(passwordField, properties.getProperty("googleOnDemandPassword"));
		Utils.clickOnElement(permissionCheckbox);
		Utils.clickOnElement(resetBtn);
	}

}
