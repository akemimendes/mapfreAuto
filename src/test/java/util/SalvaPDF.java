package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SalvaPDF {
        static File nomePdfDownload;
        static String nomeDownload;

        private void buscarDownloadPdf() throws IOException, InterruptedException {
            String nomeSeguradoraPastaLocal = "azul";
            String nomeComputador = System.getProperty("user.name");
            String diretorioPastaDownload = "/home/" + nomeComputador + "/" + nomeSeguradoraPastaLocal + "/download/";

            //if (!GerenciaLogar.VerificaErro()) {
                Thread.sleep(7000);
                //  preparar ambiente de comparação de PDF
                File[] ListaDeArquivosDownload;
                ArrayList<String> ListaDeNomesArquivosDownload = new ArrayList();
                Integer contadorTempoEspera = 0;

                // LOOP PARA AGUARDA O PDF SER BAIXADO E PEGAR SEU NOME DE PDF
                while (true) {
                    // aguarda o dowload por 40s no maximo
                    Thread.sleep(1000);
                    if (contadorTempoEspera >= 50) {
                        //GerenciaLogar.CriarArquivoErro();

                        break;
                    }
                    contadorTempoEspera++;

                    try {
                        ListaDeArquivosDownload = new File(diretorioPastaDownload).listFiles();
                        for (File file : ListaDeArquivosDownload) {
                            ListaDeNomesArquivosDownload.add(file.getName());
                        }
                        nomeDownload = ListaDeNomesArquivosDownload.get(0);
                        nomePdfDownload = new File(diretorioPastaDownload + nomeDownload);
                        // verifica se existe um arquivo ( confirmação )
                        if (!nomePdfDownload.exists()) {
                            System.out.println("ainda não existe nenhum arquivo na pasta download.");
                        } else {
                            // nao pode mover um pdf que ainda está em processo de Download
                            if (!nomeDownload.toLowerCase().contains(".crdownload")) {
                                break;
                            }
                            if (contadorTempoEspera > 25) {
                                if (nomeDownload.contains(".crdownload")) {
                                    File correcaoNomePdfDowload = new File(diretorioPastaDownload + nomeDownload
                                            .replace(".crdownload", ""));
                                    nomePdfDownload.renameTo(correcaoNomePdfDowload);
                                    Thread.sleep(3000);
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Arquivo ainda não existe!");
                        System.out.println("não conseguiu listagem de arquivo na pasta download.");
                    }
                }
            //}
        }

        public void deletarArquivosDownload() throws InterruptedException {
            String nomeSeguradoraPastaLocal = "azul";
            String nomeComputador = System.getProperty("user.name");
            String diretorioPastaDownload = "/home/" + nomeComputador + "/" + nomeSeguradoraPastaLocal + "/download/";
            Thread.sleep(500);
            File[] ListaDeArquivosDownload = new File(diretorioPastaDownload).listFiles();
            for (File file : ListaDeArquivosDownload) {
                file.delete();
            }
        }

        public void moverPdfDownloadParaPastaPdf(String nrlinha) throws IOException, InterruptedException {

            String nomeSeguradoraPastaLocal = "azul";
            String nomeComputador = System.getProperty("user.name");
            String diretorioPastaDownload = "/home/" + nomeComputador + "/" + nomeSeguradoraPastaLocal + "/download/";
            String diretorioPastaPdf = "/home/" + nomeComputador + "/" + nomeSeguradoraPastaLocal + "/pdf/";




            // busca primeiro o pdf na pasta dowload e faz o devido tratamento
            buscarDownloadPdf();
            //if (!GerenciaLogar.VerificaErro()) {
                //CAMINHO P/ RENOMEAR E MOVER O ARQUIVO .../caminhopdfZero/0.pdf PARA O ...pdf/(nrlinhapdf).pdf
                File diretorioPdfComNomePdfOrigemArquivo = new File(diretorioPastaPdf + nrlinha
                        .replace(".TXT", ".pdf")
                        .replace(".txt", ".pdf"));

                //RENOMEIA E MOVE O ARQUIVO DA PASTA '.../PDFNRLINHAZERO/' PARA '.../PDF/'
                if (nomePdfDownload.renameTo(diretorioPdfComNomePdfOrigemArquivo)) {

                    if (nomePdfDownload.exists() && nomePdfDownload.isFile()) {
                        nomePdfDownload.delete();
                    }
                    Thread.sleep(1000);
                } else {
                    System.out.println("erro ao renomear/mover o arquivo %s .pdf !" + nomePdfDownload);
                }
           // }
        }

    }



