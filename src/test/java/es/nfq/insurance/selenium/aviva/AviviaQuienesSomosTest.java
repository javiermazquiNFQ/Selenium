package es.nfq.insurance.selenium.aviva;

import static es.nfq.insurance.selenium.aviva.AvivaTest.webDriver;
import java.io.File;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AviviaQuienesSomosTest extends AvivaTest{

    public static final String URL_QUIENES_SOMOS = "http://www.aviva.es/es/corporativa/quienes-somos/";

    public static final String[] BREADCRUM_QUIENES_SOMOS = {"Inicio", "Quiénes somos"};
    public static final String[] BREADCRUM_EL_GRUPO = {"Inicio", "Quiénes somos", "El Grupo Aviva"};
    public static final String[] BREADCRUM_ESTRATEGIA = {"Inicio", "Quiénes somos", "El Grupo Aviva", "Estrategia Corporativa"};
    public static final String[] BREADCRUM_ESTRUCTURA = {"Inicio", "Quiénes somos", "El Grupo Aviva", "Estructura del Grupo"};
    public static final String[] BREADCRUM_VALORES = {"Inicio", "Quiénes somos", "El Grupo Aviva", "Valores"};
    public static final String[] BREADCRUM_MARCA = {"Inicio", "Quiénes somos", "El Grupo Aviva", "Marca Aviva"};
    public static final String[] BREADCRUM_HISTORIA = {"Inicio", "Quiénes somos", "El Grupo Aviva", "Historia"};
    public static final String[] BREADCRUM_CIFRAS = {"Inicio", "Quiénes somos", "El Grupo Aviva", "Cifras"};
    public static final String[] BREADCRUM_EQUIPO = {"Inicio", "Quiénes somos", "El Grupo Aviva", "Equipo Directivo"};

    public static final String INICIO = "Inicio";
    public static final String QUIENES_SOMOS = "Quiénes somos";
    public static final String EL_GRUPO = "El Grupo Aviva";
    public static final String ESTRATEGIA = "Estrategia Corporativa";
    public static final String ESTRUCTURA = "Estructura del Grupo";
    public static final String VALORES = "Valores";
    public static final String MARCA = "Marca Aviva";
    public static final String HISTORIA = "Historia";
    public static final String CIFRAS = "Cifras";
    public static final String EQUIPO = "Equipo Directivo";

    public static final String[] LEFT_NAV_QUIENES_SOMOS = {"Quiénes somos", "El Grupo Aviva", "Aviva en España"};
    public static final String[] LEFT_NAV_EL_GRUPO = {"El Grupo Aviva", "Estrategia Corporativa", "Estructura del Grupo", "Valores", "Marca Aviva", "Historia", "Cifras", "Equipo Directivo"};

    @Test
    public void goToQuienesSomos() throws InterruptedException{
        webDriver.navigate().to(HOME_URL);
        WebDriverWait wait = new WebDriverWait(webDriver,100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(HEADER_NAV)));
        WebElement element = webDriver.findElement(By.linkText(QUIENES_SOMOS));
        element.click();
        Thread.sleep(1000);
        checkHeaderBox();
        checkHeaderNav();
        checkBreadCrum(BREADCRUM_QUIENES_SOMOS);
        checkLeftNav(INICIO, LEFT_NAV_QUIENES_SOMOS);
    }

    @Test
    public void goToElGrupo() throws InterruptedException{
        webDriver.navigate().to(URL_QUIENES_SOMOS);
        WebDriverWait wait = new WebDriverWait(webDriver,100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(HEADER_NAV)));
        checkBreadCrum(BREADCRUM_QUIENES_SOMOS);
        checkLeftNav(INICIO, LEFT_NAV_QUIENES_SOMOS);
        WebElement elGrupoLink = webDriver.findElement(By.linkText(EL_GRUPO));
        Assert.assertEquals(HOME_URL+"es/corporativa/quienes-somos/grupo-aviva/",elGrupoLink.getAttribute("href"));
        elGrupoLink.click();
        checkBreadCrum(BREADCRUM_EL_GRUPO);
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(ESTRATEGIA)));
        WebElement eleEstrategia = webDriver.findElement(By.linkText(ESTRATEGIA)) ;        
        eleEstrategia.click();
   
        //opciones
        //webDriver.manage().timeouts().implicitlyWait(1000000, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content']/div[1]/h1")));
        Thread.sleep(1000);
        checkBreadCrum(BREADCRUM_ESTRATEGIA);
        checkSelected(ESTRATEGIA);
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(ESTRUCTURA)));
        WebElement eleEstructura = webDriver.findElement(By.linkText(ESTRUCTURA));
        eleEstructura.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='content']/div[1]/h1")));
        
        Thread.sleep(1000);
        checkBreadCrum(BREADCRUM_ESTRUCTURA);
        checkSelected(ESTRUCTURA);

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(VALORES)));
        WebElement eleValores = webDriver.findElement(By.linkText(VALORES));
        eleValores.click();
        Thread.sleep(1000);
        checkBreadCrum(BREADCRUM_VALORES);
        checkSelected(VALORES);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(MARCA)));
        WebElement eleMarca = webDriver.findElement(By.linkText(MARCA));
        eleMarca.click();
        
        Thread.sleep(1000);
        checkBreadCrum(BREADCRUM_MARCA);
        checkSelected(MARCA);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(HISTORIA)));
        WebElement eleHistoria = webDriver.findElement(By.linkText(HISTORIA));
        eleHistoria.click();
        
        Thread.sleep(1000);
        checkBreadCrum(BREADCRUM_HISTORIA);
        checkSelected(HISTORIA);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(CIFRAS)));
        WebElement eleCifras = webDriver.findElement(By.linkText(CIFRAS));
        eleCifras.click();
        
        Thread.sleep(1000);
        checkBreadCrum(BREADCRUM_CIFRAS);
        checkSelected(CIFRAS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(EQUIPO)));
        WebElement eleEquipo = webDriver.findElement(By.linkText(EQUIPO));
        eleEquipo.click();
        
        Thread.sleep(1000);
        checkBreadCrum(BREADCRUM_EQUIPO);
        checkSelected(EQUIPO);
    }

    private void checkBreadCrum(String[] breadCrum) {
        List<WebElement> allElements = webDriver.findElements(By.xpath("//ul[@id='breadcrumb']/li"));
        int i = 0;
        System.out.println("checkBreadCrum:");
        for (WebElement ele: allElements) {
            System.out.println(ele.getText());
            Assert.assertEquals(breadCrum[i], ele.getText());
            i++;
        }
    }

    private void checkLeftNav(String back,String[] leftNav) throws InterruptedException {
        String aux;
        String aux1;    
        WebElement elementInicio = webDriver.findElement(By.xpath(".//*[@id='leftNav']/h2/a"));
        aux=elementInicio.getText();
        Assert.assertEquals(back,aux);

        List<WebElement> allElements = webDriver.findElements(By.xpath("//div[@id='leftNav']/ul/li"));
        int i = 0;
        System.out.println("checkLeftNav:");
        for (WebElement ele: allElements) {
            aux1=ele.getText();            
            Assert.assertEquals(leftNav[i], aux1);
            i++;
        }
    }

    private void checkSelected(String selected){
        WebElement selectedElement = webDriver.findElement(By.xpath("//div[@id='leftNav']/ul/li/a[@class='selected']"));
        Assert.assertEquals(selected, selectedElement.getText());
    }
}
