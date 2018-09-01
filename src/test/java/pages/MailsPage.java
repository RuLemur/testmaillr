package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WebElementUtil;

import java.util.List;

public class MailsPage extends Page {

    public MailsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(name = "q_query")
    WebElement queryField;

    @FindBy(name = "search")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@data-bem='b-datalist__item']//span[@class='search_tick']")
    List<WebElement> findedMailsTitles;



    public void findLetter(String query) {
        WebElementUtil.sendKeys(queryField, query);
        WebElementUtil.click(searchBtn);
        waitForPageLoaded();

        Assert.assertTrue("Письмо не найдено", findedMailsTitles.size() >= 1);

        WebElementUtil.click(findedMailsTitles.get(0));

        waitForPageLoaded();
    }


}
