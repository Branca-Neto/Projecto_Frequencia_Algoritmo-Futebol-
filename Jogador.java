import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um jogador de futebol.
 */

public class Jogador {
    private int id;
    private String nome;
    private String apelido;
    private LocalDate dataNascimento;
    private int numero;
    private String posicao;
    private int qualidade;
    private int cartoes;
    private boolean suspenso;
    private boolean treinamentoExecutado;



 /**
     * Construtor da classe Jogador.
     * @param id o ID do jogador
     * @param nome o nome do jogador
     * @param apelido o apelido do jogador
     * @param dataNascimento a data de nascimento do jogador
     * @param numero o número da camisa do jogador
     * @param posicao a posição em campo do jogador
     * @param qualidade a qualidade técnica do jogador
     */

    public Jogador(int id, String nome, String apelido, LocalDate dataNascimento, int numero, String posicao, int qualidade) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.numero = numero;
        this.posicao = posicao;
        this.qualidade = qualidade;
        this.cartoes = 0;
        this.suspenso = false;
        this.treinamentoExecutado = false;
    }

    public int getQualidade() {
        return qualidade;
    }

    public String getNome() {
        return nome;
    }

    public int getCartoes() {
        return cartoes;
    }

     /** serve para verificar se o jogador está suspenso de participar de partidas  */

    public boolean isSuspenso() {
        return suspenso;
    }

    public static boolean verificarCondicaoDeJogo(Jogador jogador) {
        return !jogador.isSuspenso() && jogador.getQualidade() >= 70 && jogador.treinamentoExecutado();
    }


    public boolean treinamentoExecutado() {
        return treinamentoExecutado;
    }
    /**
     * Método para aplicar uma lesão ao jogador, diminuindo sua qualidade técnica.
     */
    public void sofrerLesao() {
        this.qualidade -= 5;
    }

    /**
     * Método para aplicar um cartão ao jogador e verificar se ele será suspenso.
     * @param quantidade a quantidade de cartões a ser aplicada
     */
    public void aplicarCartao(int quantidade) {
        this.cartoes += quantidade;
        if (this.cartoes > 1) {
            this.suspenso = true;
        }
    }

     /**
      * Este método define o jogador como não suspenso e zera a quantidade de cartões 
       */

    public void cumprirSuspensao() {
        this.cartoes = 0; // Zera a quantidade de cartões
        this.suspenso = false; // Torna o jogador apto a jogar
    }

    public void executarTreinamento() {
        this.treinamentoExecutado = true;
    }
    
    /**
     * Método para resetar o status de treinamento do jogador.
     */

    public void resetarTreinamento() {
        this.treinamentoExecutado = false;
    }

     /**
     * Representação em String do jogador.
     * @return uma string contendo informações sobre o jogador
     */
    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", numero=" + numero +
                ", posicao='" + posicao + '\'' +
                ", qualidade=" + qualidade +
                ", cartoes=" + cartoes +
                ", suspenso=" + suspenso +
                '}';
    }
}