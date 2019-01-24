package com.prestashop.tests.smoke_tests;

import com.prestashop.pages.PrestaShopHomePage;
import com.prestashop.pages.ProductController;
import com.prestashop.utilities.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Product extends Base {

    private WebElement product;

    @Test
    public void nameAndPrice(){
        PrestaShopHomePage hp=new PrestaShopHomePage();
        ProductController pc=new ProductController();
        hp.open();
        product =hp.pickProduct("Blouse");
        WebElement price=hp.pickProductPrice("Blouse");
        String productPriceAtHome=price.getText();
        String productNameAtHome= product.getText();
        product.click();

        String pcPriceAtController=pc.ProductPrice.getText();
        String pcTitleAtController=pc.contproductTitle("Blouse").getText();

        Assert.assertEquals(productNameAtHome,pcTitleAtController);
        Assert.assertEquals(productPriceAtHome,pcPriceAtController);
    }
    @Test

    public void details() {
        PrestaShopHomePage hp=new PrestaShopHomePage();
        ProductController pc=new ProductController();
        hp.open();
        product = hp.pickProduct("Blouse");
        product.click();
        String quantity = pc.quantity.getAttribute("value");

        Select sizes = new Select(pc.size);

        String actualSize = sizes.getFirstSelectedOption().getText();

        List<WebElement> sizeList = driver.findElements(By.id("group_1"));

        String actualSizeOptions = "";
        for (int i = 0; i < sizeList.size(); i++) {
            if (i != sizeList.size() - 1) {
                actualSizeOptions += sizeList.get(i).getText() + ",";
            } else {
                actualSizeOptions += sizeList.get(i).getText();
            }

        }

        Assert.assertEquals(quantity,"1");
        Assert.assertEquals(actualSize,"S");
        Assert.assertEquals(actualSizeOptions,"S\nM\nL");
    }

    @Test
    public void addToCard(){
        PrestaShopHomePage hp=new PrestaShopHomePage();
        ProductController pc=new ProductController();
        hp.open();
        product = hp.pickProduct("Blouse");
        product.click();
        pc.addToCardBt.click();
        pc.layerConfirmationText.click();

        Assert.assertEquals(pc.layerConfirmationText.getText(),"Product successfully added to your shopping cart");
        Assert.assertEquals(pc.layerProductQt.getText(),"1");

        String actualSize=pc.layerColorAndSize.getText();
        char actualSizeChar=actualSize.charAt(actualSize.length()-1);
        Assert.assertEquals(actualSizeChar,'S');

    }

}
