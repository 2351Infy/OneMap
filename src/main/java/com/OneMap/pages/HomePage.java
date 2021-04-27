package com.OneMap.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.OneMap.base.TestBase;

public class HomePage extends TestBase {
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
	//=============================================Element Identifiers============================================//
	
	@FindBy(xpath = "//img[contains(@src,'tutorial_close.png')]")
	WebElement tutorialCloseIcon;

	@FindBy(id = "search-text")
	WebElement SearchTextbox;

	@FindBy(xpath = "//p[contains(@class,'sub ng-binding')]")
	WebElement SelectValue;

	@FindBy(xpath = "//p[@class='block wrap']")
	WebElement locationMarker;
	
	@FindBy(xpath = "//*[contains(text(),'Vaccination Centres')]//ancestor::div[@id='VaccinationDisplay']")
	WebElement VaccinationCenter;
	
	@FindBy(xpath = "//div[@class='theme-group']/div")
	WebElement MessageOnVaccTabEle;
	
	@FindBy(xpath = "//span[contains(text(),'COVID-19 Test Providers')]")
	WebElement COVID19TestProviderEle;
	
	@FindBy(xpath = "//div[@class='DroneCheckBox']")
	WebElement MessageOnCOVID19ProvidertabEle;
	
	@FindBy(xpath="//a[@class='wb collapsed']")
    WebElement ToogleButtonEle;
	
	@FindBy(id="SQDisplay_M")
    WebElement landQueryEle;
	
	@FindBy(xpath="//button[contains(text(),'Find Secondary School Information')]")
    WebElement FindSecondarySchoolInfoEle;

	
	
	
//============================Methods==========================================//
	
	//For closing the tutorial pop up window
	public void clickTutorialOnCloseIcon(){
		tutorialCloseIcon.click();

	}
	
	//Click on Search Text Box of Home Page
	public void clickOnSearchTextbox(){
		SearchTextbox.click();
	}
	
	//To get the location marker text on Map
	public void getLocationOnMap() throws InterruptedException {
		locationMarker.getText();
		Thread.sleep(3000);
	}
	
	
	//Enter the value in Search text box
	public String sendvalueToSearchTextBox(String element){
		SearchTextbox.click();
		SearchTextbox.clear();
		SearchTextbox.sendKeys(element);
		//SelectFromDropdown(SearchTextbox);
		return element;
	}
	
	//Enter the value in search text box and get the location on Map
	public void SearchLocationDropdownSelect(String string) throws InterruptedException {
		if(SelectValue!=null) {
			SelectValue.click();
			getLocationOnMap();
			Thread.sleep(2000);
		}
		
	}
	
	//Method to get the text on the text from Vaccination Center Tab in Home Page
	public void VerifyAfterClickVaccinationCenterTab() throws InterruptedException {
		VaccinationCenter.click();
		MessageOnVaccTabEle.getText();
		Thread.sleep(2000);
	}
	
	//Method to get the text on the text from COVID-19 Test Provider Tab in Home Page
	public void VerifyCOVID19TestProvider() throws InterruptedException {
		COVID19TestProviderEle.click();
		MessageOnCOVID19ProvidertabEle.getText();
		Thread.sleep(2000);

}

  public void GetSchoolQuery() throws InterruptedException {
	  ToogleButtonEle.click(); 
	  landQueryEle.click();
	  FindSecondarySchoolInfoEle.getText();
      Thread.sleep(2000); 
     
  }
}