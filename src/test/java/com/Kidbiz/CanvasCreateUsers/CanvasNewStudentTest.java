package com.Kidbiz.CanvasCreateUsers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.Canvas.CanvasAdminHomepage;
import com.KidbizSSO.Method.Canvas.CanvasLoginPage;
import com.KidbizSSO.Method.Canvas.CanvasNewClassAndUser.CanvasCreateStudent;

public class CanvasNewStudentTest extends BaseClass {
	CanvasLoginPage canvasLoginPage;
	CanvasAdminHomepage adminHomepage;
	CanvasCreateStudent canvasCreateStudent;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("canvasUrl"));

		canvasLoginPage = new CanvasLoginPage();
	}

	@Test(invocationCount = 1)
	public void createNewCanvasUserTest() throws Exception {
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
		canvasCreateStudent = adminHomepage.clickOnALStudent();
		canvasCreateStudent.clickPeople();
		canvasCreateStudent.clickpeopleForm();
		canvasCreateStudent.fillForm();
		canvasCreateStudent.clickSubmitBtn();
		softAssert.assertAll();
	}

	@AfterMethod(enabled = true)
	public void tearDown() {
		wd.quit();
	}

}
