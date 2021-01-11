package page;

import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.ProductCreator;

public class CatalogPage extends Page {

    public CatalogPage(WebDriver driver) {

        super(driver);
    }

    public CardPage choiseProduct(String product)
    {
        Product prod= new ProductCreator().getProduct(product);
        System.out.println(prod.getName());
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(prod.getName()))).click();
        return new CardPage(driver,product);

    }
}

