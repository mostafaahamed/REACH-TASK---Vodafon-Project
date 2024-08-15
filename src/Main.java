
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WishlistTest {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://vodafone-website-url.com/login");

            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            username.sendKeys("test_user");
            password.sendKeys("password123");
            password.submit();

            Thread.sleep(3000);

            driver.get("https://vodafone-website-url.com/product/123");

            Thread.sleep(3000);

            WebElement addToWishlistButton = driver.findElement(By.id("add-to-wishlist"));
            addToWishlistButton.click();

            Thread.sleep(3000);

            driver.get("https://vodafone-website-url.com/account/wishlist");

            Thread.sleep(3000);

            List<WebElement> wishlistItems = driver.findElements(By.className("wishlist-item"));

            if (wishlistItems.size() > 0) {
                System.out.println("Test Passed: Item was successfully added to the wishlist.");
            } else {
                System.out.println("Test Failed: Item was not added to the wishlist.");
            }

        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
