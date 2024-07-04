import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.LocalDate;

/**
 * Representa um jogo de futebol entre duas equipes.
 */
public class Jogo {
    private Equipa mandante;
    private Equipa visitante;
    private LocalDate dataDoJogo;
    private String estadio;
    private String cidade;
    private Integer placarMandante;
    private Integer placarVisitante;
    private List<Jogador> escalacaoMandante;
    private List<Jogador> escalacaoVisitante;
    private List<String> eventos;

     /**
     * Construtor padrão que inicializa a lista de eventos.
     */
    public Jogo() {
        this.eventos = new ArrayList<>();
    }

        /**
     * Construtor que recebe informações sobre as equipes, data, estádio e cidade do jogo.
     * Inicializa a lista de eventos e configura a escalação inicial das equipes.
     * 
     * @param mandante A equipe mandante.
     * @param visitante A equipe visitante.
     * @param dataDoJogo A data do jogo.
     * @param estadio O nome do estádio onde o jogo será realizado.
     * @param cidade A cidade onde o jogo será realizado.
     */
    public Jogo(Equipa mandante, Equipa visitante, LocalDate dataDoJogo, String estadio, String cidade) {
        this();
        this.mandante = mandante;
        this.visitante = visitante;
        this.dataDoJogo = dataDoJogo;
        this.estadio = estadio;
        this.cidade = cidade;
        this.placarMandante = 0;
        this.placarVisitante = 0;
        // Define a escalação inicial das equipes (os 11 primeiros jogadores de cada equipe)
        this.escalacaoMandante = mandante.getPlantel().subList(0, 11);
        this.escalacaoMandante = mandante.getPlantel().subList(0, 11);
        this.escalacaoVisitante = visitante.getPlantel().subList(0, 11);
    }

     /**
     * Obtém a lista de eventos ocorridos durante o jogo.
     * 
     * @return A lista de eventos.
     */
    public List<String> getEventos() {
        return eventos;
    }

    /**
     * Gera um relatório do resultado final do jogo.
     * 
     * @return O resultado final do jogo no formato "Mandante placar x placar Visitante".
     */
    public String relatorioResultado() {
        return "Resultado Final: " + mandante.getNome() + " " + placarMandante + " x " + placarVisitante + " " + visitante.getNome();
    }

     /**
     * Simula o resultado do jogo gerando os placares de mandante e visitante.
     * Os placares são gerados aleatoriamente com diferentes probabilidades.
     */
    public void gerarResultado() {
        
        Random random = new Random();
        int probabilidade = random.nextInt(100) + 1;

        if (probabilidade <= 50) {
            this.placarMandante = random.nextInt(5);
            this.placarVisitante = random.nextInt(5);
            eventos.add("Resultado: " + mandante.getNome() + " " + placarMandante + " x " + placarVisitante + " " + visitante.getNome());
        } else if (probabilidade <= 80) {
            this.placarMandante = random.nextInt(4);
            this.placarVisitante = random.nextInt(4);
            eventos.add("Resultado: " + mandante.getNome() + " " + placarMandante + " x " + placarVisitante + " " + visitante.getNome());
        } else {
            this.placarMandante = random.nextInt(5);
            this.placarVisitante = this.placarMandante;
            eventos.add("Resultado: " + mandante.getNome() + " " + placarMandante + " x " + placarVisitante + " " + visitante.getNome());
        }
    }
    
    /**
     * Simula lesões durante o jogo, reduzindo a qualidade de jogadores de forma aleatória.
     */
    public void gerarLesoes() {
        Random random = new Random();
        int lesoes = random.nextInt(3); // Gera de 0 a 2 lesões

        for (int i = 0; i < lesoes; i++) {
            Equipa equipeLesionada = random.nextBoolean() ? mandante : visitante;
            Jogador jogadorLesionado = equipeLesionada.getPlantel().get(random.nextInt(equipeLesionada.getPlantel().size()));
            jogadorLesionado.sofrerLesao();
            eventos.add("Lesão: " + jogadorLesionado.getNome() + " sofreu uma lesão.");
        }
    }

     /**
     * Simula a distribuição de cartões durante o jogo, aplicando cartões amarelos aleatoriamente aos jogadores.
     * Se um jogador receber mais de um cartão amarelo, ele é suspenso.
     */

    public void gerarCartoes() {
        Random random = new Random();
        int cartoes = random.nextInt(11); // Gera de 0 a 10 cartões

        for (int i = 0; i < cartoes; i++) {
            Equipa equipeCartao = random.nextBoolean() ? mandante : visitante;
            Jogador jogadorCartao = equipeCartao.getPlantel().get(random.nextInt(equipeCartao.getPlantel().size()));
            jogadorCartao.aplicarCartao(1);

            eventos.add("Cartão: " + jogadorCartao.getNome() + " recebeu um cartão Amarelo.");

            if (jogadorCartao.getCartoes() > 1) {
                eventos.add("Suspensão: " + jogadorCartao.getNome() + " foi Suspenso.");
            }
        }
    }

    /**
     * Permite que os jogadores das equipes realizem treinamento antes do jogo.
     * Reseta o status de treinamento de todos os jogadores.
     */
    public void permitirTreinamento() {
        mandante.getPlantel().forEach(Jogador::resetarTreinamento);
        visitante.getPlantel().forEach(Jogador::resetarTreinamento);
    }

     /**
     * Gera um relatório detalhado da partida, incluindo informações sobre a data, estádio, escalação das equipes e eventos ocorridos durante o jogo.
     * 
     * @return O relatório detalhado da partida.
     */
    public String relatorioPartida() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório da partida:\n");
        relatorio.append("Data: ").append(dataDoJogo).append("\n");
        relatorio.append("Estádio: ").append(estadio).append(", ").append(cidade).append("\n\n");
        relatorio.append("Escalação Mandante: ").append(mandante.getNome()).append("\n");
        escalacaoMandante.forEach(jogador -> relatorio.append(jogador).append("\n"));
        relatorio.append("\nEscalação Visitante: ").append(visitante.getNome()).append("\n");
        escalacaoVisitante.forEach(jogador -> relatorio.append(jogador).append("\n"));
        relatorio.append("\nEventos do Jogo:\n");
        eventos.forEach(evento -> relatorio.append(evento).append("\n"));
        relatorio.append("\nResultado Final: ").append(mandante.getNome()).append(" ").append(placarMandante).append(" x ").append(placarVisitante).append(" ").append(visitante.getNome()).append("\n");
        return relatorio.toString();
    }
}