package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class snapDealHooks {

	//Store the initialized WebDriver instance in a thread-safe manner (e.g., using ThreadLocal) so that each scenario or thread has its own independent browser instance, preventing conflicts during parallel execution.
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Before
    public void setup(Scenario scenario) {
        String browser = "chrome"; // Default browser

        if (scenario.getSourceTagNames().contains("@firefox")) {
            browser = "firefox";
        } else if (scenario.getSourceTagNames().contains("@edge")) {
            browser = "edge";
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            // Add cases for other browsers (Edge, Safari, etc.)
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @After
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
