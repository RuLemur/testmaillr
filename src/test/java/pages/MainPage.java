package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.Account;
import util.WebElementUtil;

public class MainPage extends Page{

    public MainPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "mailbox:login")
    WebElement login;

    @FindBy(id = "mailbox:domain")
    WebElement domain;

    @FindBy(id = "mailbox:password")
    WebElement pass;

    @FindBy(xpath = "//label[@id = 'mailbox:submit']/input")
    WebElement enterBtn;

    public void login(Account account){
        WebElementUtil.sendKeys(login, account.getLogin());
        WebElementUtil.sendKeys(domain, account.getDomain());
        WebElementUtil.sendKeys(pass, account.getPassword());
        WebElementUtil.click(enterBtn);
        waitForPageLoaded();
    }


}
