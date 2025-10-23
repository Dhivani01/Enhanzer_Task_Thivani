package com.TestCases;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Base.BaseTest;
import com.PageObjects.FormPageObjects;

public class EmailValidations extends BaseTest {

    @Test
    public static void email() throws InterruptedException {

        PageFactory.initElements(driver, FormPageObjects.class);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(FormPageObjects.email));
      
        FormPageObjects.email.sendKeys("abc"); // invalid email
        FormPageObjects.email.sendKeys(Keys.ENTER);
      
        Thread.sleep(1000);
        String borderColor = FormPageObjects.email.getCssValue("border-color");
         
        Assert.assertTrue(
                borderColor.equals("rgb(220, 53, 69)") || borderColor.contains("red"),
                "Expected red border for invalid email, but got: " + borderColor);

        System.out.println("Invalid email validated correctly!");
    }
}
