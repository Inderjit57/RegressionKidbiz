package com.Kidbiz.OLPTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.OLP.AdminAccountHomepage;
import com.KidbizSSO.Method.OLP.AdministratorPage;
import com.KidbizSSO.Method.OLP.OLPCreateNewStudentPage;

import com.KidbizSSO.Method.OLP.OLPLoginPage;

public class OLPCreateNewStudentTest extends BaseClass {
	OLPLoginPage olpLoginPage;
	AdminAccountHomepage adminAccountHomepage;
	AdministratorPage administratorPage;
	OLPCreateNewStudentPage olpCreateNewStudentPage;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("mhURL"));

		olpLoginPage = new OLPLoginPage();
	}

	@Test(invocationCount = 1)
	public void createNewOLPStudentTest() throws Exception {
		System.out.println("Current URL: " + wd.getCurrentUrl());
		softAssert.assertEquals(wd.getCurrentUrl(), properties.getProperty("mhURL"),
				"Not a valid Page. Expecting Canvas Login Page");
		olpLoginPage.inputEmailPassword();

		adminAccountHomepage = olpLoginPage.clickLoginBtn();
		adminAccountHomepage.clickDropdown();

		administratorPage = adminAccountHomepage.clickAdministrator();
		administratorPage.clickStudent();

		olpCreateNewStudentPage = administratorPage.clickCreateStudentBtn();
		olpCreateNewStudentPage.inputCredentials();

		olpCreateNewStudentPage.clickCreate();
		softAssert.assertAll();
	}

	@AfterMethod(enabled = true)
	public void tearDown() {
		wd.quit();
	}

}
