import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import io.qameta.allure.model.Status;
import org.example.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.io.ByteArrayInputStream;
import java.time.Duration;

@Epic("Тесты сайта MTS")
@Feature("Основной функционал")
public class TestMts {
    private PageMts pageMts;
    private PayMts payMts;
    private AboutMts aboutMts;
    private OplataMts oplataMts;
    private InternetMts internetMts;
    private RasrochkaMts rasrochkaMts;
    private DolgMts dolgMts;
    private WebDriver driver;

    @BeforeSuite
    @Step("Настройка драйвера")
    public void Init1() {
        WebDriverManager.chromedriver().setup();
        Allure.label("environment", "staging");
        Allure.label("browser", "chrome");
    }

    @BeforeMethod
    @Step("Инициализация теста")
    public void Setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        Allure.addAttachment("Настройки браузера", options.asMap().toString());

        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Принять']")));
            button.click();
            Allure.step("Клик на кнопку 'Принять' выполнен успешно");
        } catch (Exception e) {
            Allure.step("Кнопка 'Принять' не найдена, продолжение без клика", Status.FAILED);
        }

        pageMts = new PageMts(driver);
        payMts = new PayMts(driver);
        oplataMts = new OplataMts(driver);
        internetMts = new InternetMts(driver);
        rasrochkaMts = new RasrochkaMts(driver);
        dolgMts = new DolgMts(driver);
        aboutMts = new AboutMts(driver);
    }

    @AfterMethod
    @Step("Завершение теста")
    public void Teardown() {
        if (driver != null) {
            Allure.addAttachment("Скриншот завершения",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            driver.quit();
        }
    }

    @Test
    @Story("Получение информации о странице")
    @Description("Тест проверяет получение заголовка страницы")
    @Severity(SeverityLevel.TRIVIAL)
    public void testInfo() {
        String title = pageMts.info();
        Allure.step("Получен заголовок страницы: " + title);
        System.out.println(title);
    }

    @Test
    @Story("Оплата услуг")
    @Description("Тест проверяет функционал оплаты")
    @Severity(SeverityLevel.CRITICAL)
    public void testPay() {
        Allure.step("Начало теста оплаты");
        payMts.pay();
        Allure.step("Оплата выполнена успешно");
    }

    @Test
    @Story("Информация о компании")
    @Description("Тест проверяет раздел 'О компании'")
    @Severity(SeverityLevel.NORMAL)
    public void testClickAbout() throws InterruptedException {
        Allure.step("Переход в раздел 'О компании'");
        aboutMts.clickAbout();
        Allure.step("Раздел 'О компании' открыт успешно");
    }

    @Test
    @Story("Оплата по номеру телефона")
    @Description("Тест проверяет оплату по указанному номеру")
    @Severity(SeverityLevel.BLOCKER)
    public void testClickNumber() throws InterruptedException {
        Allure.parameter("Номер телефона", "297777777");
        Allure.parameter("Сумма", "100");
        Allure.parameter("Email", "nv_slm@mail.ru");

        oplataMts.clickNumber("297777777", "100", "nv_slm@mail.ru");
        Allure.step("Оплата по номеру выполнена успешно");
    }

    @Test
    @Story("Домашний интернет")
    @Description("Тест проверяет раздел домашнего интернета")
    @Severity(SeverityLevel.NORMAL)
    public void testHomeInternet() {
        Allure.step("Проверка раздела 'Домашний интернет'");
        internetMts.HomeInternet();
        Allure.step("Раздел 'Домашний интернет' проверен");
    }

    @Test
    @Story("Рассрочка")
    @Description("Тест проверяет функционал рассрочки")
    @Severity(SeverityLevel.NORMAL)
    public void testRassrochka() {
        Allure.step("Проверка раздела 'Рассрочка'");
        rasrochkaMts.rassrochka();
        Allure.step("Раздел 'Рассрочка' проверен");
    }

    @Test
    @Story("Проверка долга")
    @Description("Тест проверяет функционал проверки долга")
    @Severity(SeverityLevel.MINOR)
    public void testDolg() {
        Allure.step("Проверка раздела 'Долги'");
        dolgMts.dolg();
        Allure.step("Раздел 'Долги' проверен");
    }
}
