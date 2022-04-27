package com.guru99.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.guru99.utilities.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    static ExtentReports extentReports;
    WebDriver driver;
    static String browserName;
    static String env;

    public WebDriver openApplication() {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        if (env.equalsIgnoreCase("QA"))
            driver.get(Constants.URL_QA);
        else
            driver.get(Constants.URL_UAT);

        return driver;
    }

    @BeforeSuite(alwaysRun = true)
    public void extentReportsSetup() {
        extentReports = new ExtentReports();
        System.out.println(extentReports);
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("Report.html");
        extentReports.attachReporter(extentSparkReporter);
    }

    @Parameters({"browserName", "env"})
    @BeforeTest(alwaysRun = true)
    public void getEnvironment(String browserName, String env) {
        this.browserName = browserName;
        this.env = env;
    }

    @AfterSuite(alwaysRun = true)
    public void flushExtentReport() {
        extentReports.flush();// mandatory
    }

    @AfterMethod(alwaysRun = true)
    public void closeApplication() {
        driver.close();
    }
}
