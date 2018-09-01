package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.WebElementUtil;

import java.util.List;

public class MailPage extends Page {

    public MailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "b-letter__head__subj__text")
    WebElement theme;

    @FindBy(xpath = "//div[@class='b-letter__body']//div[starts-with(@class, 'class')]")
    WebElement body;

    @FindBy(xpath = "//div[@data-mnemo='from']/span")
    List<WebElement> sender;

    @FindBy(xpath = "//a[text()='выход']")
    WebElement exitBtn;


    public void checkLetterData(String themeExcp, String bodyExcp, String senderExcp) {
        Assert.assertEquals("Тема письма не верная", themeExcp, WebElementUtil.getText(theme));
        Assert.assertEquals("Тело письма не верное", bodyExcp, WebElementUtil.getText(body));
        Assert.assertEquals("Отправить письма не верный", senderExcp, WebElementUtil.getText(sender.get(0)));
    }

    public void logOff(){
        WebElementUtil.click(exitBtn);
        waitForPageLoaded();
    }

}
