package com.mazum.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    public static WebDriver Driver;
    private static boolean isMobile;

    public static void CreateNewDriverInstance(String browser, String gridUrl) {
        DesiredCapabilities capabilities;
        switch (browser.toLowerCase()) {
            case "ie":
                break;
            case "firefox":
                break;
            case "chrome":
                break;
        }
    }
}
