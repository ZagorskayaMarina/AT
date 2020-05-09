import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class OsloTests {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Java\\chromwebdriver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.navigate().to("https://booking.com/");
        WebElement el = driver.findElement(By.cssSelector(".c-autocomplete__input"));
        Actions builder = new Actions(driver);
        builder.click(el).sendKeys("Осло").click().perform();

        WebElement date = driver.findElement(By.xpath("//*[@id='frm']//descendant::div[@class='xp__dates xp__group']"));
        builder.click(date).perform();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date oneDay = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date twoDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusOneDay = dateFormat.format(oneDay);
        String datePlusTwoDays = dateFormat.format(twoDays);
        WebElement dateFrom=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusOneDay)));
        builder.click(dateFrom).perform();
        WebElement dateTo=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusTwoDays)));
        builder.click(dateTo).perform();

        WebElement search = driver.findElement(By.xpath("//*[contains(@class, 'sb-searchbox__button')]"));
        builder.click(search).perform();

        //*[contains(@class, 'filter_label')]
        // why I can't find element by Xpath //*div[@id='filter_price'], but I can find by Xpath //*[@id='filter_price']
        Thread.sleep(2000);



        WebElement threeStars = driver.findElement(By.xpath("//*[@id='filter_class']//*[contains(@data-id, 'class-3')]"));
        builder.click(threeStars).perform();

        WebElement fourStars = driver.findElement(By.xpath("//*[@id='filter_class']//*[contains(@data-id, 'class-4')]"));
        builder.click(fourStars).perform();
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//*[@data-hotelid][10]"));
        TimeUnit.SECONDS.sleep(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
        builder.moveToElement(driver.findElement(By.xpath("//*[@data-hotelid][10]//*[contains(@class,'address_line')]/a"))).build().perform();
        element = driver.findElement(By.xpath("//*[@data-hotelid][10]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", element);
        element = driver.findElement(By.xpath("//*[@data-hotelid][10]//h3/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", element);

        String textColor = element.getAttribute("style");
        Assert.assertEquals("color: red;", textColor);
        driver.quit();
    }
}