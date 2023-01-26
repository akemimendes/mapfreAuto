package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PegarArquivos {

    private static List<String> numlinha = new ArrayList<String>();
    private static List<String> list = new ArrayList<String>();


    public List<String> carregarArquivos() throws IOException {
        File[] files = new File("/home/robertinho/mapfre/arquivos/").listFiles();
//If this pathname does not denote a directory, then listFiles() returns null.
        for (File file : files) {
            if (file.isFile()) {
                numlinha.add(file.getName());
            }
        }



        return numlinha;
    }
}
