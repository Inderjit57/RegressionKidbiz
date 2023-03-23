package com.Kidbiz.CreateUsers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.Canvas.CanvasAdminHomepage;
import com.KidbizSSO.Method.Canvas.CanvasCreateUserPage;
import com.KidbizSSO.Method.Canvas.CanvasLoginPage;
import com.KidbizSSO.Method.Canvas.CanvasNewClass;

public class CanvasAddNewCourse extends BaseClass{

	CanvasLoginPage canvasLoginPage;
	CanvasAdminHomepage adminHomepage;
	CanvasNewClass canvasNewClass;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("canvasUrl"));

		canvasLoginPage = new CanvasLoginPage();
	}
	
	@Test
	public void canvasCreateNewCourseTest() throws Exception {
		System.out.println("Current URL: " + wd.getCurrentUrl());
		softAssert.assertEquals(wd.getCurrentUrl(), properties.getProperty("canvasUrl"),
				"Not a valid Page. Expecting Canvas Login Page");
		// Canvas login page
		canvasLoginPage.inputEmail();
		canvasLoginPage.inputPassword();
		adminHomepage = canvasLoginPage.clickLogin();

		// Click on Admin button
		adminHomepage.clickAdmin();

		// click on Actively Learn
		canvasNewClass = adminHomepage.clickAL1();
		canvasNewClass.addcourse();
	}
	
	@AfterMethod(enabled = false)
	public void tearDown() {
		wd.quit();
	}
}