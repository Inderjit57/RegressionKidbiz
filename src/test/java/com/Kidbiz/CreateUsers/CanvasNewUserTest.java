package com.Kidbiz.CreateUsers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.Canvas.CanvasAdminHomepage;
import com.KidbizSSO.Method.Canvas.CanvasLoginPage;
import com.KidbizSSO.Method.Canvas.CanvasCreateUserPage;
import com.KidbizSSO.Method.Schoology.Schoology;
import com.KidbizSSO.Util.WriteIntoExcel;

public class CanvasNewUserTest extends BaseClass {

	CanvasLoginPage canvasLoginPage;
	CanvasAdminHomepage adminHomepage;
	CanvasCreateUserPage canvasCreateUserPage;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("canvasUrl"));

		canvasLoginPage = new CanvasLoginPage();
	}

	@Test()
	public void createNewCanvasTeacherTest() throws Exception {
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
		canvasCreateUserPage = adminHomepage.clickOnAL();
		canvasCreateUserPage.clickPeople();
//		softAssert.assertEquals(canvasCreateUserPage.getSearchBtn(),"Search people...","Search element is not present" );
		canvasCreateUserPage.clickpeopleForm();
		canvasCreateUserPage.fillForm();

	}

	@AfterMethod(enabled = true)
	public void tearDown() {
		wd.quit();
	}

}
