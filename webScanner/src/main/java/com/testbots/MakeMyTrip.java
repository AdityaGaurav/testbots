package com.testbots;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class MakeMyTrip {

    public static void main(String[] args) throws InterruptedException {
        String url="";
        JavascriptExecutor executor;
        System.setProperty("webdriver.chrome.driver", "E:\\infinity\\gitrepo\\testbots\\webScanner\\src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://flights.makemytrip.com/makemytrip/search/O/O/E/1/0/0/S/V0/LKO_HYD_10-04-2018?contains=false&remove=");
        Thread.sleep(10000);
        driver.getTitle();
        driver.getWindowHandle();
        String htmlPage = driver.getPageSource();
//        System.out.println(htmlPage);

        List<WebElement> htmlElements = driver.findElements(By.tagName("span"));
        for(WebElement e : htmlElements){
            System.out.println(e);
            System.out.println("================================================================================");
        }

//        Document dom = Jsoup.parse(htmlPage);
//        Elements elements = dom.getElementsByTag("span");
//        for(Element e: elements){
//            System.out.println(e);
//        }
    }
}
