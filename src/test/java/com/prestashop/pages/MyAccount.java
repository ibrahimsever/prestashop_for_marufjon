package com.prestashop.pages;


import com.prestashop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {



    public MyAccount() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//i[@class='icon-user']/..")
    public WebElement MyPersonalInfo;

    @FindBy(xpath = "//a[@title='View my customer account']")
    public WebElement viewMyCostumerAccount;

    @FindBy(id = "firstname")
    public WebElement layerFirstName;

    @FindBy(id = "lastname")
    public WebElement layerLastName;

   @FindBy(name = "submitIdentity")
   public WebElement saveIdentity;


    @FindBy(id = "submitAddress")
    public WebElement saveAdress;

    @FindBy(xpath = "//div[@class='alert alert-danger']//li")
    public WebElement layerPwdError;

    @FindBy(partialLinkText = "My account")
    public WebElement layerMyAccount;


    @FindBy(xpath = "//i[@class='icon-building']/..")
    public WebElement myAdress;

    @FindBy(xpath = "///div[@class='col-xs-12 col-sm-6 address']//li[2]")
    public WebElement myAddressFullName;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 address']//li[4]")
    public WebElement myAddressLine;

    @FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 address']//li[5]")
    public WebElement cityStateZip;


    @FindBy(partialLinkText = "Add a new address")
    public WebElement addNewAddress;

    @FindBy(xpath = "//a[@title='Log me out']")
    public WebElement signOut;




}
