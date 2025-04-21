package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PayMts {
    private WebDriver driver;

    public PayMts(WebDriver driver) {
        this.driver = driver;
    }

    public String pay() {
        By payLocator = By.className("pay__partners");
        WebElement pay = driver.findElement(payLocator);
        return pay.getText();
    }
}