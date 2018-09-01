package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MailPage;
import pages.MailsPage;
import pages.MainPage;
import util.AccountReader;

public class MainTest {

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_mac");
        driver = new ChromeDriver();
        driver.get("http://mail.ru");

    }

    @Test
    public void testMailOpen(){
        String theme = "Тема тестового письма";
        String body = "Тело тестового письма";
        String sender = "Альберт Шустрый <shustryj.albert@bk.ru>";

        MainPage mainPage = new MainPage(driver);
        mainPage.waitForPageLoaded();
        mainPage.login(AccountReader.readAccounts().get(0));

        MailsPage mailsPage = new MailsPage(driver);
        mailsPage.findLetter(theme);

        MailPage mailPage = new MailPage(driver);
        mailPage.checkLetterData(theme, body, sender);

        mailPage.logOff();
    }

    @After
    public void tear_down(){
        driver.quit();
    }
}
