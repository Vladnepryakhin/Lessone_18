package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class AboutMts {
    private WebDriver driver;

    public AboutMts(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAbout() throws InterruptedException {
        By clickLocator = By.xpath("//*[text()='Подробнее о сервисе']");
        WebElement element = driver.findElement(clickLocator);
        element.click();
        Thread.sleep(5000);
    }
}