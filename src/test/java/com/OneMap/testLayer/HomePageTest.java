package com.OneMap.testLayer;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.OneMap.base.TestBase;
import com.OneMap.pages.HomePage;
import com.OneMap.util.TestUtil;

public class HomePageTest extends TestBase {

	//HomePage homePage= new HomePage();
	HomePage homePage;
	TestUtil testUtil=new TestUtil();



	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser




	@BeforeMethod public void setUp() { 
		initialization(); 
		homePage= new HomePage(); }



	//Test scenario is to navigate to the home page and close the tutorial window of portal.
	@Test(priority=1, enabled=true)
	public void removeTutorial() throws InterruptedException, IOException{
		Thread.sleep(3000);
		homePage.clickTutorialOnCloseIcon();
		Thread.sleep(60);
		TestUtil.takeScreenshotAtEndOfTest();

	}


	//Test scenario is to navigate to the Home page and select the value from search text and verify by assert.
	@Test(priority=2, enabled=true)
	public void selectValueFromDD() throws InterruptedException{
		homePage.clickTutorialOnCloseIcon();
		Thread.sleep(3000);
		String searchValue = homePage.sendvalueToSearchTextBox("NEWTON ONE");
		Thread.sleep(60);
		Assert.assertEquals(searchValue, "NEWTON ONE");

		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Test scenario is to navigate to the home page and enter the value in search box and get the screenshot.
	@Test(priority=3, enabled = true)
	public void EnterSearchValue() throws InterruptedException, IOException{
		homePage.clickTutorialOnCloseIcon();
		Thread.sleep(1000);
		homePage.sendvalueToSearchTextBox("26 NEWTON");
		Thread.sleep(1000);
		homePage.SearchLocationDropdownSelect("26 NEWTON");
		Thread.sleep(1000);
		testUtil.getScreenshot();
	}

	//Test scenario is to navigate to the Vaccination Center and verify the text
	@Test(priority=4, enabled = true)
	public void VerifyVaccinationCenterTab() throws InterruptedException {
		homePage.clickTutorialOnCloseIcon();
		Thread.sleep(1000);
		homePage.VerifyAfterClickVaccinationCenterTab();
		Thread.sleep(2000);
	}

	//Test scenario is to navigate to the COVID-19 Test Provider and verify the text
	@Test(priority=5, enabled = true)
	public void VerifyTextOnCOVID19TestProvider() throws InterruptedException {
		homePage.clickTutorialOnCloseIcon();
		Thread.sleep(1000);
		homePage.VerifyCOVID19TestProvider();
		Thread.sleep(2000);

	}
	@Test(priority=6, enabled = true)
	public void FindEssentialAminitiesasSupermarket() throws InterruptedException {
		homePage.clickTutorialOnCloseIcon();
		Thread.sleep(1000);
		homePage.GetSchoolQuery();
	}
		
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
