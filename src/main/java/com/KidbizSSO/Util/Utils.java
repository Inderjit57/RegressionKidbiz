package com.KidbizSSO.Util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.KidbizSSO.BasePackage.BaseClass;

public class Utils extends BaseClass{
	
	public static void clickOnElement(WebElement element) {
//		wait.until(ExpectedConditions.elementToBeClickable(element).wait(500));
		element.click();
		
	}
	
	public static void javascriptClick(WebElement element) {
		javascriptExecutor.executeScript("arguments[0].click();", element);
	}
	

}
