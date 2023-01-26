package test;


import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import tela.Abrir;
import tela.CalculareCobertura;
import tela.DadosSegurado;
import tela.DadosVeiculo;
import util.*;

import javax.management.InvalidAttributeValueException;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestMapfre {

    @BeforeClass
    public static void inicioDistribuir() throws IOException {
        Distribuir distribuir = new Distribuir();
        distribuir.distribuirArquivos();

    }

    @Test
    public void iniciarMapfre() {

        //variaveis
        WebDriver navegador = null;
        VariaveisAuto v = null;

        //instanciando objetos
        LerArquivos ler = new LerArquivos();
        VariaveisConfiguracao config = new VariaveisConfiguracao();
        Abrir abrir = new Abrir();
        DadosSegurado dadosseg = new DadosSegurado();
        PegarArquivos nrArquivo = new PegarArquivos();
        DadosVeiculo dadosveic = new DadosVeiculo();
        CalculareCobertura calcCob = new CalculareCobertura();

        int processar = 0;
        String erro = "inicio";
        while (processar == 0) {
            try {
                List<String> listaArq = nrArquivo.carregarArquivos();
                if (listaArq.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Acabou!");
                    processar = 1;
                } else {

                    if (erro.contains("sim") || erro.contains("inicio")) {
                        navegador = Navegador.navegador();
                        System.out.println("reconectando....");
                        config = ler.lerConfiguracoes();
                        abrir.login(navegador, config);
                        erro = "nao";
                    }

                    v = ler.lerArquivo(listaArq.get(0));
                    v.setNrlinha(listaArq.get(0));
                    System.out.println("Nrlinha:" + listaArq.get(0));
                    dadosseg.preencherDados(navegador, v);
                    dadosveic.preencherVeiculo(navegador, v);
                    dadosseg.preencherQuestionario(navegador, v);
                    calcCob.calcular(navegador, v);
                    ler.verificaseCalculou(listaArq);


                    //botão voltar
                    Screen screen = new Screen();
                    Pattern btnVoltar = new Pattern("/home/robertinho/mapfre/imagem/voltar.png");
                    Pattern btnfechar = new Pattern("/home/robertinho/mapfre/imagem/fechar.png");
                    Pattern btndescer = new Pattern("/home/robertinho/mapfre/imagem/descer.png");

                    int espera = 0;

                    while (espera < 30) {
                        try {
                            WebDriverWait wait = new WebDriverWait(navegador, 3);
                            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("campoNumericoCPFCNPJ")));
                            espera = 999;
                            break;
                        } catch (Exception e) {
                            espera++;
                            Thread.sleep(1000);
                            System.out.println("Esperando voltar para o inicio :" + espera);
                            try {
                                navegador.findElement(By.xpath("//*[contains(@alt, 'Close shadowbox')]")).click();
                            } catch (Exception e1) {

                            }
                            try {

                                screen.click(btnfechar);
                            } catch (Exception e1) {

                            }
                            try {

                                screen.click(btndescer);
                                Thread.sleep(100);
                                screen.wheel(btndescer, 100, 2);
                                Thread.sleep(100);
                            } catch (Exception e1) {
                                System.out.println("n tem botao descer");
                            }

                            try {
                                screen.click(btnVoltar);
                            } catch (Exception e2) {

                            }
                            if (espera == 30) {
                                System.out.println("esperando chegar na primeira tela oara iniciar..." + espera);
                                new Exception("Link imprimir n apareceu...");
                                break;
                            }
                        }
                    }
                    listaArq.clear();
                }
            } catch (Exception e) {
                System.out.println("Erro:" + e.getMessage());
                navegador.quit();
                erro = "sim";
            }
        }


    }
}
