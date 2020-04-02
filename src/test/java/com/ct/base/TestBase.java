package com.ct.base;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {


    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static Logger log = Logger.getLogger("devpinoyLogger");
    //public static Logger getRootLogger()
    public static FileInputStream fis;


    @BeforeSuite
    public void setUp() throws IOException {
        if (driver == null) {

            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\config.properties");
            config.load(fis);

            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\OR.properties");
            OR.load(fis);

        }

        if (config.getProperty("browser").equals("firefox")) {
            driver = new FirefoxDriver();

        } else if (config.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\QA\\AA Torrent Tutorials\\Selenium WebDriver with Java -Basics to Advanced+Frameworks\\19. Framework Part -3- Maven- Build Management tool\\CultureTrip\\src\\main\\resources\\exceutables\\chromedriver.exe");
            driver = new ChromeDriver();
            log.debug("Google Chrome Launched!!");

        } else if (config.getProperty("browser").equals("ie")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\exceutables\\\\src\\main\\resources\\exceutables\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            log.debug("IEe Launched!!");
        }

        driver.get("https://surfweb.staging.travel.theculturetrip.com/ctweb/");
        // driver.get(config.getProperty("testurl"));
        log.debug("Navigated to: "+config.getProperty("testurl"));
        driver.manage().window().maximize();
        log.debug("Window Maximised");
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);

    }



    public boolean isElementPresent(By by)
    {

        try{
            driver.findElement(by);
            return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }



        @AfterSuite
        public void tearDown()
        {

            if(driver!=null)
            {
                driver.quit();


            }
            //log.debug("Test Execution Completed!!");


         }
}
