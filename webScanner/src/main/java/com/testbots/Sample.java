package com.testbots;

import org.jsoup.nodes.Element;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Objects;


public class Sample {
    public static void main(String[] args) throws IOException, InterruptedException {
//        WebDriver driver;
//        String URL = "https://www.facebook.com/";
//        Document dom = Jsoup.connect(URL).get();
//        Elements elements = dom.select("input[type=text]");
//        for (Element element : elements) {
//            System.out.println(element);
//        }
//
//        String element = "<input type=\"email\" class=\"inputtext\" name=\"email\" id=\"email\" tabindex=\"1\" data-testid=\"royal_email\">";
//        String jsScript = "var doms = new DOMParser();" +
//                "var doc = doms.parseFromString("+element+", \"text/html\");" +
//                "doc.value='"+ getMEString()+"';";
        openUrl();
    }

    public static String getMEString() {
        return "Testing Data";
    }

    public void getElement(Element element) {
        Objects.requireNonNull(element);
        element.getElementsByAttributeValue("type", "text");
    }

    public static void openUrl() throws InterruptedException {
        JavascriptExecutor executor;
        System.setProperty("webdriver.chrome.driver", "E:\\Project\\ProjectsToUpload\\Selenium\\TestBots\\src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.facebook.com");
        Thread.sleep(7000);
        executor = (JavascriptExecutor) driver;
        String element = "<input type=\"email\" class=\"inputtext\" name=\"email\" id=\"email\" tabindex=\"1\" data-testid=\"royal_email\">";
        String subString = element.substring(1, element.length() - 1);
        String jsScript = "var inputsplit='" + subString + "'.split(' ');" +
                "var y = inputsplit.reduce(function(acc, red) { return acc += `[${red}]`});" +
                "document.querySelector(y).value='" + getMEString() + "';";
        executor.executeScript(jsScript);
    }

//    static void getAttributeOfElement(String input) {
//        Objects.requireNonNull(input);
//        String[] attributes = input.substring(1, input.length()).split(" ");
//        String type, getInputType,getAttributeValue;
//        String tagName = attributes[0];
//        if (isInputTag(tagName)) {
//            for (int i = 1; i < attributes.length; i++) {
//                String attribute = attributes[i];
//                if (attribute.contains("type")) {
//                    type = attribute.split("=")[1];
//                    getInputType = typeOfInput(attribute);
//                } else if (attribute.contains("id")) {
//                    getAttributeValue = attribute.split("=")[1];
//                } else if(attribute.contains("class")){
//
//                }
//            }
//
//        }

    boolean isIDAttribute(String attr) {
        return attr.equalsIgnoreCase("id");
    }

    boolean isNameAttribute(String attr) {
        return attr.equalsIgnoreCase("name");
    }

    boolean isClassAttribute(String attr) {
        return attr.equalsIgnoreCase("class");
    }

    static boolean isInputTag(String input) {
        return input.equalsIgnoreCase("input");
    }

    boolean isTypeAttribute(String type) {
        return type.equalsIgnoreCase("type");
    }

    static String typeOfInput(String type) {
        String result;
        switch (type) {
            case "text":
                result = "text";
                break;
            case "button":
                result = "button";
                break;
            case "checkbox":
                result = "checkbox";
                break;
            case "radio":
                result = "radio";
                break;
            default:
                result = null;
                System.out.println("Not mentioned. Please add the tag");
        }
        return result;
    }
}
