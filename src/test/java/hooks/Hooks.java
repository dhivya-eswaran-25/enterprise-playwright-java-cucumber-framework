package hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(true)
                .setChannel("chrome"));
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080));
        page = context.newPage();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = page.screenshot();
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        context.close();
        browser.close();
        playwright.close();
    }
}
