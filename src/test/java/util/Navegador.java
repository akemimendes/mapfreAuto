package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Navegador {

    public static WebDriver navegador() throws InterruptedException {

        //diretorio onde o PDF será direcionado no Dowload
        String nomeSeguradoraPastaLocal = "mapfre";

        String nomeComputador = System.getProperty("user.name");
        String diretorioPastaDownload = "/home/" + nomeComputador + "/" + nomeSeguradoraPastaLocal + "/download/";
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        //- imagens teste!
        // 1 - ativado, 2 - desativado
        prefs.put("profile.managed_default_content_settings.images", 1);
        //diretorio onde o PDF será direcionado no Dowload
        prefs.put("download.default_directory", diretorioPastaDownload);
        //desativa o PDF View
        prefs.put("plugins.plugins_disabled", new String[]{
                "Chrome PDF Viewer"
        });
        prefs.put("source", "Object.defineProperty(navigator, 'webdriver', { get: () => undefined })");

        //Não deixar abrir o PDF externamente!
        prefs.put("plugins.always_open_pdf_externally", true);
        options.setExperimentalOption("prefs", prefs);

       /* System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-notifications");*/


        //- imagens teste!
        // 1 - ativado, 2 - desativado
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
        Thread.sleep(500);

        System.setProperty("webdriver.chrome.driver", "/home/robertinho/drivers/chromedriver");

        WebDriver navegador = new ChromeDriver(options);
        navegador.get("https://www.mapfreconnect.com.br/default.asp");
        Thread.sleep(500);
        navegador.manage().window().maximize();
        return navegador;
    }
}
