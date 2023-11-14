package comsaucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

/**
 * Project-4 - ProjectName : com-saucedemo
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */

public class SauceDemo {
    static String browser = "Chrome";
    static String baseUrl = " https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // 1. Setup Multiple browser.
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Internet Explorer")) {
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Wrong web browser");
        }

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Implicitly wait time
        driver.manage().window().maximize(); // Maximise the window

        // 2. Open URL.
        driver.get(baseUrl);

        // 3. Print the title of the page.
        System.out.println("The title of the page is : " + driver.getTitle());

        // 4. Print the current url.
        System.out.println("Current url is : " + driver.getCurrentUrl());

        // 5. Print the page source.
        System.out.println("The page source is : " + driver.getPageSource());

        // 6. Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("standard_user");

        // 7. Enter the password to password field.
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("secret_sauce");

        // 8. Click on Login Button.
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
        Thread.sleep(3000);

        // 9. Print the current url.
        System.out.println("The current url is : " + driver.getCurrentUrl());

        // 10. Navigate to baseUrl
        driver.navigate().to(baseUrl);

        // 11. Refresh the page.
        driver.navigate().refresh();

        // 12. Close the browser.
        driver.quit();

    }
}
