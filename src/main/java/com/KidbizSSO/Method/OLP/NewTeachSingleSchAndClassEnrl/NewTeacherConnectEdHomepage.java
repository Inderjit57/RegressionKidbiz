package com.KidbizSSO.Method.OLP.NewTeachSingleSchAndClassEnrl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class NewTeacherConnectEdHomepage extends BaseClass {
	public NewTeacherConnectEdHomepage() {

		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}
	
	@FindBy(css = "div[class='ol-product-content'] div:nth-of-type(1) a")
	WebElement achieve3000Lit;
	
	public NewTeacherAcoountHomepage clickAchive3000Lit() {
		Utils.waitForElementToBeClickable(achieve3000Lit, Utils.Explicit_Wait);
		Utils.clickOnElement(achieve3000Lit);
		return new NewTeacherAcoountHomepage();
	}
}
