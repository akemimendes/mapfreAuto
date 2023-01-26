package tela;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import util.Navegador;
import util.VariaveisAuto;

public class CalculareCobertura {

    private WebDriver navegador;
    VariaveisAuto v;
    Screen screen = new Screen();


    public void calcular(WebDriver navegador, VariaveisAuto v) {
        try {

            this.navegador = navegador;
            this.v = v;

            WebDriverWait wait = new WebDriverWait(navegador, 5000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("campoNumericoComissao")));
            navegador.findElement(By.id("campoNumericoComissao")).clear();
            navegador.findElement(By.id("campoNumericoComissao")).sendKeys(v.getComissao());
            Thread.sleep(1000);


            Pattern btnCalcular = new Pattern("/home/robertinho/mapfre/imagem/calcular.png");
            screen.click(btnCalcular);

            //escolher ass24h e alterar cobertura
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("A01_B01_buttonMainPrice")));

            if (v.getTipoass().contains("2")) {
                navegador.findElement(By.id("A01_B03_buttonMainPrice")).click();
                System.out.print("Assistencia basica");
                preenherCobertura();


            } else if (v.getTipoass().contains("3")) {
                navegador.findElement(By.id("A01_B02_buttonMainPrice")).click();
            } else if (v.getTipoass().contains("4")) {
                navegador.findElement(By.id("A01_B01_buttonMainPrice")).click();
            }


        } catch (Exception e) {
            System.out.println("Erro calcular e cobertura:" + e.getMessage());
        }
    }

    public void preenherCobertura() throws InterruptedException, FindFailed {
        try {
            WebDriverWait wait = new WebDriverWait(navegador, 5000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cobertura-0-TIP_FRANQUIA")));
            //franquia
            navegador.findElement(By.id("cobertura-0-TIP_FRANQUIA")).click();
            Thread.sleep(500);
            if (v.getFranquia().contains("NORMAL")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getFranquia().contains("REDUZIDA")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getFranquia().contains("MAJORADA")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            }
            screen.type(Key.ENTER);
            Thread.sleep(500);
            // tipo de contratacao compreensiva
            System.out.print("preencheu frq");
            navegador.findElement(By.id("cobertura-0-CASCO")).click();
            screen.type(Key.DOWN);
            Thread.sleep(500);
            screen.type(Key.ENTER);
            Thread.sleep(500);
            //dm
            navegador.findElement(By.id("cobertura-204-SUMA_ASEG_204")).click();
            screen.type(Key.DOWN);
            Thread.sleep(500);

            if (v.getIsdm().contains("50")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("60")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("70")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("75")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("80")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("90")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("100")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("125")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("150")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("200")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("250")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);

            } else if (v.getIsdm().contains("300")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
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
            Thread.sleep(500);
            screen.type(Key.ENTER);
            Thread.sleep(500);

            System.out.println("Preencheu dm");

            //dc
            navegador.findElement(By.id("cobertura-205-SUMA_ASEG_205")).click();
            Thread.sleep(500);
            screen.type(Key.DOWN);
            Thread.sleep(500);

            if (v.getIsdm().contains("50")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("60")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("70")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("75")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("80")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("90")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("100")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("125")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("150")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("200")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getIsdm().contains("250")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);

            } else if (v.getIsdm().contains("300")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
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
            Thread.sleep(500);
            screen.type(Key.ENTER);
            Thread.sleep(500);

            //dmo
            navegador.findElement(By.id("cobertura-116-SUMA_ASEG_116")).click();
            Thread.sleep(500);
            screen.type(Key.DOWN);
            Thread.sleep(500);
            if (v.getDmo().contains("1")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getDmo().contains("2")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getDmo().contains("3")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getDmo().contains("4")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getDmo().contains("5")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getDmo().contains("10")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getDmo().contains("15")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getDmo().contains("20")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getDmo().contains("25")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getDmo().contains("30")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else if (v.getDmo().contains("40")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);

            } else if (v.getDmo().contains("50")) {
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
                screen.type(Key.DOWN);
                Thread.sleep(500);
            } else {
                screen.type(Key.DOWN);
                Thread.sleep(500);
            }
            Thread.sleep(500);
            screen.type(Key.ENTER);
            Thread.sleep(500);
            screen.type(Key.ENTER);
            Thread.sleep(500);

            //cobertura adicionais
            navegador.findElement(By.xpath("//*[@id=\"373053-15202\"]/div/div[5]/div[1]/mfc-card/div/h2")).click();

            //vidros

            if (!v.getTipovidros().contains("NAO")) {
                navegador.findElement(By.xpath("//*[@id=\"373053-15202\"]/div/div[5]/div[2]/div[2]/div[1]/mfc-check-box/div/label")).click();
                Thread.sleep(500);
                navegador.findElement(By.id("cobertura-1301-TIP_COB_VIDROS")).click();
                Thread.sleep(500);
                if (v.getTipovidros().contains("BASICO")) {
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                } else {
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                }
                screen.type(Key.ENTER);
                Thread.sleep(500);
                screen.type(Key.ENTER);
                Thread.sleep(500);

                //carro reserva

                navegador.findElement(By.xpath("//*[@id=\"373053-15202\"]/div/div[5]/div[2]/div[3]/div[1]/mfc-check-box/div/label")).click();
                Thread.sleep(500);
                navegador.findElement(By.id("cobertura-1302-TIP_CARRO_RESERVA")).click();
                Thread.sleep(500);
                if (v.getTiporeser().contains("BASICO")) {
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                } else {
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                }
                screen.type(Key.ENTER);
                Thread.sleep(500);
                screen.type(Key.ENTER);
                Thread.sleep(500);
                //dias creser
                navegador.findElement(By.id("cobertura-1302-NUM_QTD_DIARIAS")).click();
                Thread.sleep(500);
                if (v.getTiporeser().contains("7")) {
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                } else if (v.getTiporeser().contains("15")) {
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                    screen.type(Key.DOWN);
                    Thread.sleep(500);

                } else if (v.getTiporeser().contains("30")) {
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                    screen.type(Key.DOWN);
                    Thread.sleep(500);
                    screen.type(Key.DOWN);
                    Thread.sleep(500);

                }

                screen.type(Key.ENTER);
                Thread.sleep(500);
                screen.type(Key.ENTER);
                Thread.sleep(500);
                //app

                navegador.findElement(By.xpath("//*[@id=\"373053-15202\"]/div/div[5]/div[2]/div[5]/div[1]/mfc-check-box/div/label")).click();
                Thread.sleep(500);
                navegador.findElement(By.id("cobertura-119-SUMA_ASEG_119")).clear();
                navegador.findElement(By.id("cobertura-119-SUMA_ASEG_119")).sendKeys(v.getApp());


                navegador.findElement(By.xpath("//*[@id=\"373053-15202\"]/div/div[5]/div[2]/div[6]/div[1]/mfc-check-box/div/label")).click();
                Thread.sleep(500);
                navegador.findElement(By.id("cobertura-120-SUMA_ASEG_120")).clear();
                navegador.findElement(By.id("cobertura-120-SUMA_ASEG_120")).sendKeys(v.getApp());

            }
            screen.type(Key.TAB);
            Thread.sleep(500);
            System.out.println("Terminou de preencher a cobertura");

            //descer
            Pattern btndescer = new Pattern("/home/robertinho/mapfre/imagem/descer.png");
            screen.click(btndescer);
            screen.wheel(btndescer, 100, 2);

            //calcular
            Pattern btnrecalcular = new Pattern("/home/robertinho/mapfre/imagem/recalcular.png");
            screen.click(btnrecalcular);
            Pattern btnSalvarPDF = new Pattern("/home/robertinho/mapfre/imagem/salvarpdf.png");
            System.out.println("calculou");

            int espera=0;

            while (espera<30) {
                try {
                    //imprimir
                    navegador.findElement(By.xpath("/html/body")).click();
                    Thread.sleep(2000);
                    navegador.findElement(By.xpath("//*[@id=\"enlacesImprimirCoberturasAdicionais\"]/aside/div/a[2]/div")).click();
                    Thread.sleep(2000);
                    System.out.println("imprimir");
                    espera=999;
                    break;
                } catch (Exception e) {
                    espera++;
                    Thread.sleep(500);
                    System.out.println("Esperando imprimir..."+espera);
                    if (espera==30){
                        System.out.println("Link imprimir n apareceu..."+espera);
                        new Exception("Link imprimir n apareceu...");
                        break;
                    }
                }
            }
            //digitar caminho pdf
            Thread.sleep(1000);
            screen.type("/home/robertinho/mapfre/pdf/" + v.getNrlinha());
            int y = 0;
            while (y <= 3) {
                screen.type(Key.BACKSPACE);
                y++;
            }
            Thread.sleep(2000);
            screen.click(btnSalvarPDF);
            screen.click(btnSalvarPDF);
        } catch (Exception e) {
            System.out.println("erro no preencher cobertura:" + e.getMessage());
        }
    }
}
