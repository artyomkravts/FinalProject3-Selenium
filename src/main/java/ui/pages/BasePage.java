package ui.pages;

import utils.ConfigReader;

public class BasePage {
    protected static final String BASE_URI = ConfigReader.getProperty("base.uri");

    public String getBASE_URI() {
        return BASE_URI;
    }
}
