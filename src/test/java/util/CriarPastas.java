package util;

import java.io.File;

public class CriarPastas {
    public static File criarPastaArquivos(){
        File pastaarquivos = new File("/home/robertinho/mapfre/arquivos");
        pastaarquivos.mkdir();
        return pastaarquivos;
    }
    public static File criarPastaPdf(){
        File pastaapdf = new File("/home/robertinho/mapfre/pdf");
        pastaapdf.mkdir();
        return pastaapdf;
    }
    public static File criarPastaProntos(){
        File pastaprontos = new File("/home/robertinho/mapfre/prontos");
        pastaprontos.mkdir();
        return pastaprontos;
    }
    public static File criarPastaTxt(){
        File pastatxt = new File("/home/robertinho/mapfre/txt");
        pastatxt.mkdir();
        return pastatxt;
    }
    public static File criarPastaErro(){
        File pastaerro = new File("/home/robertinho/mapfre/erro");
        pastaerro.mkdir();
        return pastaerro;
    }
    public static File criarPastaStatus(){
        File pastaerro = new File("/home/robertinho/mapfre/status");
        pastaerro.mkdir();
        return pastaerro;
    }
    public static File criarPastacotacao(){
        File pastacotacao = new File("/home/robertinho/mapfre/cotacao");
        pastacotacao.mkdir();
        return pastacotacao;
    }

    public static File criarPastaimagem(){
        File pastacotacao = new File("/home/robertinho/mapfre/imagem");
        pastacotacao.mkdir();
        return pastacotacao;
    }

    public static File criarPastaDownload(){
        File pastacotacao = new File("/home/robertinho/mapfre/download");
        pastacotacao.mkdir();
        return pastacotacao;
    }

}
