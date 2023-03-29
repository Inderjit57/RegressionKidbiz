package com.KidbizSSO.Method.OLP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class OLPLoginPage extends BaseClass{
	
	public OLPLoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "input[query-id='login.username']")
	WebElement email;
	
	@FindBy(css = "input[query-id='login.password']")
	WebElement passwprd;
	
	@FindBy(css ="button[type='submit']" )
	WebElement loginBtn;
	
	public void inputEmailPassword() {
		Utils.sendData(email, properties.getProperty("emailMH"));
		Utils.sendData(email, properties.getProperty("emailMH"));
	}
	
	public AdminAccountHomepage clickLoginBtn() {
		
		return new AdminAccountHomepage();
	}

}
