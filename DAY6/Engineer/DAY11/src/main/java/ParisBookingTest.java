import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

public class ParisBookingTest {
    static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {
        driver.navigate().to("https://booking.com/");
        WebElement el = driver.findElement(By.cssSelector(".c-autocomplete__input"));
        el.sendKeys("Париж");
        driver.manage().window().maximize();
        WebElement city = driver.findElement(By.xpath("//*[@id='frm']//descendant::div[@class='xp__dates xp__group']"));
        city.click();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date tenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays = dateFormat.format(threeDays);
        String datePlusTenDays = dateFormat.format(tenDays);
        WebElement dateFrom=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusThreeDays)));
        dateFrom.click();
        WebElement dateTo=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusTenDays)));
        dateTo.click();
        WebElement adults = driver.findElement(By.xpath("//*[contains(@for, 'xp__guests__input')]"));
        adults.click();
// //*[contains(@class,'xp__guests__count')]/span
        //
        WebElement plusAdult = driver.findElement(By.xpath("//*[contains(@aria-describedby, 'group_adults_desc')][2]"));

        plusAdult.click();
        plusAdult.click();

        WebElement plusRoom = driver.findElement(By.xpath("//*[contains(@aria-describedby, 'no_rooms_desc')][2]"));

        plusRoom.click();

        WebElement search = driver.findElement(By.xpath("//*[contains(@class, 'sb-searchbox__button')]"));
        search.click();

        //*[contains(@class, 'filter_label')]
        // why I can't find element by Xpath //*div[@id='filter_price'], but I can find by Xpath //*[@id='filter_price']
        Thread.sleep(2000);

        WebElement maxPriceCategory = driver.findElement(By.xpath("//*[@id='filter_price']//a[5]/label/div"));
        maxPriceCategory.click();

        String priceFromCategory = maxPriceCategory.getText();
        System.out.println(priceFromCategory);

        priceFromCategory = priceFromCategory.replaceAll("[^0-9]+","");
        int price = Integer.parseInt(priceFromCategory);

        WebElement sortData = driver.findElement(By.xpath("//*[contains(@class,'sort_category   sort_price')]/a"));
        sortData.click();

        Thread.sleep(4000);

        WebElement betterPriceHotel = driver.findElement(By.xpath("//*[contains(@class,'bui-price-display__value')][1]"));

        String export = betterPriceHotel.getText();
        System.out.println(export);

        export = export.replaceAll("[^0-9]+","");
        int priceDay = Integer.parseInt(export)/7;
        System.out.println(priceDay);
        Assert.assertTrue(priceDay >= price);
        //I can't get error message if test was failed
        //assert priceDay >= price: "No way";

        driver.close();

    }
}