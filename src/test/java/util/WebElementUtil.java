package util;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

/**
 * Работа с элементами + проверки.
 *
 * Не самый удачный вариант для управления элементами, но попробую такой
 */
public class WebElementUtil {

    public static void click(WebElement el){
        Assert.assertNotNull("Элемент не найден", el);
        el.click();
    }

    public static void sendKeys(WebElement el, String text){
        Assert.assertNotNull("Элемент не найден", el);
        el.sendKeys(text);
    }

    public static String getText(WebElement el){
        Assert.assertNotNull("Элемент не найден", el);
        return el.getText();
    }

}
