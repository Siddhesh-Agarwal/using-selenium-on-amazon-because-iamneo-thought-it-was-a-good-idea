package com.q2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

// 1. Verify that the user can search any product on website and the corresponding search product details needs to be displayed
// 2. Print minimum 5 Names of the products displayed on the webpage
// 3. Verify that the user can filter the search results by category, price, and other parameters
public class q2 {
    public static void main(String args[]) throws InterruptedException {
        String url = "https://www.amazon.in/";
        String username = "username";
        String password = "password";

        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open Amazon
        driver.get(url);
        driver.manage().window().maximize();
        // Login
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        driver.findElement(By.id("ap_email")).sendKeys(username);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
        Thread.sleep(500);

        // 1.
        String search = "Pokemon Cards";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search);
        driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("Search results for " + search + " displayed.");
        Thread.sleep(2000);

        // 2.
        System.out.println("5 Names of the products displayed on the webpage:");
        for (int i = 1; i < 5; i++) {
            String xpath = "//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[" + (i + 2)
                    + "]/div/div/div/div/div/div/div[2]/div[1]/h2/a/span";
            System.out.println(i + ") " + driver.findElement(By.xpath(xpath)).getText());
        }

        // 3.
        // Filter by category
        driver.findElement(By.id("a-autoid-0-announce")).click();
        driver.findElement(By.id("s-result-sort-select_1")).click();
        Thread.sleep(500);
        System.out.println("Filter has been applied.");
    }
}
