package com.KidbizSSO.Method.OLP.NewTeachSingleSchAndClassEnrl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class NewTeacherAccountPolicyConfirmPage extends BaseClass {
	public NewTeacherAccountPolicyConfirmPage() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}
	
	@FindBy(css = "input[type='checkbox']")
	WebElement confirmPolicyCheckBox;
	
	@FindBy(css = "button[type='submit']")
	WebElement continueBtn;
	
	public void clickCheckBox() {
		Utils.waitForElementToBeClickable(confirmPolicyCheckBox, Utils.Explicit_Wait);
		Utils.clickOnElement(confirmPolicyCheckBox);
	}
	
	public NewTeacherConnectEdHomepage clickContinueBtn() {
		Utils.clickOnElement(continueBtn);
		return new NewTeacherConnectEdHomepage();
	}
	
	
	
}
