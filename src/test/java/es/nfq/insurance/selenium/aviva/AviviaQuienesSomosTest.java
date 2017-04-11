package es.nfq.insurance.selenium.aviva;

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
    public void goToQuienesSomos(){
        webDriver.navigate().to(HOME_URL);
        WebDriverWait wait = new WebDriverWait(webDriver,100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(HEADER_NAV)));
        WebElement element = webDriver.findElement(By.linkText(QUIENES_SOMOS));
        element.click();
        checkHeaderBox();
        checkHeaderNav();
        checkBreadCrum(BREADCRUM_QUIENES_SOMOS);
        checkLeftNav(INICIO, LEFT_NAV_QUIENES_SOMOS);
    }

    @Test
    public void goToElGrupo(){
        webDriver.navigate().to(URL_QUIENES_SOMOS);
        WebDriverWait wait = new WebDriverWait(webDriver,100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(HEADER_NAV)));
        checkBreadCrum(BREADCRUM_QUIENES_SOMOS);
        checkLeftNav(INICIO, LEFT_NAV_QUIENES_SOMOS);
        WebElement elGrupoLink = webDriver.findElement(By.linkText(EL_GRUPO));

        Assert.assertEquals(HOME_URL+"es/corporativa/quienes-somos/grupo-aviva/",elGrupoLink.getAttribute("href"));
        elGrupoLink.click();
        checkBreadCrum(BREADCRUM_EL_GRUPO);
        checkLeftNav(QUIENES_SOMOS, LEFT_NAV_EL_GRUPO);

        WebElement eleEstrategia = webDriver.findElement(By.linkText(ESTRATEGIA));
        eleEstrategia.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(HEADER_NAV)));
        checkBreadCrum(BREADCRUM_ESTRATEGIA);
        checkSelected(ESTRATEGIA);

        WebElement eleEstructura = webDriver.findElement(By.linkText(ESTRUCTURA));
        eleEstructura.click();
        checkBreadCrum(BREADCRUM_ESTRUCTURA);
        checkSelected(ESTRUCTURA);

        WebElement eleValores = webDriver.findElement(By.linkText(VALORES));
        eleValores.click();
        checkBreadCrum(BREADCRUM_VALORES);
        checkSelected(VALORES);

        WebElement eleMarca = webDriver.findElement(By.linkText(MARCA));
        eleMarca.click();
        checkBreadCrum(BREADCRUM_MARCA);
        checkSelected(MARCA);

        WebElement eleHistoria = webDriver.findElement(By.linkText(HISTORIA));
        eleHistoria.click();
        checkBreadCrum(BREADCRUM_HISTORIA);
        checkSelected(HISTORIA);

        WebElement eleCifras = webDriver.findElement(By.linkText(CIFRAS));
        eleCifras.click();
        checkBreadCrum(BREADCRUM_CIFRAS);
        checkSelected(CIFRAS);

        WebElement eleEquipo = webDriver.findElement(By.linkText(EQUIPO));
        eleCifras.click();
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

    private void checkLeftNav(String back,String[] leftNav) {
        WebElement elementInicio = webDriver.findElement(By.xpath("//div[@id='leftNav']")).findElement(By.tagName("a"));
        System.out.println(elementInicio.getAttribute("href"));
        Assert.assertEquals(back,elementInicio.getText());

        List<WebElement> allElements = webDriver.findElements(By.xpath("//div[@id='leftNav']/ul/li"));
        int i = 0;
        System.out.println("checkLeftNav:");
        for (WebElement ele: allElements) {
            System.out.println(ele.getText());
            Assert.assertEquals(leftNav[i], ele.getText());
            i++;
        }
    }

    private void checkSelected(String selected){
        WebElement selectedElement = webDriver.findElement(By.xpath("//div[@id='leftNav']/ul/li/a[@class='selected']"));
        Assert.assertEquals(selected, selectedElement.getText());
    }
}
