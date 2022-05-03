/* Fontes:
 * https://github.com/devsuperior/aulao002
 * https://www.youtube.com/watch?v=xLDViuYlqGM
 * 
 * Objetivo:
 * Ler um arquivo texto utilizando o bloco 'try with resources'.
 * o try with resources permite eu declarar o bloco try já instanciando os recursos na mesma linha do try.
 * A vantagem é que tudo que eu instanciar de recursos nessa mesma linha do try vai ser desalocado de forma
 * automática quando o escopo do try acabar
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
      
        try(BufferedReader br = new BufferedReader(new FileReader(path))){ // criei o bloco try já instanciando os recursos
          //  fr = new FileReader(path);   // Eu instanciei o BufferedReader e passei a instância do FileReader já como parâmetro
          //  br = new BufferedReader(fr); // para o bloco try
                                         
            String line = br.readLine(); // para ler uma linha eu uso o método readLine
            while(line != null){         // se eu chegar no final do arquivo o método readline() me retorna nulo. 
                System.out.println(line);
                line = br.readLine();
            }
        } // quando o programa chegar aqui ou acontecer uma exceção e cair no bloco catch, automaticamente os recursos instanciados pelo try serão desalocados.
          // Outra vantagem desse método é que como ele já desaloca os recursos automaticamente eu não preciso do bloco finally
        catch(IOException e){
            System.out.println("Error: " + e.getMessage() );
        }
    }
}
