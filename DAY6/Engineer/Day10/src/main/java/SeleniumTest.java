import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) {
        //String pathToDriver = "C:\\Users\\user\\Java\\chromwebdriver";
        //System.setProperty("webdriver.chrome.driver", "C:/Users/user/Java/chromwebdriver");
        //driver.get("https://www.selenium.dev/");
        driver.get("http://google.com");
        //String title = driver.getTitle();
        //String url = driver.getCurrentUrl();
        //System.out.println(title + " " + url);
        //driver.close();
        //driver.quit();
        //driver.navigate().to("http://yandex.ru");
        //driver.navigate().back();
        //driver.navigate().refresh();
        WebElement el = driver.findElement(By.name("q"));
        el.sendKeys("Погода минск");
        WebElement button = driver.findElement(By.xpath("//style/following-sibling::center/input[@value='Поиск в Google']"));
        button.submit();
        //WebElement el = driver.findElement(By.name("q"));
    }

}
