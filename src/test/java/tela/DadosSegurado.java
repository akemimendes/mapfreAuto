package tela;

import org.apache.commons.collections.functors.ExceptionPredicate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import util.Variaveis;
import util.VariaveisAuto;

import java.util.ArrayList;

public class DadosSegurado {

    public void preencherDados(WebDriver navegador, VariaveisAuto v) throws InterruptedException {

        try {

            WebDriverWait wait = new WebDriverWait(navegador, 5000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("campoNumericoCPFCNPJ")));

            navegador.findElement(By.id("campoNumericoCPFCNPJ")).clear();
            navegador.findElement(By.id("campoNumericoCPFCNPJ")).sendKeys(v.getCpf());
            navegador.findElement(By.id("campoNumericoCPFCNPJ")).sendKeys(Keys.TAB);
            Thread.sleep(2000);
            try {

                WebElement fechar = navegador.findElement(By.xpath("//*[contains(@alt, 'Close shadowbox')]"));
                JavascriptExecutor jsFechar = (JavascriptExecutor) navegador;
                jsFechar.executeScript("arguments[0].click();", fechar);

            } catch (Exception e) {

            }

            //cep
            navegador.findElement(By.id("campoNumericoCEPCondutorIniciarCotacaoSimplificada")).clear();
            navegador.findElement(By.id("campoNumericoCEPCondutorIniciarCotacaoSimplificada")).sendKeys(v.getCep());
            Thread.sleep(1000);


            // tipo de seguro

            navegador.findElement(By.id("comboTipoSeguro")).click();
            Screen screen = new Screen();

            screen.type(Key.PAGE_UP);
            Thread.sleep(500);
            if (v.getTiposeguro().toUpperCase().contains("NOVO")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);

                screen.type(Key.ENTER);
                Thread.sleep(500);
            } else {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.ENTER);
                Thread.sleep(500);

                //sinistro
                WebElement chkSinistroN = navegador.findElement(By.xpath("//*[@id=\"listadoHorizSinistroVigencia\"]/ul/li[2]/label"));
                JavascriptExecutor jsSinistroN = (JavascriptExecutor) navegador;
                jsSinistroN.executeScript("arguments[0].click();", chkSinistroN);

                //bonus
                navegador.findElement(By.id("comboBonus")).click();
                int bonus=Integer.parseInt(v.getBonus());
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                for(int i=0;i<=bonus;i++){
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                    i++;
                }
                screen.type(Key.ENTER);
                Thread.sleep(500);

                //congenere
                navegador.findElement(By.id("comboSeguradoraAnterior")).clear();
                navegador.findElement(By.id("comboSeguradoraAnterior")).sendKeys(v.getCongenere());
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.ENTER);
                Thread.sleep(500);
            }

            Pattern btndescer = new Pattern("/home/robertinho/mapfre/imagem/descer.png");
            screen.click(btndescer);
            Thread.sleep(500);
            screen.wheel(btndescer, 100, 2);

            Thread.sleep(500);
            Pattern novacot = new Pattern("/home/robertinho/mapfre/imagem/iniciarcota.png");
            screen.click(novacot);

            System.out.println("preencheu a primeira tela");
        } catch (Exception e) {
            System.out.println("Erro no dados do segurado:" + e.getMessage());
        }

    }

    public void preencherQuestionario(WebDriver navegador, VariaveisAuto v) {

        try {
            WebDriverWait wait = new WebDriverWait(navegador, 1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("comboEstadoCivilSIM-sr-only")));

            navegador.findElement(By.id("comboEstadoCivilSIM")).click();
            Screen screen = new Screen();
            Thread.sleep(1000);

            if (v.getEstcivil().contains("C")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getEstcivil().contains("S")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getEstcivil().contains("V")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            }
            Thread.sleep(500);
            screen.type(Key.ENTER);
            Thread.sleep(1000);

            //dirige 25
            if (v.getMenor25().substring(0, 1).contains("N")) {
                WebElement chkSim = navegador.findElement(By.id("listadoHorizCondutorMenorVinteSeis1"));
                JavascriptExecutor jsSim = (JavascriptExecutor) navegador;
                jsSim.executeScript("arguments[0].click();", chkSim);
            } else {
                WebElement chkNao = navegador.findElement(By.id("listadoHorizCondutorMenorVinteSeis0"));
                JavascriptExecutor jsNao = (JavascriptExecutor) navegador;
                jsNao.executeScript("arguments[0].click();", chkNao);
            }

            navegador.findElement(By.xpath("/html/body"));
            screen.type(Key.PAGE_DOWN);
            Thread.sleep(500);
            Pattern btncontinuar = new Pattern("/home/robertinho/mapfre/imagem/btncontinuar.png");
            screen.click(btncontinuar);
            Thread.sleep(500);
            System.out.println("Preencheu questionario");

        } catch (Exception e) {
            System.out.println("Erro preencher questionario:" + e.getMessage());
        }
    }
}


