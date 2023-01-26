package tela;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import util.VariaveisConfiguracao;

import java.util.ArrayList;


public class Abrir {

    public void login(WebDriver navegador, VariaveisConfiguracao config){

        try {
            WebDriverWait wait = new WebDriverWait(navegador,5);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("CodVc")));

            navegador.findElement(By.name("CodVc")).sendKeys(config.getSusep());
            Thread.sleep( 1000 );
            navegador.findElement(By.name("CodInt")).sendKeys(config.getLogin());
            Thread.sleep( 1000 );
            navegador.findElement(By.name("SenhaVc")).sendKeys(config.getSenha());
            Thread.sleep( 1000 );
            navegador.findElement(By.id("btnCalculo")).click();
            Thread.sleep( 1000 );
            System.out.println("Entrou login");

            Pattern novacot = new Pattern( "/home/robertinho/mapfre/imagem/novacot.png" );
            Pattern auto = new Pattern( "/home/robertinho/mapfre/imagem/auto.png" );
            Pattern cotauto = new Pattern( "/home/robertinho/mapfre/imagem/mapfreauto.png" );
            Pattern atalho = new Pattern( "/home/robertinho/mapfre/imagem/atalho.png" );

            Screen screen = new Screen();
            int teste = 0;
            while (teste == 0) {
                try {
                    screen.click( novacot );
                    teste = 999;
                } catch (Exception e) {
                    System.out.println( "esperando imagem nova cotacao" );
                }
            }


            Thread.sleep( 1000 );
            screen.click(auto);
            Thread.sleep( 1000 );
            screen.mouseMove(atalho);
            Thread.sleep( 1000 );
            screen.click(cotauto);

            Thread.sleep(5000);
            ArrayList<String> tabs2 = new ArrayList<String>(navegador.getWindowHandles());
            navegador.switchTo().window(tabs2.get(1));
            Thread.sleep( 1000 );

            System.out.println("Novo calculo");


        }catch(Exception e){
            System.out.println("erro" + e.getMessage());
        }
    }
}
