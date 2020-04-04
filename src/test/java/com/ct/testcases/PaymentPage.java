package com.ct.testcases;

import com.ct.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentPage extends TestBase {

    @Test(priority = 2)
    public void pay() throws InterruptedException {

        driver.findElement(By.id(OR.getProperty("HolderName1"))).sendKeys(OR.getProperty("HolderName2"));
        log.debug("Card Hilder Name inserted");
        driver.findElement(By.cssSelector(OR.getProperty("Number"))).sendKeys(OR.getProperty("Number"));
        log.debug("redit cated Entered");
        Thread.sleep(5000);

        driver.findElement(By.xpath(OR.getProperty("tick"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("sub2"))).click();
        Thread.sleep(15000);

        //Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("guest"))),"Guest Count is invalid");


    }
}


