package com.prestashop.pages;

import com.prestashop.utilities.ConfigReader;
import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
    public Registration()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(partialLinkText = "Sign in")
    public WebElement signIn ;

    @FindBy(id = "submitAccount")
    public WebElement costomerRegister ;

    @FindBy(id = "email")
    public WebElement customerEmail ;

    @FindBy(id = "customer_firstname")
    public WebElement customerFirsName ;

    @FindBy(id = "customer_lastname")
    public WebElement customerLastName ;

    @FindBy(id = "phone")
    public WebElement customerPhone ;

    @FindBy(id = "passwd")
    public WebElement customerPassword ;

    @FindBy(id = "city")
    public WebElement customerCity ;


    @FindBy(id = "postcode")
    public WebElement customerZip;


    @FindBy(id = "id_state")
    public WebElement customerState;

    @FindBy(id = "SubmitCreate")
    public WebElement submitCreate;

    @FindBy(id = "email_create")
    public WebElement emailCreate;

    @FindBy(id = "address1")
    public WebElement custmerAddress;


}
