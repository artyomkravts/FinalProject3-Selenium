package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By BUNS_TAB = By.xpath("//span[contains(text(), \"Булки\")]");

}
