package com.prestashop.pages;

import com.prestashop.utilities.ConfigReader;
import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductController {

    public ProductController()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="our_price_display")
    public WebElement ProductPrice;


    @FindBy(xpath="//input[@id='quantity_wanted']")
    public WebElement quantity;

    @FindBy(id="group_1")
    public WebElement size;

    @FindBy(xpath = "//p[@id='add_to_cart']//span")
    public WebElement addToCardBt ;

    @FindBy(xpath = "//i[@class='icon-ok']/..")
    public WebElement layerConfirmationText ;

    @FindBy(id = "layer_cart_product_quantity")
    public WebElement layerProductQt ;

    @FindBy(id = "layer_cart_product_attributes")
    public WebElement layerColorAndSize ;


    @FindBy(xpath = "//span[@title='Close window']")
    public WebElement closeCheckout ;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    public WebElement hoverOverCart ;

    @FindBy(xpath = "//div[@class='cart-prices-line last-line']/span")
    public WebElement hoverOverCartPrice ;






    public WebElement contproductTitle(String productName){
        String xpath="//h1[.='"+productName+"']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }




    //option[@title='S']




}
