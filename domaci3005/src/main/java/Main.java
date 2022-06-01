/*
Domaći:
Otići na http://www.strela.co.rs/, kliknuti na dugme Prodavnica u headeru,
 izabrati opciju Lukovi - Bows iz leve navigacije, potom kliknuti na luk koji se zove Samick Sage,
 i onda proveriti da ime tog luka na njegovoj stranici zaista sadrži reč Samick.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main {
    @Test
    public void test() {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Desktop\\IT bootcamp\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.navigate().to("http://www.strela.co.rs/");


            WebElement prodavnica = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]"));
            driverWait.until(ExpectedConditions.elementToBeClickable(prodavnica));
            prodavnica.click();
            WebElement lukovi = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
            driverWait.until(ExpectedConditions.elementToBeClickable(lukovi));
            lukovi.click();
            WebElement samick = driver.findElement(By.xpath("/html/body/form/div[4]/div/section/div/div[2]/div/div[2]/section/div[36]/figure"));
            driverWait.until(ExpectedConditions.visibilityOf(samick));
            samick.click();


        WebElement naslov=driver.findElement(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel"));
        String expected="Bow Samick Sage";
        String actual=naslov.getText();
        Assert.assertEquals(expected,actual);


    }
}
