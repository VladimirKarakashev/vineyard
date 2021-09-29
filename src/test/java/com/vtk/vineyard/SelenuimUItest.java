package com.vtk.vineyard;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Selenium UI Tests for Vinyard App
 * based on {@link VinyardAppPageModel} classes
 */

public class SelenuimUItest {

    WebDriver driver;
    VinyardAppPageModel vinyardApp;

    @BeforeClass
    public static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "chromeDriver/chromedriver.exe");
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        vinyardApp = new VinyardAppPageModel(driver);
    }

    @After
    public void after(){
        driver.close();
    }

    /**
     * Fill login form with details for User
     */
    public void loginAsUser() {
        vinyardApp.navigateToUrl("http://localhost:8080");
        vinyardApp.fillUsername("user");
        vinyardApp.fillPassord("123");
        vinyardApp.clickSubmitButton();
    }

    /**
     * Fill login form with details for Admin
     */
    private void loginAsAdmin() {
        vinyardApp.navigateToUrl("http://localhost:8080");
        vinyardApp.fillUsername("admin");
        vinyardApp.fillPassord("321");
        vinyardApp.clickSubmitButton();
    }

    /**
     * Testing login form
     */
    @Test
    public void testUserLogin() {
        loginAsUser();

        final String expectedURL = "http://localhost:8080/index";
        final String result = driver.getCurrentUrl();
        assertEquals(expectedURL, result);
    }

    /**
     * Testing page navigation as a User
     * (Culture/index, Phenophase, Operations and logout/exit)
     */

    @Test //Index
    public void testPageNavigationAsUserIndex() {
        loginAsUser();

        vinyardApp.navigationCultureClick();
        final String expectedURL = "http://localhost:8080/index";
        final String result = driver.getCurrentUrl();
        assertEquals(expectedURL, result);
    }

    @Test // Phenophases
    public void testPageNavigationAsUserPhenophase() {
        loginAsUser();

        vinyardApp.navigationPhenophaseClick();
        final String expectedURL = "http://localhost:8080/phenophase";
        final String result = driver.getCurrentUrl();
        assertEquals(expectedURL, result);
    }

    @Test // Operations
    public void testPageNavigationAsUserOperations() {
        loginAsUser();

        vinyardApp.navigationOperationsClick();
        final String expectedURL = "http://localhost:8080/operations";
        final String result = driver.getCurrentUrl();
        assertEquals(expectedURL, result);
    }

    @Test // logout
    public void testPageNavigationAsUserLogout() {
        loginAsUser();

        vinyardApp.navigationLogoutClick();
        final String expectedURL = "http://localhost:8080/login?logout";
        final String result = driver.getCurrentUrl();
        assertEquals(expectedURL, result);
    }

    @Test // New Operation
    public void testPageNavigationAsUserNewOperation() {
        loginAsUser();

        vinyardApp.navigationOperationsClick();
        vinyardApp.navigationNewOpClick();
        final String expectedURL = "http://localhost:8080/new_operation";
        final String result = driver.getCurrentUrl();
        assertEquals(expectedURL, result);
    }
    /**
     * END of Navigation Tests as a User
     */

    /**
     * Test navigation to H2 Console (Admin specific)
     */
    @Test // Navigation H2 Console
    public void testPageNavigationAsAdminH2Console() {
        loginAsAdmin();

        vinyardApp.navigateToUrl("http://localhost:8080/h2");
        driver.findElement(By.className("button")).click();
        WebElement element = driver.findElement(By.className("login"));
        String title = element.getTagName();
        final String expected = "table";
        assertEquals(expected, title);
    }

    /**
     * Spring Security test as a User
     * Users are not allowed to access H2 Console
     */
    @Test // Navigation to H2 Console
    public void testSecurityAsUserNavigateToH2Console(){
        loginAsUser();

        vinyardApp.navigateToUrl("http://localhost:8080/h2");
        final String expectedMessage = "Whitelabel Error Page";
        final String result = driver.findElement(By.tagName("h1")).getText();
        assertEquals(expectedMessage, result);
    }

    /**
     * Create new Operation as a User
     */
    @Test
    public void testCreateNewOperationAsUser(){
        loginAsUser();

        vinyardApp.navigationOperationsClick();
        vinyardApp.navigationNewOpClick();

        Select name = new Select(driver.findElement(By.id("name")));
        name.selectByValue("Пръскане");
        vinyardApp.fillCostField("10.5");
        vinyardApp.fillDurationsField("1");
        vinyardApp.newOperationFormSave();
        String result = driver.getCurrentUrl();
        String expected = "http://localhost:8080/save";
        assertEquals(expected, result);
    }

    /**
     * Delete Operation from the Data Base as a User
     */
    @Test
    public void testDeleteOperationFromDataBaseAsUser(){
        loginAsUser();

        vinyardApp.navigationOperationsClick();
        vinyardApp.deleteOperationFromDataBase();
        Boolean isPresent = driver.findElements(By.id("opdelete3")).size()>0;
        Boolean expected = false;
        assertEquals(expected, isPresent);
    }

    /**
     * Edit Operation as User
     */
    @Test
    public void testEditOperationAsUser(){
        loginAsUser();

        vinyardApp.navigationOperationsClick();
        vinyardApp.editOperation();
        String result = driver.getCurrentUrl();
        String expected = "http://localhost:8080/edit_operation/1";
        assertEquals(expected, result);
    }

}
