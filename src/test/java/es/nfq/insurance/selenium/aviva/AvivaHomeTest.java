package es.nfq.insurance.selenium.aviva;

import static es.nfq.insurance.selenium.aviva.AvivaTest.webDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AvivaHomeTest extends AvivaTest{

    private static final String HOME_TITLE = "Grupo Aviva - compañía de seguros líder en Europa, el mayor grupo asegurador de Reino Unido y uno de los principales proveedores de seguros de vida y generales de Europa";


    @Test
    public void searchAviva(){
        webDriver.navigate().to("http://google.es");
        WebElement element = webDriver.findElement(By.id("lst-ib"));
        element.sendKeys("Aviva"+ Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(webDriver,100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                linkText("Grupo Aviva - compañía de seguros líder en Europa, el mayor grupo ...")));
        
        WebElement avivaLink = checkFirstResult(); //valida que es el primer resultado

        Assert.assertEquals(HOME_URL, avivaLink.getAttribute("href"));

        avivaLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headerNav")));
        Assert.assertEquals(HOME_TITLE, webDriver.getTitle());
        
    }

    private WebElement checkFirstResult() {
        return webDriver.findElement(By.linkText("Grupo Aviva - compañía de seguros líder en Europa, el mayor grupo ..."));
    }

    @Test
    public void validateHome(){
        webDriver.navigate().to(HOME_URL);
        new WebDriverWait(webDriver,100).until(ExpectedConditions.visibilityOfElementLocated(By.id(HEADER_NAV)));
        checkHeaderNav(); //valida componentes Cabecera Navegación
        checkHeaderBox(); //valida componentes Cabecera Izquierda

    }
}
