package com.Kidbiz.CreateUsers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.Canvas.CanvasAdminHomepage;
import com.KidbizSSO.Method.Canvas.CanvasLoginPage;
import com.KidbizSSO.Method.Canvas.CanvasSearchPage;
import com.KidbizSSO.Method.Schoology.Schoology;

public class CanvasNewUserTest extends BaseClass{
	
	CanvasLoginPage canvasLoginPage;
	CanvasAdminHomepage adminHomepage;
	CanvasSearchPage canvasSearchPage;
	
	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("canvasUrl"));
		
		canvasLoginPage =new CanvasLoginPage();
	}
	
	@Test
	public void createNewCanvasTeacherTest() {
		//Canvas login page
		canvasLoginPage.inputEmail();
		canvasLoginPage.inputPassword();
		adminHomepage= canvasLoginPage.clickLogin();
		
		//Click on Admin button
		adminHomepage.clickAdmin();
		
		// click on Actively Learn
		canvasSearchPage= adminHomepage.clickOnAL();
		canvasSearchPage.clickPeople();
		canvasSearchPage.clickpeopleForm();
		canvasSearchPage.fillForm();
		
		
	}
	
	@AfterMethod (enabled = false)
	public void tearDown() {
		wd.quit();
	}

}
