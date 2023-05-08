package com.Kidbiz.GoogleOnDemandTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Method.GoogleOnDemand.GoogleAdminHomepage;
import com.KidbizSSO.Method.GoogleOnDemand.GoogleAdminSignInPage;
import com.KidbizSSO.Method.GoogleOnDemand.GoogleUserProfilePage;

public class GoogleOnDemandNewUserTest extends BaseClass {
	GoogleAdminSignInPage googleAdminSignInPage;
	GoogleAdminHomepage googleAdminHomepage;
	GoogleUserProfilePage googleUserProfilePage;

	@BeforeMethod
	public void initialisation() {
		browserInitialization();
		wd.get(properties.getProperty("googleOnDemandUrl"));

		googleAdminSignInPage = new GoogleAdminSignInPage();
	}

	@Test
	public void createNewUSerGoogleOD() throws Exception {

		googleAdminSignInPage.inputEmail();
		googleAdminSignInPage.inputPassword();

		googleAdminHomepage = googleAdminSignInPage.clickNext();
		googleAdminHomepage.clickAddUserBtn();
		googleAdminHomepage.inputInfo();
		googleAdminHomepage.clickAddNewUserBtn();
		googleUserProfilePage = googleAdminHomepage.getNewUserInfo();

		googleUserProfilePage.addUserToGroup();
//		googleUserProfilePage.resetUserPassword();

	}

	@AfterMethod(enabled = false)
	public void tearDown() {
		wd.quit();
	}

}
