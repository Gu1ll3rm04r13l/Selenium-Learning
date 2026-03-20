package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://sauce-demo.myshopify.com");
    }

    @Test
    public void testHomePage(){
        //driver.get("http://logofree.esy.es/");

        String title = driver.getTitle();
        System.out.println("El título real es: " + title);
        //assert title.equals("Sauce Demo");
        Assert.assertEquals(title, "Sauce Demo", "El titulo no coincide");

    }

    @Test
    public void testNavigateToCatalog(){
        WebElement catalogLink = driver.findElement(By.xpath("//a[@href='/collections/all']"));
        //driver.findElement(By.xpath("//a[contains(@href, 'collections')]"));
        catalogLink.click();
        System.out.println("Click en Catálogo realizado con éxito.");
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
