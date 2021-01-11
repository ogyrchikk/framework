package page;

import model.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.ProductCreator;

public class CardPage  extends Page {
    private String product;

    @FindBy(xpath = "//div/a[@class='cta cta--contained cta--emphasis add-special-tagging js-buy-now tg-add-to-cart']")
    private WebElement addToCardButton;

    @FindBy(xpath = "//h3[@class='name name-no-rtl']")
    private WebElement cardObject;

    protected CardPage(WebDriver driver) {
        super(driver);
    }
    protected CardPage(WebDriver driver,String prod) {
        super(driver);
        this.product=prod;
    }
    public String  confirmAndCheckCard(){
        addToCardButton.click();
        new WebDriverWait(driver, TIMEOUT).until(jQueryAJAXCompleted());

      return cardObject.getText();
    }

}
