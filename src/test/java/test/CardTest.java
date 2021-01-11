package test;


import org.junit.Assert;
import org.junit.Test;


import page.*;

public class CardTest extends Common{
    @Test
    public void addProductToCard(){
        String product ="PRO";
        String expected=new MainPage(driver)
                .openURL().needSSD().choiseProduct(product).confirmAndCheckCard();
       Assert.assertTrue(expected.contains(product) );
    }


}
