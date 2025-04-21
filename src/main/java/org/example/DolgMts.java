package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DolgMts {
    private WebDriver driver;

    public DolgMts(WebDriver driver) {
        this.driver = driver;
    }
    public void dolg(){
        By nomerLocator = By.xpath("//*[@id='score-arrears']");
        By summaLocator = By.xpath("//*[@id='arrears-sum']");
        By emailLocator = By.xpath("//*[@id='arrears-email']");
        WebElement nomer = driver.findElement(nomerLocator);
        System.out.println(nomer.getText());
        WebElement summa = driver.findElement(summaLocator);
        System.out.println(summa.getText());
        WebElement email = driver.findElement(emailLocator);
        System.out.println(email.getText());
    }
}