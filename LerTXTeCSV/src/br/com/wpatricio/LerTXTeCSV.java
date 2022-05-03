/* Fontes:
 * https://github.com/devsuperior/aulao002
 * https://www.youtube.com/watch?v=xLDViuYlqGM
 * 
 * Objetivo:
 * Ler um arquivo texto utilizando a classe file e a classe scanner.
 */
package br.com.wpatricio;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Adptado por Wanderley Patrício de Sousa Neto
 */
public class LerTXTeCSV {

    public static void main(String[] args) {
        File file = new File("C:\\0\\in.txt"); // instanciando um arquivo
        Scanner scanner = null;                // Scannner pode ler dados da entrada padrão ou de um arquivo
                                               // foi declarado fora do bloco de escopo try pois vou 
                                               // fechar o scanner no final do processo para liberar recursos.
        try {
            scanner = new Scanner(file);       // instanciei o scanner
            while (scanner.hasNextLine()) {    // hasNextLine retorna verdadeiro se houver outra linha
                                               //Se scanner.hasNextLine ficar sublinhado de vermelho é 
                                               //um erro indicando uma exceção FileNotFoundException
//              String line = scanner.nextLine(); //ou declarando em uma linha só.
//              System.out.println(line);
                System.out.println(scanner.nextLine()); // se eu uso dessa forma não preciso criar variável String
            }
            
//            scanner.close(); // Se colocar nesse ponto do código e acontecer uma exceção o código pulará para o bloco catch
                               // e o programa jamais fechará o scanner. Então atente-se para o correto local para fechar o scanner.
            
        } catch (IOException e) {                  // Pode-se colocar o FileNotFoundException ou se quiser ser mais genérico usar o
                System.out.println(e.getMessage());// IOException, que é um tipo de exceção genérica que irá tratar todo tipo de exceção de                                          
        }                                          // entrada e saída. Ex.: Arquivo não encotrado ou não tem permissão de leitura naquela pasta, etc.
    
        finally{ // finally é um bloco que vai executar mesmo se der certo ou errado (ele sempre é executado. Então para fechamento de recurso
                 // convém colocar tudo dentro do bloco finally.
            if(scanner != null){ // Outro ponto, se der uma exceção na hora de instânciar o scanner e o arquivo não for aberto eu não terei o que fechar.
                scanner.close(); // Vai gerar uma exceção de ponteiro nulo ou NullPointerException. Para resolver o problema é garantir o fechamento uso o commando if
            }                    
        }
    }
}
