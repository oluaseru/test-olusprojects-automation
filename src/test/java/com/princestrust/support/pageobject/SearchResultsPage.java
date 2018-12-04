package com.princestrust.support.pageobject;


import com.princestrust.utilities.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchResultsPage {

    private WebDriver driver;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBys({
            @FindBy(css = ".searchItem"),
            @FindBy(css = "a")
    })
    public List<WebElement> searchResultsTitles;

    @FindBy(css = ".message")
    public WebElement SearchErrorMessage;

    public void verifySearchResultsContainSearchTerm(String fTerm) {
        fTerm = fTerm.toLowerCase();
        for (int i = 0; i < 2; i++) {
            assertTrue(searchResultsTitles.get(i).getText().toLowerCase().contains(fTerm));
        }
    }




}
