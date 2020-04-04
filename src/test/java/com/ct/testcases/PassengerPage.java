package com.ct.testcases;

import com.ct.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PassengerPage extends TestBase {

    @Test(priority = 1)
    public void passengerDetails() throws InterruptedException {
        driver.findElement(By.cssSelector(OR.getProperty("FName1"))).sendKeys(OR.getProperty("FName2"));
        log.debug("Firsn Name Entered");
        driver.findElement(By.id(OR.getProperty("LName1"))).sendKeys(OR.getProperty("LName2"));
        log.debug("Last Name Entered");
        driver.findElement(By.id(OR.getProperty("email1"))).sendKeys(OR.getProperty("email2"));
        log.debug("Email Entered");
        driver.findElement(By.id(OR.getProperty("phone1"))).sendKeys(OR.getProperty("phone2"));
        log.debug("Telephone Number Entered");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(OR.getProperty("sumbit1"))).click();
        log.debug("Sumbit Button Entered Entered");
        Thread.sleep(15000);
        //Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("guest"))),"Guest Count is invalid");
        log.debug("Navigated to the payment page");


    }


}
