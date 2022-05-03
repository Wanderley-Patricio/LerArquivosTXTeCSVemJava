/* Fontes:
 * https://github.com/devsuperior/aulao002
 * https://www.youtube.com/watch?v=xLDViuYlqGM
 * 
 * Objetivo:
 * Ler um arquivo texto utilizando as classes FileReader e BufferedReader, com controle manual.
 */
package br.com.wpatricio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



/**
 * @author Adptado por Wanderley Patrício de Sousa Neto
 */
public class LerTXTeCSV {

    public static void main(String[] args) {
        String path = "C:\\0\\in.txt";
        FileReader fr = null;   // 1º instancio o FileReader para termos uma referência de entrada do arquivo a ser lido. Depois,
        BufferedReader br = null; // em cima do FileReader vou instanciar o BufferedReader
                                // BufferedReader gerencia a memória usada para leitura, é uma classe mais otimizada e mais rápida.
        try{
            fr = new FileReader(path);   // 1º instancio o FileReader
            br = new BufferedReader(fr); // 2º passo o FileReader como argumento para o BufferedReader. A partir da variável br eu 
                                         // já tenho acesso a ficar lendo o arquivo.
                                         // MACETE: Sempre que for ler um arquivo de texto leia linha a linha e faça o tratamento 
                                         // nessa linha se for necessário.
            String line = br.readLine(); // para ler uma linha eu uso o método readLine
            while(line != null){         // se eu chegar no final do arquivo o método readline() me retorna nulo. 
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage() );
        }
        finally{
            try{
                br.close(); // se fechar br e fr sem tratar pode gerar uma exceção
                fr.close();
            }
            catch(IOException e){   // se chegar nesse ponto não tem muito o que se fazer pois está gerando um erro na hora de fechar o arquivo.
               e.printStackTrace(); // Imprime na tela todo o StackTrace para análisarmos o que aconteceu. Já que não temos muito o que fazer para tratar.
            }
        }
    }
}
