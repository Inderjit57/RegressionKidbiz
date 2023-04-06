package com.KidbizSSO.Method.Schoology;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.KidbizSSO.BasePackage.BaseClass;
import com.KidbizSSO.Util.Utils;

public class SchoologyCreateNewTeacher extends BaseClass {

	/*
	 * User Management page to create users
	 */
	public SchoologyCreateNewTeacher() {
		PageFactory.initElements(wd, this);
		waitForPageToLoad();
	}

	@FindBy(css = "div[id='sidebar-left'] ul li:nth-of-type(2) a")
	private WebElement createUserBtn;

	@FindBy(css = "a[class='select2-choice']")
	private WebElement schoolDropDown;

	@FindBy(css = "#s2id_autogen1_search")
	private WebElement schoolSelectionCreateUser;

	@FindBy(css = "select[name='role']")
	private WebElement role;

	@FindBy(css = "div[class='form-radios'] div:nth-of-type(1) input")
	private WebElement emailConflicts;

	@FindBy(xpath = "//table[@class='user-list sticky-enabled sticky-table']/tbody/tr[1]/td[1]/div/input")
	private WebElement firstNameCell;

	@FindBy(xpath = "//table[@class='user-list sticky-enabled sticky-table']/tbody/tr[1]/td[3]/div/input")
	private WebElement lastNameCell;

	@FindBy(xpath = "//table[@class='user-list sticky-enabled sticky-table']/tbody/tr[1]/td[4]/div/input")
	private WebElement userNameCell;

	@FindBy(xpath = "//table[@class='user-list sticky-enabled sticky-table']/tbody/tr[1]/td[5]/div/input")
	private WebElement emailCell;

	@FindBy(xpath = "//table[@class='user-list sticky-enabled sticky-table']/tbody/tr[1]/td[6]/div/input")
	private WebElement uniqueIDCell;

	@FindBy(xpath = "//table[@class='user-list sticky-enabled sticky-table']/tbody/tr[1]/td[7]/div/input")
	private WebElement passwordCell;

	@FindBy(css = "#edit-submit")
	private WebElement createUserBtnSubmitForm;

	// select School from the list and send it to UI
	private String[] schoologySchoolNameCreateUSer = { "SCHOOLOGY Luda's Test School K+S+A",
			"SCHOOLOGY Luda's Test School K+S+M", "SCHOOLOGY Luda's Test School K+M",
			"SCHOOLOGY Luda's Test School K+A", "SCHOOLOGY Luda's Test School K only",
			"SCHOOLOGY Luda's Test School K+S" };
	private Random randomSchoologySchoolCreateUSer;
	private int randomSelectionCreateUser;
	private String pickSchoologySchool;

	public void clickCreateUserLeftNavigation() {
		Utils.clickOnElement(createUserBtn);
	}

	public void selectSchool() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2[class='page-title ']")));
		Utils.clickOnElement(schoolDropDown);

		randomSchoologySchoolCreateUSer = new Random();
		randomSelectionCreateUser = randomSchoologySchoolCreateUSer.nextInt(schoologySchoolNameCreateUSer.length);
		pickSchoologySchool = schoologySchoolNameCreateUSer[randomSelectionCreateUser];

		System.out.println("School picked: " + pickSchoologySchool);

		/*
		 * Importing the list of schools present on the frontend. Then comparing them
		 * with the schools in the Arraylist. Once matched then click
		 */
		List<WebElement> selectPickedSchoolCreateUser = wd.findElements(By.xpath("// div[@id='select2-drop']/ ul/li"));
		for (WebElement element : selectPickedSchoolCreateUser) {

			if (element.getText().equals(pickSchoologySchool)) {
				Utils.clickOnElement(element);
				break;
			} else
				continue;
		}

	}

	public void clickTeacherRole() {
		Utils.selectFromDropDownUsingVisibleText(role, "Teacher");
	}
	
	public void clickStudentRole() {
		Utils.selectFromDropDownUsingVisibleText(role, "Student");
	}

	public void clickEmailConflicts() {
		Utils.clickOnElement(emailConflicts);
	}

	public void fillcredentials() {
		/*
		 * Variables declared a to fill the form to create new teacher. Variables are
		 * declared and initialised in the scope of this method, so that for a new
		 * webDriver instance(when invocation count is >1) new random value will be
		 * created. If they are declared at class level, Webdriver takes the old value
		 */
		String firstName = "SchStudent" + properties.getProperty("currentDateForUsers")
				+ RandomStringUtils.randomAlphabetic(4);
		String lastName = RandomStringUtils.randomAlphabetic(3); // Generic for Student and Teacher Account
		String userName = firstName;
		String email = firstName + "_" + lastName + properties.getProperty("emailDomain");
		String uniqueId = firstName;
		String password = properties.getProperty("passwordToSet");

		Utils.sendData(firstNameCell, firstName);
		Utils.sendData(lastNameCell, lastName);
		Utils.sendData(userNameCell, userName);
		Utils.sendData(emailCell, email);
		Utils.sendData(uniqueIDCell, uniqueId);
		Utils.sendData(passwordCell, password);

		System.out.println("UserName: " + firstName);
		System.out.println("Email: " + email + "\nPassword: " + password);
	}

	public void clickCreateUserSubmitBtn() {
		Utils.submitInfo(createUserBtnSubmitForm);
	}

}
