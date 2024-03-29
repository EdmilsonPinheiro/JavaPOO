import java.io.*;
import java.util.ArrayList;

class Jogador {
    private int id, altura, peso, anoNascimento;
    private String nome, universidade, cidadeNascimento, estadoNascimento;

    Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento) {
        this.id = id;
        this.altura = altura;
        this.peso = peso;
        this.anoNascimento = anoNascimento;
        this.nome = nome;
        this.universidade = universidade;
        this.cidadeNascimento = cidadeNascimento;
        this.estadoNascimento = estadoNascimento;
    }

    Jogador() {

    }

    public void imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ## ")
                .append(id).append(" ## ")
                .append(nome).append(" ## ")
                .append(altura).append(" ## ")
                .append(peso).append(" ## ")
                .append(anoNascimento).append(" ## ")
                .append(campoNaoInformado(universidade)).append(" ## ")
                .append(campoNaoInformado(cidadeNascimento)).append(" ## ")
                .append(campoNaoInformado(estadoNascimento))
                .append(" ##\n");
        System.out.print(sb.toString());
    }

    public void imprimir(int posicao) {
        System.out.printf("[%d]", posicao);
        imprimir();
    }

    private String campoNaoInformado(String campo) {
        return campo.isEmpty() ? "nao informado" : campo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public String getUniversidade() {
        return universidade;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public String getEstadoNascimento() {
        return estadoNascimento;
    }
}

class ListaJogadores {
    private ArrayList<Jogador> lista;

    public ListaJogadores() {
        lista = new ArrayList<>();
    }

    public void inserirInicio(Jogador jogador) {
        lista.add(0, jogador);
    }

    public void inserir(Jogador jogador, int posicao) {
        if (posicao < 0 || posicao > lista.size()) {
            System.out.println("Erro: Posição inválida.");
            return;
        }
        lista.add(posicao, jogador);
    }

    public void inserirFim(Jogador jogador) {
        lista.add(jogador);
    }

    public Jogador removerInicio() {
        if (lista.isEmpty()) {
            System.out.println("Erro: Lista vazia.");
            return null;
        }
        return lista.remove(0);
    }

    public Jogador remover(int posicao) {
        if (posicao < 0 || posicao >= lista.size()) {
            System.out.println("Erro: Posição inválida.");
            return null;
        }
        return lista.remove(posicao);
    }

    public Jogador removerFim() {
        if (lista.isEmpty()) {
            System.out.println("Erro: Lista vazia.");
            return null;
        }
        return lista.remove(lista.size() - 1);
    }

    public void mostrar() {
        int posicao = 0;
        for (Jogador jogador : lista) {
            jogador.imprimir(posicao);
            posicao++;
        }
    }
}

public class ListaEncadeada {
    private ArrayList<Jogador> jogadores = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    	ListaEncadeada aplicacao = new ListaEncadeada();
        aplicacao.carregarJogadores("/tmp/jogadores.txt");

        ListaJogadores lista = new ListaJogadores();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        do {
            entrada = reader.readLine();
            if (!entrada.equals("FIM")) {
                int id = Integer.parseInt(entrada);
                Jogador jogador = aplicacao.jogadores.get(id);
                lista.inserirFim(jogador);
            }
        } while (!entrada.equals("FIM"));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] comando = reader.readLine().split(" ");
            if (comando[0].equals("II")) {
                int id = Integer.parseInt(comando[1]);
                Jogador jogador = aplicacao.jogadores.get(id);
                lista.inserirInicio(jogador);
            } else if (comando[0].equals("I*")) {
                int id = Integer.parseInt(comando[2]);
                int posicao = Integer.parseInt(comando[1]);
                Jogador jogador = aplicacao.jogadores.get(id);
                lista.inserir(jogador, posicao);
            } else if (comando[0].equals("IF")) {
                int id = Integer.parseInt(comando[1]);
                Jogador jogador = aplicacao.jogadores.get(id);
                lista.inserirFim(jogador);
            } else if (comando[0].equals("RI")) {
                Jogador jogadorRemovido = lista.removerInicio();
                if (jogadorRemovido != null) {
                    System.out.println("(R) " + jogadorRemovido.getNome());
                }
            } else if (comando[0].equals("R*")) {
                int posicao = Integer.parseInt(comando[1]);
                Jogador jogadorRemovido = lista.remover(posicao);
                if (jogadorRemovido != null) {
                    System.out.println("(R) " + jogadorRemovido.getNome());
                }
            } else if (comando[0].equals("RF")) {
                Jogador jogadorRemovido = lista.removerFim();
                if (jogadorRemovido != null) {
                    System.out.println("(R) " + jogadorRemovido.getNome());
                }
            }
        }
        lista.mostrar();
        reader.close();
    }

    private void carregarJogadores(String arquivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        String linha;
        reader.readLine();
        while ((linha = reader.readLine()) != null) {
            String[] campos = linha.split(",", -1);
            int id = Integer.parseInt(campos[0]);
            String nome = campos[1];
            int altura = Integer.parseInt(campos[2]);
            int peso = Integer.parseInt(campos[3]);
            String universidade = campos.length > 4 ? campos[4] : "";
            int anoNascimento = Integer.parseInt(campos[5]);
            String cidadeNascimento = campos.length > 6 ? campos[6] : "";
            String estadoNascimento = campos.length > 7 ? campos[7] : "";

            Jogador jogador = new Jogador(id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
            jogadores.add(jogador);
        }
        reader.close();
    }
}
