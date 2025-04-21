package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RasrochkaMts {
    private WebDriver driver;

    public RasrochkaMts(WebDriver driver) {
        this.driver = driver;
    }

    public void rassrochka() {
        By nomerLocator = By.xpath("//*[@id='score-instalment']");
        By summaLocator = By.xpath("//*[@id='instalment-sum']");
        By emailLocator = By.xpath("//*[@id='instalment-email']");
        WebElement nomer = driver.findElement(nomerLocator);
        System.out.println(nomer.getText());
        WebElement summa = driver.findElement(summaLocator);
        System.out.println(summa.getText());
        WebElement email = driver.findElement(emailLocator);
        System.out.println(email.getText());
    }
}