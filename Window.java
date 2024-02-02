
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Window {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMEN\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();


        driver.get("https://the-internet.herokuapp.com/windows");


        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();


        String mainWindowHandle = driver.getWindowHandle();
        for(String handle : driver.getWindowHandles()) {
            if(!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }


        WebElement h3Element = driver.findElement(By.tagName("h3"));
        String h3Text = h3Element.getText();
        if(h3Text.equals("New Window")) {
            System.out.println("Текст в теге <h3> равен \"New Window\"");
        } else {
            System.out.println("Текст в теге <h3> не равен \"New Window\"");
        }


        driver.close();
        driver.switchTo().window(mainWindowHandle);
        driver.quit();
    }

}
