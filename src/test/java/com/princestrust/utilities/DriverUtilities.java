package com.princestrust.utilities;

import com.princestrust.support.pageobject.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.sql.Timestamp;
import java.util.*;


public class DriverUtilities extends DriverFactory {

    public WebDriverWait wait = new WebDriverWait(driver, 20);

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
    }

    public String getTimeStamp() {
        Date date = new Date();
        String todaysdate = new Timestamp(date.getTime()).toString();
        todaysdate = todaysdate.replace(".", "");
        todaysdate = todaysdate.replace(":", "");
        todaysdate = todaysdate.replace(" ", "-");
        return todaysdate;
    }


    public String takeScreenShot(String filename) throws Exception {
        filename = filename.replaceAll("[^a-zA-Z0-9/]", "");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //copy the source file to a location we have defined
        FileUtils.copyFile(scrFile, new File("target/screenshots/" + filename + ".png"));
        return "target/screenshots/" + filename + ".png";
    }

}

