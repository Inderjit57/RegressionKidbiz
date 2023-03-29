package com.KidbizSSO.Method.OLP;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KidbizSSO.BasePackage.BaseClass;

public class AdminAccountHomepage extends BaseClass{
	public AdminAccountHomepage() {

		// TODO Auto-generated constructor stub
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "div[class='dropdown ng-tns-c109-0']")
	WebElement dropdown;
	
	

}
