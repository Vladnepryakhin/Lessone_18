package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageMts {
    private WebDriver driver;

    public PageMts(WebDriver driver) {
        this.driver = driver;
    }

    public String info() {
        By onlineLocator = By.xpath("//*[@class='pay']//h2");
        String actualText = driver.findElement(onlineLocator).getText();
        Assert.assertEquals(actualText, "Онлайн пополнение\nбез комиссии",
                "Текст элемента не соответствует ожидаемому");
        return actualText;
    }
}