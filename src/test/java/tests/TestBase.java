package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void setupEnvironment() {
//        Configuration.browserSize = "1920x1080";
//        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";


        Configuration.remote = System.setProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.browser = System.setProperty("browser", "chrome");
        Configuration.browserVersion = System.setProperty("browserVersion", "142.0");
        Configuration.browserSize = System.setProperty("browserSize", "1920x1080");


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterAll
    static void addAttachments () {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
