package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        System.out.println("Calculo de Nucletideos:\n");

        String caminhoArquivo = "src/main/java/org/example/Arquivo_Nucletideos_txt";
        calculaNucleotideos(caminhoArquivo);
    }

    // Método para ler o arquivo e retornar o conteúdo
    public static String leituraArquivo(String caminhoArquivo) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line); // Imprime o conteúdo do arquivo
                conteudo.append(line);    // Armazena a linha lida no StringBuilder
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException ime) {
            System.out.println("Entrada inválida: " + ime.getMessage());
        }
        return conteudo.toString(); // Retorna o conteúdo completo do arquivo como string
    }

    // Método para calcular e validar os nucleotídeos
    public static void calculaNucleotideos(String caminhoArquivo) {
        String conteudo = leituraArquivo(caminhoArquivo); // Lê o conteúdo do arquivo
        String letrasValidas = "ACGT"; // Letras válidas de nucleotídeos

        // Inicializa contadores
        int contagemA = 0;
        int contagemC = 0;
        int contagemG = 0;
        int contagemT = 0;
        int total = 0;

        // Percorre o conteúdo e conta a ocorrência de cada nucleotídeo
        for (char letra : conteudo.toCharArray()) {
            if (letrasValidas.indexOf(letra) == -1) { // Verifica se há caracteres inválidos
                System.out.println("Erro pois o caractere informado é inválido: " + letra);
                return; // Encerra o cálculo se houver erro
            } else {
                total++; // Conta o número total de nucleotídeos válidos
                switch (letra) {
                    case 'A':
                        contagemA++;
                        break;
                    case 'C':
                        contagemC++;
                        break;
                    case 'G':
                        contagemG++;
                        break;
                    case 'T':
                        contagemT++;
                        break;
                }
            }
        }

        // Calcula as porcentagens após contar todos os nucleotídeos
        double porcentagemA = (double) contagemA / total * 100;
        double porcentagemC = (double) contagemC / total * 100;
        double porcentagemG = (double) contagemG / total * 100;
        double porcentagemT = (double) contagemT / total * 100;

        // Exibe os resultados
        System.out.println("Total de caracteres válidos: " + total);
        System.out.printf("\nPorcentagem de 'A': %.2f%%\n", porcentagemA);
        System.out.printf("Porcentagem de 'C': %.2f%%\n", porcentagemC);
        System.out.printf("Porcentagem de 'G': %.2f%%\n", porcentagemG);
        System.out.printf("Porcentagem de 'T': %.2f%%\n", porcentagemT);

        System.out.println("\nCalculo feito com sucesso");
    }
}
