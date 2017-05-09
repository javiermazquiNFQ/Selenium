package es.nfq.insurance.selenium.aviva;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AvivaTest {

    protected static WebDriver webDriver;

    public static final  String[] HEADERS = {"Inicio", "Quiénes somos", "Productos", "Responsabilidad Corporativa", "Prensa", "Empleo", "Contacto"};
    public static final  String[] HEADER_BOX = {"Aviva Vida y Pensiones", "Aviva Gestión"};
    public static final String HEADER_NAV = "headerNav";
    public static final String HOME_URL = "http://www.aviva.es/";

    @BeforeClass
    public static void startFireFox() {
        //webDriver = new ChromeDriver();
       
        webDriver = new FirefoxDriver();
        
        //webDriver = new InternetExplorerDriver();
     
        
        
    }

    protected void checkHeaderNav(){
        List<WebElement> allElements = webDriver.findElements(By.xpath("//ul[@id='headerNav']/li"));
        int i = 0;
        String aux;
        System.out.println("checkHeaderNav:");
        for (WebElement ele: allElements) {
            aux=ele.getText();
            Assert.assertEquals(HEADERS[i], aux);
            i++;
        }
    }

    protected void checkHeaderBox() {
        List<WebElement> allElements = webDriver.findElements(By.xpath("//ul[@class='headerBox4 clearFix']/li"));
        int i = 0;
        System.out.println("checkHeaderBox:");
        for (WebElement ele: allElements) {
            System.out.println(ele.getText());
            Assert.assertEquals(HEADER_BOX[i], ele.getText());
            i++;
        }
    }

    @AfterClass
    public static void closeFireFox() {
        webDriver.quit();
    }
}
