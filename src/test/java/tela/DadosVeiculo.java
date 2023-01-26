package tela;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import util.VariaveisAuto;
import org.sikuli.script.Key;

import java.util.List;


public class DadosVeiculo {

    public void preencherVeiculo(WebDriver navegador, VariaveisAuto v) throws InterruptedException, FindFailed {

        try {
            Screen screen = new Screen();
            WebDriverWait wait = new WebDriverWait(navegador, 5000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("codigoFlipe")));

            navegador.findElement(By.id("codigoFlipe")).sendKeys(v.getFipe());
            navegador.findElement(By.id("codigoFlipe")).sendKeys(Key.TAB);

            Thread.sleep(3000);

            //janela selecionar veiculo
            try {
                navegador.findElement(By.xpath("//*[@id=\"370927-433807\"]/fieldset/ul[1]/li[1]/label/div")).click();
                Pattern btnconfirmar = new Pattern("/home/robertinho/mapfre/imagem/confirmar.png");
                screen.click(btnconfirmar);
            } catch (Exception e) {

            }
            String ano = v.getAnofabrica().substring(0, 4);

            WebElement cmbAno = navegador.findElement(By.id("comboAnoModelo-sr-only"));
            Select slcAno=new Select(cmbAno);
            System.out.println(slcAno.getOptions().get(1).getText());
            int posicao=-1;
            for (int i=0;i<slcAno.getOptions().size();i++){
                if (slcAno.getOptions().get(i).getText().contains(ano)){
                    posicao=i;
                }
                i++;
            }


            navegador.findElement(By.xpath("//*[@id=\"comboAnoModelo\"]/i")).click();
            Thread.sleep(500);
            screen.type(Key.DOWN);
            Thread.sleep(500);
            for (int i = 0; i <= posicao; i++) {
                screen.type(Key.DOWN);
                i++;
                Thread.sleep(500);
            }
            screen.type(Key.ENTER);
            Thread.sleep(500);

            //zero km
            if (v.getzero().contains("S")) {
                navegador.findElement(By.xpath("//*[@id=\"listadoHorizVeiculoCeroKm\"]/ul/li[1]/label/b"));
            } else {
                navegador.findElement(By.xpath("//*[@id=\"listadoHorizVeiculoCeroKm\"]/ul/li[2]/label/b"));
            }

            //fator ajuste
            navegador.findElement(By.id("campoFatorAjuste")).clear();
            navegador.findElement(By.id("campoFatorAjuste")).sendKeys(v.getFatorAjuste());

            Pattern btncontinuar = new Pattern("/home/robertinho/mapfre/imagem/btncontinuar.png");
            screen.click(btncontinuar);

            System.out.println("preencheu dados do veiculo");
        } catch (Exception e) {
            System.out.println("Erro no dados do veiculo:" + e.getMessage());
        }

    }
}
