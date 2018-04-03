package com.mazum.utilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    public static WebDriver Driver;
    private static boolean isMobile;

    public static void CreateNewDriverInstance(String browser, String gridUrl) throws MalformedURLException {
        DesiredCapabilities capabilities;
        switch (browser.toLowerCase()) {
            case "ie":
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                ieOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
                ieOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                if (gridUrl.isEmpty()) {
                    Driver = new InternetExplorerDriver(ieOptions);
                } else {
                    Driver = new RemoteWebDriver(new URL(gridUrl), ieOptions);
                }
                break;
            case "firefox":
                if (gridUrl.isEmpty()) {
                    Driver = new FirefoxDriver();
                } else {
                    Driver = new RemoteWebDriver(new URL(gridUrl), DesiredCapabilities.firefox());
                }
                break;
            case "chrome":
                break;
        }
    }
}
