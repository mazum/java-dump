package com.mazum.utilities;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;

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
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--use-gl=desktop");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-infobars");
                //options.setExperimentalOption("credentials_enable_service", false);
                capabilities=new DesiredCapabilities(options);
                capabilities.setCapability(CapabilityType.PLATFORM_NAME, "WINDOWS");
                capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
                if (gridUrl.isEmpty()) {
                    Driver = new ChromeDriver(ChromeDriverService.createDefaultService(), options);
                } else {
                    Driver = new RemoteWebDriver(new URL(gridUrl), capabilities);
                }
                break;
        }
    }
}
