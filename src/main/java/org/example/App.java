package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Hello world!
 * @author CaioCesar
 */
public class App {
    public static void main(String[] args) {
        try (Scanner leitor = new Scanner(System.in)) {
            System.out.println("Calculo de Nucletideos: ");
        }

        String caminhoArquivo = "src/main/java/org/example/Arquivo_Nucletideos_txt";
        calculaNucleotideos(caminhoArquivo);

        //App.calculaNucleotideos();
    }

    public static String leituraArquivo(String caminhoArquivo) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conteudo.toString();
    }

    public static void calculaNucleotideos(String caminhoArquivo){
        String conteudo = leituraArquivo(caminhoArquivo);
        String letrasValidas = "ACGT";

        for (char letra: conteudo.toCharArray()){
            if (letrasValidas.indexOf(letra) == -1) {
                System.out.println("Erro pois o caractere informado é inválido");
                return;
            }
        }
        System.out.println("Calculo feito com sucesso");
        }

}







