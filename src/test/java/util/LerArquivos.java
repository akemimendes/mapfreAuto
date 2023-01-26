package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivos {

    private String nrlinha;

    public ArrayList carregarArquivos() {

        ArrayList<String> listaNrlinha = new ArrayList<String>();

        File[] files = new File("/home/robertinho/mapfre/arquivos/").listFiles();
        try {
            for (File file : files) {
                listaNrlinha.add(file.getName());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaNrlinha;
    }

    public VariaveisConfiguracao lerConfiguracoes() throws IOException {
        VariaveisConfiguracao v = new VariaveisConfiguracao();
        File file = new File("/home/robertinho/mapfre/cotacao/login.txt");

        if (file.exists()) {
            Scanner ler = new Scanner("/home/robertinho/mapfre/cotacao/login.txt");
            String arquivo = ler.nextLine();
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            v.setSusep(lerArq.readLine());
            v.setLogin(lerArq.readLine());
            lerArq.readLine();
            v.setSenha(lerArq.readLine());
        }
        file = new File("/home/robertinho/mapfre/cotacao/resumo.txt");

        if (file.exists()) {
            Scanner ler = new Scanner("/home/robertinho/mapfre/cotacao/resumo.txt");
            String arquivo = ler.nextLine();
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            lerArq.readLine();
            v.setSegmento(lerArq.readLine());
            lerArq.readLine();
            lerArq.readLine();
            lerArq.readLine();
            v.setAlterarLMI(lerArq.readLine());
            lerArq.readLine();
            v.setFazrcgarag(lerArq.readLine());
            lerArq.readLine();
            v.setTipoveiculo(lerArq.readLine());


        }

        file = new File("/home/robertinho/mapfre/cotacao/matriz.txt");

        if (file.exists()) {
            Scanner ler = new Scanner("/home/robertinho/mapfre/cotacao/matriz.txt");
            String arquivo = ler.nextLine();
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);

            v.setMatriz(lerArq.readLine());

        }
        return v;
    }

    public VariaveisAuto lerArquivo(String nrlinha) throws IOException {
        this.nrlinha = nrlinha;
        VariaveisAuto v = new VariaveisAuto();

        File file = new File("/home/robertinho/mapfre/arquivos/" + nrlinha);

        if (file.exists()) {
            Scanner ler = new Scanner("/home/robertinho/mapfre/arquivos/" + nrlinha);
            String arquivo = ler.nextLine();
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);

            v.setNome(lerArq.readLine());
            v.setCpf(lerArq.readLine());
            v.setCep(lerArq.readLine());
            v.setdatanasc(lerArq.readLine());
            v.setestcivil(lerArq.readLine());
            v.setsexo(lerArq.readLine());
            v.settiposeguro(lerArq.readLine());
            v.setbonus(lerArq.readLine());
            v.setfranquia(lerArq.readLine());
            v.setanofabrica(lerArq.readLine());
            v.setZero(lerArq.readLine());
            v.setveiculo(lerArq.readLine());
            v.setmarca(lerArq.readLine());
            v.setfipe(lerArq.readLine());
            v.setcongenere(lerArq.readLine());
            v.setisdm(lerArq.readLine());
            lerArq.readLine();
            lerArq.readLine();
            v.setisdc(lerArq.readLine());
            v.setcomissao(lerArq.readLine());
            v.settipoass(lerArq.readLine());
            lerArq.readLine();
            v.setFatorAjuste(lerArq.readLine());
            v.settipovidros(lerArq.readLine());
            v.setgrgres(lerArq.readLine());
            v.setgrgtrab(lerArq.readLine());
            v.setgrgescola(lerArq.readLine());
            v.setcomercial(lerArq.readLine());
            lerArq.readLine();
            v.setapp(lerArq.readLine());
            v.settiporeser(lerArq.readLine());
            v.setMenor25(lerArq.readLine());
            lerArq.readLine();
            lerArq.readLine();
            lerArq.readLine();
            lerArq.readLine();
            lerArq.readLine();
            lerArq.readLine();
            lerArq.readLine();
            lerArq.readLine();
            lerArq.readLine();
            lerArq.readLine();
            v.setdmo(lerArq.readLine());




        }


        return v;


    }


    public void verificaseCalculou(List<String> nrlinha) throws IOException {

        try {


            String nrlinhapdf = nrlinha.get(0);
            nrlinhapdf = nrlinhapdf.replace(".TXT", ".pdf");
            nrlinhapdf = nrlinhapdf.replace(".txt", ".pdf");


            File filearquivo = new File("/home/robertinho/mapfre/arquivos/" + nrlinha.get(0));
            File filepdf = new File("/home/robertinho/mapfre/pdf/" + nrlinhapdf);
            System.out.println(filepdf);

            if (filepdf.exists() && filepdf.isFile()) {
                filearquivo.renameTo(new File("/home/robertinho/mapfre/prontos/" + nrlinha.get(0)));
                filearquivo.delete();
                nrlinha.remove(0);
                nrlinha.clear();

            }

        } catch (Exception e) {
            e.printStackTrace();


        }

    }
}
