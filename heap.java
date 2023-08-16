class Jogador {
    private String id;
    private String nome;
    private String altura;
    private String peso;
    private String universidade;
    private String anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    Jogador(String id, String nome, String altura, String peso, String universidade, String anoNascimento, String cidadeNascimento, String estadoNascimento) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.universidade = universidade;
        this.anoNascimento = anoNascimento;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", altura='" + altura + '\'' +
                ", peso='" + peso + '\'' +
                ", universidade='" + universidade + '\'' +
                ", anoNascimento='" + anoNascimento + '\'' +
                ", cidadeNascimento='" + cidadeNascimento + '\'' +
                ", estadoNascimento='" + estadoNascimento + '\'' +
                '}';
    }
}

public class Jogador2 {
    public static void main(String[] args) {
        ArquivoTextoLeitura leitorContagem = new ArquivoTextoLeitura("jogadores.txt");
        int quantidadeLinhas = 0;

        while (leitorContagem.ler() != null) {
            quantidadeLinhas++;
        }

        leitorContagem.fecharArquivo();

        ArquivoTextoLeitura leitor = new ArquivoTextoLeitura("jogadores.txt");
        Jogador[] jogadores = new Jogador[quantidadeLinhas];
        int indice = 0;

        while (indice < quantidadeLinhas) {
            String linha = leitor.ler();

            if (linha != null && !linha.isEmpty()) {
                String[] valores = linha.split(",");

                if (valores.length == 8) {
                	String id = valores[0].trim().isEmpty() ? "nao informado" : valores[0].trim();;
                    String nome = valores[1].trim().isEmpty() ? "nao informado" : valores[1].trim();
                    String altura = valores[2].trim().isEmpty() ? "nao informado" : valores[2].trim();
                    String peso = valores[3].trim().isEmpty() ? "nao informado" : valores[3].trim();
                    String universidade = valores[4].trim().isEmpty() ? "nao informado" : valores[4].trim();
                    String anoNascimento = valores[5].trim().isEmpty() ? "nao informado" : valores[5].trim();
                    String cidadeNascimento = valores[6].trim().isEmpty() ? "nao informado" : valores[6].trim();
                    String estadoNascimento = valores[7].trim().isEmpty() ? "nao informado" : valores[7].trim();
                    Jogador jogador = new Jogador(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
                    jogadores[indice] = jogador;
                    indice++;
                } else if (valores.length == 7) {
                	String id = valores[0].trim().isEmpty() ? "nao informado" : valores[0].trim();;
                    String nome = valores[1].trim().isEmpty() ? "nao informado" : valores[1].trim();
                    String altura = valores[2].trim().isEmpty() ? "nao informado" : valores[2].trim();
                    String peso = valores[3].trim().isEmpty() ? "nao informado" : valores[3].trim();
                    String universidade = valores[4].trim().isEmpty() ? "nao informado" : valores[4].trim();
                    String anoNascimento = valores[5].trim().isEmpty() ? "nao informado" : valores[5].trim();
                    String cidadeNascimento = valores[6].trim().isEmpty() ? "nao informado" : valores[6].trim();
                    String estadoNascimento = "nao informado";
                    Jogador jogador = new Jogador(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
                    jogadores[indice] = jogador;
                    indice++;}
                else if (valores.length == 6) {
                	String id = valores[0].trim().isEmpty() ? "nao informado" : valores[0].trim();;
                    String nome = valores[1].trim().isEmpty() ? "nao informado" : valores[1].trim();
                    String altura = valores[2].trim().isEmpty() ? "nao informado" : valores[2].trim();
                    String peso = valores[3].trim().isEmpty() ? "nao informado" : valores[3].trim();
                    String universidade = valores[4].trim().isEmpty() ? "nao informado" : valores[4].trim();
                    String anoNascimento = valores[5].trim().isEmpty() ? "nao informado" : valores[5].trim();
                    String cidadeNascimento = "nao informado";
                    String estadoNascimento = "nao informado";
                    Jogador jogador = new Jogador(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
                    jogadores[indice] = jogador;
                    indice++;}
            }
        }

        leitor.fecharArquivo();
			heapsort();
			
		//Método de ordenação Heapsort       
	       public static void heapsort() {
	    int end = jogadores.length;
	
	    for (int i = end / 2 - 1; i >= 0; i--) {
	        heapify(jogadores, end, i);
	    }
	
	    for (int i = end - 1; i >= 0; i--) {
	        int temp = jogadores[0];
	        jogadores[0] = jogadores[i];
	        jogadores[i] = temp;
	
	        heapify(jogadores, i, 0);
	    }
	}
	    // Imprimir os jogadores ordenados
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
        }
    }}
