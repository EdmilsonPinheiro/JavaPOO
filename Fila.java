import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader
import java.io.FileReader;
import java.util.Arraylist;
import java.util.Scanner;


public class Jogador{

    //Celula de variaveis para cada jogador
class CelulaJogador{
    private int id;
    private String nome = "";
    private int altura;
    private int peso;
    private String cidade = "";
    private int nascimento;
}

    public celulaJogador(int id, String nome, int altura, int peso, String cidade, int nascimento){
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.cidade = cidade;
        this.nascimento = nascimento;
    }

    //Função de leitura do arquivo
    public static void Leiturat(int id, String nome, int altura, int peso, String cidade, int nascimento) {

        /*int id;
        String nome = "";
        int altura;                 //Não sei se é necessário essas variáveis aqui
        int peso;
        String cidade = "";
        int nascimento;*/
       
        
    //Abertura do arquivo e leitura de cada linha
        File arquivo = new File("pub-in-4.txt");
        
            FileReader leitArquivo = new FileReader(arquivo);
            BufferedReader leitLinha = new BufferedReader(leitArquivo);

            String linha;

    //Registro das informações nas variáveis 
        while((linha = leitLinha.readline()) != null){
            String[] partes = linha.split(",");
                id = partes[0].trim();
                nome = partes[1].trim();
                altura = partes[2].trim();
                peso = partes[3].trim();
                cidade = partes[4].trim();
                nascimento = partes[5].trim();

                //Armazenando as informaações de cada jogador
                CelulaJogador jogador = new CelulaJogador(id , nome , altura , peso , cidade , nascimento);
                Jogador.enfileirar(jogador);
           } 

    //Fechamento do arquivo
            buffer.close();
            leitor.close();
    }

    //Função de enfileirar por meio de vetores
    public static void enfileirar(int id, String nome, int altura, int peso, String cidade, int nascimento) {
        
        int tamanhoVetor = 5;
        int contador = 0;
        String[] vetor = new String(tamanhoVetor);

        for(int i = 0, i < vetor.length, i++){
            vetor[i] = jogador;
            Jogador.imprimir(vetor[]);
            contador++;
            if (contador == vetor.length){
                Jogador.desenfileirar(vetor);
            }
        }

    }

    //Função de imprimir as informações do vetor enfileirado
    public static void imprimir(String[] vetor) {
        for(int i = 0, i < 5, i++){
            System.out.println(vetor[i]);
        }
    }
    //Função de desenfileirar por meio de vetores
    public static void desenfileirar() {
        
    }
}