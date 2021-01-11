package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.StaleElementReferenceException;

public abstract class Page {
    protected WebDriver driver;
    protected Actions actions;
    protected static final int TIMEOUT = 10;

    protected Page(WebDriver driver){
        this.driver = driver;
        this.actions=new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    protected static ExpectedCondition<Boolean> jQueryAJAXCompleted(){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver){
                return (Boolean) ((JavascriptExecutor)
                        driver).executeScript("return (window.jQuery != null) && (jQuery.active == 0);");
            }
        };
    }


}