package com.q3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class q3 {

    public static void main(String[] args) throws InterruptedException {
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

        driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();

        // 1.
        String message = "Your Account";
        String actualMessage = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[1]/h1")).getText();
        if (message.equals(actualMessage)) {
            System.out.println("TEST CASE 1: Passed");
        } else {
            System.out.println("TEST CASE 1: Failed");
        }
        Thread.sleep(500);

        // 2.
        driver.get("https://www.amazon.in/gp/css/order-history?ref_=nav_AccountFlyout_orders");
        String actualOrderMessage = driver.findElement(By.xpath("//*[@id=\"a-page\"]/section/div/div[2]/div[1]/h1"))
                .getText();
        if (actualOrderMessage.equals("Your Orders")) {
            System.out.println("TEST CASE 2: Passed");
        } else {
            System.out.println("TEST CASE 2: Failed");
        }

        // 3.
        String orders = driver.findElement(By.xpath("//*[@id=\"a-page\"]/section/div/div[4]/form/label")).getText();
        System.out.println(orders);
        driver.findElement(By.xpath("//*[@id=\"a-page\"]/section/div/div[3]/ul/li[4]/a")).click();
        String cancelled = driver.findElement(By.xpath("//*[@id=\"ordersContainer\"]/div[1]/div")).getText();
        System.out.println(cancelled);
        Thread.sleep(500);
        if (orders.equals(cancelled)) {
            System.out.println("TEST CASE 3: Passed");
        } else {
            System.out.println("TEST CASE 3: Failed");
        }

        // 4.
        driver.get("https://www.amazon.in/gp/css/order-history?ref_=nav_AccountFlyout_orders");
        Thread.sleep(500);
        driver.findElement(By.xpath(
                "/html/body/div[1]/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div/div[1]/div/div/div[1]/a"))
                .click();
        Thread.sleep(500);
        driver.findElement(By.xpath(
                "/html/body/div[1]/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[1]/div/div[1]/div/div/div/div"))
                .click();
        Thread.sleep(500);
        if (driver.findElement(By.xpath(
                "/html/body/div[1]/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[1]/div/div[1]/div/div/div/div"))
                .getText().equals("Cancel items")) {
            System.out.println("TEST CASE 4: Passed");
        } else {
            System.out.println("TEST CASE 4: Failed");
        }

        //5.
    }

}