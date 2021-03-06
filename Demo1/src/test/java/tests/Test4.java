package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import pom.GooglePO;
import pom.SearchPO;


public class Test4 extends BaseTest {
	@Test
	public void testLinkedInHome() {
		try {
			driver.get("https://www.google.com/");
			GooglePO googlePO=new GooglePO(driver);
			googlePO.searchTxtBx().sendKeys("linkedin"+Keys.ENTER);
			SearchPO searchPO=new SearchPO(driver);
			searchPO.verifyElement(searchPO.LinkedLink());
			searchPO.LinkedLink().click();
			System.out.println(driver.getTitle());
			String eTitle = "Sign Up | LinkedIn";
			wait.until(ExpectedConditions.titleContains(eTitle));
			String aTitle = driver.getTitle();
			Reporter.log("Title is displayed"+aTitle, true);
			//searchPO.verifyTitle(eTitle);
			Assert.assertEquals(aTitle, eTitle);
		}
			catch(Exception e) {
				Assert.fail();
			}

	}}

