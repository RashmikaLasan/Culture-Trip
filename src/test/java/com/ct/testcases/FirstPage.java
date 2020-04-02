package com.ct.testcases;

import com.ct.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FirstPage extends TestBase {

    @Test
    public void loginAsUser() throws InterruptedException {

        log.debug("Inside Login Test");
        driver.findElement(By.cssSelector(OR.getProperty("desti"))).sendKeys(OR.getProperty("city"));
        log.debug("Detination Entered");
        driver.findElement(By.cssSelector(OR.getProperty("SupID"))).sendKeys(OR.getProperty("hotelID"));
        log.debug("Hotel ID Entered");
        driver.findElement(By.cssSelector(OR.getProperty("Fday"))).sendKeys(OR.getProperty("day1"));
        log.debug("From Date Enetered");
        driver.findElement(By.cssSelector(OR.getProperty("Sday"))).sendKeys(OR.getProperty("day2"));
        Thread.sleep(3000);
        log.debug("To Date Enetered");
        driver.findElement(By.cssSelector(OR.getProperty("pax"))).sendKeys(OR.getProperty("pcomb"));
        Thread.sleep(3000);
        log.debug("Pax Combination Enetered");
        driver.findElement(By.cssSelector(OR.getProperty("submit"))).click();
        Thread.sleep(12000);
        log.debug("Submit Button Clikced");






    }
}
