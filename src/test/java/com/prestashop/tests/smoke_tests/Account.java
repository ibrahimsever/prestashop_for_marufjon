package com.prestashop.tests.smoke_tests;

import com.prestashop.pages.MyAccount;
import com.prestashop.pages.PrestaShopHomePage;
import com.prestashop.utilities.Base;
import com.prestashop.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Account extends Base {

@Test
    public void myAccount(){
        PrestaShopHomePage hp=new PrestaShopHomePage();
        MyAccount ma=new MyAccount();
        hp.open();
        //hp.signIn(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
        hp.signInDirect();
        String actualTitle=driver.getTitle();
        String expectedTitle="My account";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Assert.assertEquals(ma.viewMyCostumerAccount.getText(),"Ibrahim Sever");

}
    @Test
    public void myPersonalInfo(){
        PrestaShopHomePage hp=new PrestaShopHomePage();
        MyAccount ma=new MyAccount();
        hp.open();
        hp.signInDirect();
        ma.MyPersonalInfo.click();
        String actualTitle=driver.getTitle();
        String expectedTitle="Identity";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        String actual=ma.layerFirstName.getAttribute("value")+" "+ma.layerLastName.getAttribute("value");
        String expected=ma.viewMyCostumerAccount.getText();
        Assert.assertEquals(actual,expected);

        ma.saveIdentity.click();

        Assert.assertEquals(ma.layerPwdError.getText(), "The password you entered is incorrect.");

        ma.layerMyAccount.click();
        String actualTitle2=driver.getTitle();
        String expectedTitle2="My account";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
    @Test
    public void logInMyAddress(){
        PrestaShopHomePage hp=new PrestaShopHomePage();
        MyAccount ma=new MyAccount();
        hp.open();
        hp.signInDirect();
        ma.myAdress.click();

        String addressLineFirstName=driver.findElement(By.xpath("//div[@class='col-xs-12 col-sm-6 address']/ul/li[2]")).getText();
        Assert.assertEquals(addressLineFirstName,ma.viewMyCostumerAccount.getText());


        ma.addNewAddress.click();
        ma.layerFirstName.clear();
        ma.saveAdress.click();

        WebElement errorElement =driver.findElement(By.xpath("//div[@class='alert alert-danger']//li[1]"));
        String actualError=errorElement.getText();
        String expectedError="firstname is required.";
        Assert.assertEquals(expectedError,actualError);


    }


}
