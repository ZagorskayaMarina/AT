import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SeleniumTest2 {
    static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) {
        driver.navigate().to("https://booking.com/");
        WebElement el = driver.findElement(By.name("ss"));
        el.sendKeys("Париж");
        driver.manage().window().maximize();
        WebElement ul = driver.findElement(By.xpath("//*[@id='frm']//descendant::div[@class='xp__dates xp__group']"));
        ul.click();
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
        //
        WebElement adults = driver.findElement(By.xpath("//*[@id='xp__guests__toggle']"));
        adults.click();

        /*WebElement plusAdult = driver.findElement(By.xpath("//*[@id='xp__guests__inputs-container']/div/div/div[1]/div/" +
                "div[2]/button[2]/span"));

        plusAdult.click();
        plusAdult.click();

        WebElement plusRoom = driver.findElement(By.xpath("//*[@id='xp__guests__inputs-container']/div/div/div[3]/div/" +
                "div[2]/button[2]/span"));

        plusRoom.click();

        WebElement search = driver.findElement(By.xpath("//*[@id='frm']/div[1]/div[4]/div[2]/button/span[1]"));
        search.submit();

        WebElement maxPrice = driver.findElement(By.xpath("//*[@id='filter_price']/div[2]/a[5]/label/div"));
        maxPrice.click();

        WebElement expensiveHotels = driver.findElement(By.xpath("//*[@id='filter_price']/ul/li[3]/a"));
        expensiveHotels.click();

        String export = expensiveHotels.getText();
        System.out.println();*/
        
    }
}
