package com.princestrust.support.pageobject;


import com.princestrust.utilities.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".pageTitle")
    private WebElement pageTitle;

    @FindBy(css = ".quickLinks li:nth-of-type(1)")
    @CacheLookup
    public WebElement newsAndViewsBtn;

    @FindBy(css = "#headerSearchField")
    @CacheLookup
    private WebElement searchTextBox;

    @FindBy(css = ".goBtn")
    @CacheLookup
    private WebElement searchBtn;


    public void setSearchTextBox(String sTerm){
        searchTextBox.sendKeys(sTerm);
        searchBtn.click();
        WaitHelper.waitForTextToAppear(driver, "Results", pageTitle);
    }

}
