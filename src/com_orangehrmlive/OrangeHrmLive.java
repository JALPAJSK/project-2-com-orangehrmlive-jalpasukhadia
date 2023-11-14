package com_orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class OrangeHrmLive {

    //Setup Chrome browser
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        //Multiple browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
        //Open URL
        driver.get(baseUrl);
        //Maximize the window
        driver.manage().window().maximize();
        //Timeout for hold the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Print the title of the page.
        System.out.println(driver.getTitle());
        //Print the current url.
        System.out.println(driver.getCurrentUrl());
        //Print the page source.
        System.out.println(driver.getPageSource());
        //Click on ‘Forgot your password?’ link.
        WebElement pass = driver.findElement(By.className("orangehrm-login-forgot-header"));
        pass.click();
        //Print the current url.
        System.out.println("This is the current URL: " + driver.getCurrentUrl());
        //Navigate back to the login page.
        driver.navigate().to(baseUrl);
        //Refresh the page.
        driver.navigate().refresh();
        //Enter the email to email field.
        driver.findElement(By.name("username")).sendKeys("Admin");
        //Enter the password to password field.
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Click on Login Button.
        WebElement login = driver.findElement(By.className("orangehrm-login-button"));
        login.click();
        //Close the browser.
        driver.quit();

    }
}
