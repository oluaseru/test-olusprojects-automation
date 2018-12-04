package com.princestrust.support.pageobject;

import com.princestrust.utilities.DriverUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class NewsAndViewsPage {

    private WebDriver driver;

    public NewsAndViewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".newsItem .newsItemSummary")
    private List<WebElement> newsItemSummary;

    @FindBy(css = "[alt='Caitlin Buckley, young person standing next to a railing']")
    public WebElement featuredImage;

    @FindBy(css = ".featuredNewsItem  .newsItemTitle a")
    public WebElement featuredNewsTitle;

    @FindBy(css = ".featuredNewsItem .newsItemSummary")
    public WebElement featuredDate;

    @FindBy(css = ".featuredNewsItem .newsItemSummary")
    public WebElement featuredExcerpt;

}
