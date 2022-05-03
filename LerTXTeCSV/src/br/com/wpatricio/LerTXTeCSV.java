/* Fontes:
 * https://github.com/devsuperior/aulao002
 * https://www.youtube.com/watch?v=xLDViuYlqGM
 * 
 * Objetivo:
 * Como ler um arquivo .CSV e transformá-lo em uma lista de objetos em memória
 * Exemplo CSV separado por vírgula
 * Name,Price,Quantity
 * Notebook Gamer,2100.90,10
 * Smartphone X,1890.00,23
 * TV LED 70,3500.89,8
 */
package br.com.wpatricio;

import br.com.entidades.Produto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adptado por Wanderley Patrício de Sousa Neto
 */
public class LerTXTeCSV {

    public static void main(String[] args) {
        
        String path = "C:\\0\\in.csv";
        List<Produto> list = new ArrayList<Produto>(); // criei e instanciei uma lista do tipo Produto.
      
        try(BufferedReader br = new BufferedReader(new FileReader(path))){                           
            
            String line = br.readLine();        // ler a primeira (cabeçalho)
            line = br.readLine();               // vou ler a linha novamente já que descartei o cabeçalho, para pegar o produto.
            while(line != null){                // se eu chegar no final do arquivo o método readline() me retorna nulo. 
                String[] vetor = line.split(","); // a função split faz um recorte baseado em um padrão específico de separação de ítens, nesse exemplo a ",".
                String nome =  vetor[0];         
                Double preco = Double.parseDouble(vetor[1]); // uso o Double.parseDouble como um cast, para converter o texto que está em String para Double.
                Integer quantidade = Integer.parseInt(vetor[2]);
                
                Produto produto = new Produto(nome, preco, quantidade);
                list.add(produto);
                
                line = br.readLine();
            }
            System.out.println("Produtos: ");
            for (Produto p : list){ // para cada produto p na minha lista list eu vou mandar imprimir na tela esse p.
                System.out.println(p);
            }
           } // quando o programa chegar aqui ou acontecer uma exceção e cair no bloco catch, automaticamente os recursos instanciados pelo try serão desalocados.
          // Outra vantagem desse método é que como ele já desaloca os recursos automaticamente eu não preciso do bloco finally
        catch(IOException e){
            System.out.println("Error: " + e.getMessage() );
        }
    }
}
