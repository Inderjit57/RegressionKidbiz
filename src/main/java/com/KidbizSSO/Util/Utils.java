package com.KidbizSSO.Util;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.KidbizSSO.BasePackage.BaseClass;

public class Utils extends BaseClass {

	public static Select select;
	public static Actions actions = new Actions(wd);

	public static int waitForSeconds = 15;

	// Javascript Executor will got the WebElement to perform click function
	public static void javascriptClick(WebElement element) {
		javascriptExecutor.executeScript("arguments[0].click();", element);
	}

	// Javascript Executor will scroll to the WebElement if its not visible on the
	// font
	public static void scrollIntoViewUsingJavascript(WebElement element) {
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Click on Element
	public static void clickOnElement(WebElement element) {
		waitForElementToBeClickable(element, waitForSeconds).click();
	}

	// Submit
	public static void submitInfo(WebElement element) {
		waitForElementToBeClickable(element, waitForSeconds).submit();
	}

	// Send Keys
	public static void sendData(WebElement element, String text) {
		waitForElementToBeVisible(element, waitForSeconds).sendKeys(text);
	}

	// Select an element
	public static void selectFromDropDownUsingVisibleText(WebElement element, String text) {
		try {
			if (waitForElementToBeSelectable(element, 15)) {
				new Select(element).selectByVisibleText(text);
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}

	}

	public static void selectFromDropDownUsingIndex(WebElement element, int index) {
		try {
			if (waitForElementToBeSelectable(element, 15)) {
				new Select(element).selectByIndex(index);
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}

	}
	
	public static void moveToElement(WebElement element) {
		actions.moveToElement(element).build().perform();
		
	}
	
	public static void actionClick(WebElement element) {
		actions.click(element).perform();
	}

	// Explicit wait: Wait for element to be clickable
	public static WebElement waitForElementToBeClickable(WebElement element, int timeOutInSeconds) {
		return new WebDriverWait(wd, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
	}

	// Explicit wait: Wait for element to be Visible
	public static WebElement waitForElementToBeVisible(WebElement element, int timeOutInSeconds) {
		return new WebDriverWait(wd, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
	}

	// Explicit wait: Wait for element to be Selectable
	public static Boolean waitForElementToBeSelectable(WebElement element, int timeOutInSeconds) {
		return new WebDriverWait(wd, timeOutInSeconds)
				.until(ExpectedConditions.elementSelectionStateToBe(element, false));
	}

}
