package com.princestrust.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

    protected static WebDriver driver;

    private static void createNewDriverInstance(){
        String browser = new PropertyReader().readProperty("browser");
       if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
            //System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }else{
            System.out.println("Cannot read browser type: " + browser);
        }
    }

    public static WebDriver getDriver(){
        if(driver == null)  {
            createNewDriverInstance();
        }
        return driver;
    }

    public static void destroyDriver(){
        driver.quit();
        driver = null;
    }
}
