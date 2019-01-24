package com.prestashop.pages;

import com.prestashop.utilities.ConfigReader;
import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PrestaShopHomePage {

    public PrestaShopHomePage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void open(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    public WebElement pickProduct(String productName){
        String xpath="(//h5//a[@title='"+productName+"'])[1]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
    public WebElement pickProductPrice(String productName){
        String xpath="(//h5//a[@title='"+productName+"'])[1]/../../div/span";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(partialLinkText = "Sign in")
    public WebElement signIn ;

    @FindBy(id = "email")
    public WebElement username ;

    @FindBy(id = "passwd")
    public WebElement password ;

    @FindBy(id = "SubmitLogin")
    public WebElement submitSignIn;



    public void signIn (String username, String password){
        signIn.click();
        this.username.sendKeys(username);
        this.password.sendKeys(password);

    }

    public void signInDirect (){
        signIn.click();
        this.username.sendKeys(ConfigReader.getProperty("username"));
        this.password.sendKeys(ConfigReader.getProperty("password"));
        submitSignIn.click();

    }


}
