import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OplataMts {
    private WebDriver driver;

    public OplataMts(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNumber(String number, String sum, String email) throws InterruptedException {
        By nomerLocator = By.xpath("//*[@class='phone']");
        By summaLocator = By.xpath("//*[@id='connection-sum']");
        By pochtaLocator = By.xpath("//*[@id='connection-email']");
        By nextLocator = By.xpath("//*[text()='Продолжить']");
        By iframeLocator = By.xpath("//iframe[@class='bepaid-iframe']");
        By info1Locator = By.xpath("//*[@class='pay-description__cost']");
        By info2Locator = By.xpath("//*[@id='cc-number']");
        By info3Locator = By.xpath("//input[@placeholder='MM / YY']");
        By info4Locator = By.xpath("//*[text()='Имя держателя (как на карте)']");
        By info5Locator = By.xpath("//*[@name='verification_value']");
        WebElement nomer = driver.findElement(nomerLocator);
        nomer.sendKeys(number);
        WebElement summa = driver.findElement(summaLocator);
        summa.sendKeys(sum);
        WebElement pohta = driver.findElement(pochtaLocator);
        pohta.sendKeys(email);
        WebElement next = driver.findElement(nextLocator);
        next.click();
        Thread.sleep(5000);
        WebElement frameElement = driver.findElement(iframeLocator);
        driver.switchTo().frame(frameElement);
        WebElement info1 = driver.findElement(info1Locator);
        System.out.println(info1.getText());
        WebElement info2 = driver.findElement(info2Locator);
        System.out.println(info2.getText());
        WebElement info3 = driver.findElement(info3Locator);
        System.out.println(info3.getText());
        WebElement info4 = driver.findElement(info4Locator);
        System.out.println(info4.getText());
        WebElement info5 = driver.findElement(info5Locator);
        System.out.println(info5.getText());
    }
}