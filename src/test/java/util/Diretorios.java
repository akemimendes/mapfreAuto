package util;

public class Diretorios {



        public static String nomeSeguradoraPastaLocal = "mapfre";
        public static String nomeSeguradoraPastaDistribuirFreenas = "mapfre";

        // nome do usario em que está rodando o projeo
        public static String nomeComputador = System.getProperty("user.name");

        // adicionar em casos de implementação e teste no computador pessoal/empresa

        // gerenciadores de diretorios da seguradora
        public static String diretorioPastaRestricao = "/home/"+nomeComputador+"/"+ nomeSeguradoraPastaLocal +"/restricao/";
        public static String diretorioPastaDownload = "/home/"+nomeComputador+"/"+"/download/";
        public static String diretorioPastaArquivos = "/home/"+nomeComputador+"/"+ nomeSeguradoraPastaLocal +"/arquivos/";
        public static String diretorioPastaProntos = "/home/"+nomeComputador+"/"+ nomeSeguradoraPastaLocal +"/prontos/";
        public static String diretorioPastaStatus = "/home/"+nomeComputador +'/'+ nomeSeguradoraPastaLocal +"/status/";
        public static String diretorioPastaBackup = "/home/"+nomeComputador +'/'+ nomeSeguradoraPastaLocal +"/backup/";
        public static String diretorioSeguradora = "/home/"+nomeComputador +'/'+ nomeSeguradoraPastaLocal;
        public static String diretorioPastaPdf = "/home/"+nomeComputador +'/'+ nomeSeguradoraPastaLocal +"/pdf/";
        public static String diretorioCotacao = "/home/"+nomeComputador +'/'+ nomeSeguradoraPastaLocal +"/cotacao/";

        // gerenciadores de diretorios de auxilo na vm
        public static String diretorioFerramentasMover = "/home/"+nomeComputador+ "/ferramentas/mover/";
        public static String diretorioFerramentas = "/home/"+nomeComputador+ "/ferramentas/";

        // freenas
        private static final String servidorFreenas = "/run/user/1000/gvfs/smb-share:server=freenas.local,share="+
                "arquivosgerais/E/LABSEG/apolice/"+
                "rd/result/" +
                nomeSeguradoraPastaDistribuirFreenas.toLowerCase();

        // gerenciadores de diretorios de arquivos
        public static String diretorioArquivosVm = "/home/" + nomeComputador + "/" + nomeSeguradoraPastaLocal + "/arquivos/";
        public static String diretorioArquivosFreenas = servidorFreenas + "/prontos/distribuir/";
        public static String diretorioResumoFreenas =  servidorFreenas + "/prontos/cotacao/";
        public static String diretorioResumoVm = "/home/" + nomeComputador + "/" + nomeSeguradoraPastaLocal+ "/cotacao/";




}
