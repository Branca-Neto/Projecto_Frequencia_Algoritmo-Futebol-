import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Representa uma equipe de futebol.
 */
public class Equipa {
    private String nome;
    private String apelido;
    private LocalDate fundacao;
    private List<Jogador> plantel;
    private List<Jogador> relacionadosTitulares;
    private List<Jogador> relacionadosReservas;

    
    /**
     * Construtor que inicializa a equipe com nome, apelido e data de fundação.
     * Inicializa as listas de plantel, titulares e reservas vazias.
     * 
     * @param nome O nome da equipe.
     * @param apelido O apelido ou alcunha da equipe.
     * @param fundacao A data de fundação da equipe.
     */
    public Equipa(String nome, String apelido, LocalDate fundacao) {
        this.nome = nome;
        this.apelido = apelido;
        this.fundacao = fundacao;
        this.plantel = new ArrayList<>();
        this.relacionadosTitulares = new ArrayList<>();
        this.relacionadosReservas = new ArrayList<>();
    }

     /**
     * Adiciona um jogador ao plantel da equipe.
     * 
     * @param jogador O jogador a ser adicionado.
     */
    public void adicionarJogador(Jogador jogador) {
        this.plantel.add(jogador);
    }

     /**
     * Obtém o nome da equipe.
     * 
     * @return O nome da equipe.
     */
    public String getNome() {
        return nome;
    }

     /**
     * Obtém o plantel completo da equipe.
     * 
     * @return O plantel da equipe.
     */
    public List<Jogador> getPlantel() {
        return plantel;
    }

    
    /**
     * Relaciona os jogadores do plantel como titulares e reservas para um jogo.
     * Os jogadores são ordenados por qualidade e os melhores são escolhidos como titulares.
     */

     public void relacionarJogadores() {
        List<Jogador> jogadoresOrdenados = plantel.stream()
                .sorted((j1, j2) -> Integer.compare(j2.getQualidade(), j1.getQualidade()))
                .collect(Collectors.toList());
        this.relacionadosTitulares = jogadoresOrdenados.subList(0, Math.min(11, jogadoresOrdenados.size()));
        this.relacionadosReservas = jogadoresOrdenados.subList(11, Math.min(18, jogadoresOrdenados.size()));
    }
    
    
     /**
     * Imprime a escalação da equipe, mostrando os titulares e reservas.
     */
    public void imprimirEscalacao() {
        System.out.println("Equipe: " + nome);
        System.out.println("Titulares:");
        if (!relacionadosTitulares.isEmpty()) {
            relacionadosTitulares.forEach(jogador -> System.out.println(jogador));
        } else {
            System.out.println("Não há titulares suficientes.");
        }
        System.out.println("Reservas:");
        if (!relacionadosReservas.isEmpty()) {
            relacionadosReservas.forEach(jogador -> System.out.println(jogador));
        } else {
            System.out.println("Não há reservas suficientes.");
        }
    }
}