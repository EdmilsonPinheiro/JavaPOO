import java.util.Scanner;
import java.util.Objects;

public class Metodos{
    private Metodos(){};

    public static void bolha() {
        int aux;

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                if(vetor[j] > vetor[j + 1]){
                    
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
    }

    public static void selecao() {
        int menor, aux;

        for(int i = 0; i < n; i++){

            menor = i;
            for(int j = 0; j < n; j++){

                if(vetor[j] < vetor[menor]){
                    menor = j;
                }
            }

            if(menor != i){
                aux = vetor[menor];
                vetor[menor] = vetor[i];
                vetor[i] = aux;
            }
        }
    }

    public static void insercao() {
        int aux , ant;

        for(int i = 2; i < n; i++){

            aux = vetor[i];
            ant = i - 1;

            while( x < vetor[ant]){
                
                vetor[ant + 1] = vetor[ant];
                ant--;
            }
            vetor[ant + 1] = aux;
        }
    }

    public static void mergesort(int[] vetor, int esquerda, int direita) {
        if(esquerda < direita){
            int meio = (esquerda + direita) / 2;

            Mergesort(vetor, esquerda, meio);
            Mergesort(vetor , meio + 1, direita);

            Merge(vetor, esquerda, meio, direita);

        }
    }

    public static void hepsort() {
        int n = arr.length;

        // Constrói a heap (rearranja o array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extrai um por um os elementos da heap
        for (int i=n-1; i>=0; i--) {
            // Move a raiz atual para o final do array ordenado
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // chama max heapify na heap reduzida
            heapify(arr, i, 0);
        }
    }
 
    public static void quicksort(int[] vetor) {
        int n = array.length;
        // Constrói a heap (rearranja o array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // A variável troca é usada para trocar valores de elementos no array durante o processo de ordenação. 
        // Extrai um por um os elementos da heap
        for (int i=n-1; i>=0; i--) {
            // Move a raiz atual para o final do array ordenado
            int troca = array[0];
            array[0] = array[i];
            array[i] = troca;

            // chama max heapify na heap reduzida
            heapify(array, i, 0);
        }
    }

    public static void printArray(int array[]) {
        int n = array.length;
        for (int i=0; i<n; ++i)
            System.out.print(array[i]+" ");
        System.out.println();
    }

    static void heapify(int array[], int n, int i) {
        int largest = i;  // Inicializa a maior raiz
        int l = 2 * i + 1;  // esquerda = 2i + 1
        int r = 2 * i + 2;  // direita = 2i + 2

        // Se a esquerda é maior que a raiz
        if (l < n && array[l] > array[largest])
            largest = l;

        // Se a direita é maior que a maior até agora
        if (r < n && array[r] > array[largest])
            largest = r;

        // Se a maior não é a raiz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursivamente constrói o heap
            heapify(array, n, largest);
        }
    }
    
    static void merge(int[]vetor, int esquerda, int meio, int direita) {
        int num1 = meio - esquerda + 1;
        int num2 = direita - meio;

        int[] esquerdaVetor = new int[num1];
        int[] direitaVetor = new int[num2];

        for(int i = 0; i < num1; i++){
            esquerdaVetor[i] = vetor[esquerda + i];
        }

        for(int j = 0; j < num2; j++){
            direitaVetor[j] = vetor[meio + 1 + j];
        }

        int i = 0, j = 0;
        int k = esquerda;

        while (i < num1 && j < num2){
            if( esquerdaVetor[i] <= direitaVetor[j]){
                vetor[k] = esquerdaVetor[j];
                i++;
            }else{
                vetor[k] = direitaVetor[j];
                j++;
            }
            k++;
        }

        while(i < num1){
            vetor[k] = esquerdaVetor[i];
            i++;
            k++;
        }

        while(i < num2){
            vetor[k] = direitaVetor[j];
            j++;
            k++;
        }
    }
}