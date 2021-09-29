package com.vtk.vineyard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Vinyard app Page object model for the login sceen
 */

public class VinyardAppPageModel {

    private WebDriver driver;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(className = "btn")
    WebElement submit;

    @FindBy(id = "m1")
    WebElement culture;

    @FindBy(id = "m2")
    WebElement phenophase;

    @FindBy(id = "m3")
    WebElement operations;

    @FindBy(id = "m4")
    WebElement logout;

    @FindBy(id = "newOp")
    WebElement newOp;

    @FindBy(id = "name")
    WebElement name;

    @FindBy(id = "cost")
    WebElement cost;

    @FindBy(id = "duration")
    WebElement duration;

    @FindBy(id = "save")
    WebElement save;

    @FindBy(id = "opdelete3")
    WebElement delOp;

    @FindBy(id = "opedit1")
    WebElement editOp;

    /**
     * Constructor
     * Initialize instance of Vinyard app Page object Model
     * @param driver a ChromeDriver based on the current Page Object Model Class
     */

    public VinyardAppPageModel(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToUrl(String value) {
        driver.get(value);
    }

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillPassord(String value) {
        password.sendKeys(value);
    }

    public void clickSubmitButton() {
        submit.click();
    }

    public void navigationCultureClick() {
        culture.click();
    }

    public void navigationPhenophaseClick() {
        phenophase.click();
    }

    public void navigationOperationsClick() {
        operations.click();
    }

    public void navigationLogoutClick() {
        logout.click();
    }

    public void navigationNewOpClick() {
        newOp.click();
    }

    public void fillCostField(String value){
        cost.clear();
        cost.sendKeys(value);
    }

    public void fillDurationsField(String value){
        cost.clear();
        duration.sendKeys(value);
    }

    public void newOperationFormSave(){
        save.click();
    }

    public void deleteOperationFromDataBase(){
        delOp.click();
    }

    public void editOperation(){
        editOp.click();
    }
}
