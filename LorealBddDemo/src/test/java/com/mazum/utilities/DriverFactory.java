package com.mazum.utilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    public static WebDriver Driver;
    private static boolean isMobile;

    public static void CreateNewDriverInstance(String browser, String gridUrl) {
        DesiredCapabilities capabilities;
        switch (browser.toLowerCase()) {
            case "ie":
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                break;
            case "firefox":
                break;
            case "chrome":
                break;
        }
    }
}
