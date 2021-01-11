package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MainPage extends Page{

    private static final String MAIN_PAGE_URL = "https://samsung.com/ru/";

    @FindBy(xpath = "//span[@class='gnb__depth1-link-text' and text()='Для компьютера']")
    private WebElement computerButton;

    @FindBy(xpath = "//li/a[@class='gnb__search-btn gnb__search-btn-js']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@class='gnb-search__input']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='gnb__depth1-link-text' and text()='Интернет-магазин']")
    private WebElement shopButton;

    @FindBy(xpath = "//a[@class='gnb__depth2-link' and @data-engname='computing:memory and storage']")
   private WebElement memoryButton;

    @FindBy(xpath = "//a[@class='gnb__depth3-link' and @an-la='computing:memory and storage:ssd drives']")
   private WebElement ssdButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }
    public MainPage openURL()
    {
        System.out.print("1");
        this.driver.get(MAIN_PAGE_URL);
        System.out.print("1");
        new WebDriverWait(driver, TIMEOUT)
                .until(jQueryAJAXCompleted());
        return this;
    }

    public CatalogPage needSSD(){
        new WebDriverWait(driver, TIMEOUT)
                .until(jQueryAJAXCompleted());
        actions.moveToElement(computerButton).build().perform();
        new WebDriverWait(driver, TIMEOUT)
                .until(jQueryAJAXCompleted());
        actions.moveToElement(memoryButton).build().perform();
        new WebDriverWait(driver, TIMEOUT)
                .until(jQueryAJAXCompleted());
        ssdButton.click();
        return new CatalogPage(driver);

    }




}
