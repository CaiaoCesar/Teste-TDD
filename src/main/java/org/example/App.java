package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 * @author CaioCesar
 */
public class App {
    public static void main(String[] args) {
        try (Scanner leitor = new Scanner(System.in)) {
            System.out.println("Qual o valor: ");
            String digito = leitor.next();
            System.out.println(digito);
        }

        App.leituraArquivo("src/main/java/org/example/Arquivo_Nucletideos_txt");

        //App.calculaNucleotideos();
    }

    public static void leituraArquivo(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

  /* public static void calculaNucleotideos(){
        return arrayInteiro;
    }
    */



