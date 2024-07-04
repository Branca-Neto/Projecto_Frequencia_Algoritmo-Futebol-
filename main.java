import java.time.LocalDate;
import java.util.*;

/**
 * Classe principal que controla a interação do usuário com o sistema.
 */

public class Main {
    private static List<Equipa> equipes = new ArrayList<>();
    private static List<Jogo> historicoPartidas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1- Criar equipes");
            System.out.println("2- Adicionar jogadores às equipes");
            System.out.println("3- Relacionar Jogadores");
            System.out.println("4- Imprimir Escalação partida");
            System.out.println("5- Iniciar jogo");
            System.out.println("6- Relatório de partida");
            System.out.println("7- Procurar jogador por nome");
            System.out.println("8- Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcao) {
                case 1:
                    criarEquipes();
                    break;
                case 2:
                    adicionarJogadores();
                    break;
                case 3:
                    relacionarJogadores();
                    break;
                case 4:
                    imprimirEscalacaoPartida();
                    break;
                case 5:
                    iniciarJogo();
                    break;
                case 6:
                    relatorioPartida();
                    break;
                case 7:
                    procurarJogadorPorNome();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
     /**
     * Permite ao usuário criar equipes, fornecendo informações como nome, apelido e ano de fundação.
     */

    private static void criarEquipes() {
        System.out.print("Nome da equipe: ");
        String nome = scanner.nextLine();
        System.out.print("Apelido da equipe: ");
        String apelido = scanner.nextLine();
        System.out.print("Ano de fundação (YYYY): ");
        int ano = scanner.nextInt();
        System.out.print("Mês de fundação (MM): ");
        int mes = scanner.nextInt();
        System.out.print("Dia de fundação (DD): ");
        int dia = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Equipa equipe = new Equipa(nome, apelido, LocalDate.of(ano, mes, dia));
        equipes.add(equipe);
        System.out.println("Equipe criada com sucesso.");
    }
      /**
     * Permite ao usuário adicionar jogadores às equipes já criadas.
     */

    private static void adicionarJogadores() {
        if (equipes.isEmpty()) {
            System.out.println("Nenhuma equipe criada.");
            return;
        }
    
        Scanner scanner = new Scanner(System.in);
    
        // Nome da primeira equipe
        System.out.print("Nome da primeira equipe: ");
        String nomeEquipe1 = scanner.nextLine();
        Optional<Equipa> equipe1Opt = equipes.stream().filter(e -> e.getNome().equalsIgnoreCase(nomeEquipe1)).findFirst();
    
        if (equipe1Opt.isPresent()) {
            Equipa equipe1 = equipe1Opt.get();
    
            // Lista de jogadores para a primeira equipe
            List<Jogador> jogadoresEquipe1 = Arrays.asList(
                // Adicione os jogadores da primeira equipe aqui
                new Jogador(1, "Branca", "bani", LocalDate.of(1998, 12, 9), 1, "lateral", 100),
                new Jogador(2, "Nelio", "Nelito", LocalDate.of(1998, 12, 9), 2, "esquerda", 0),
                // Adicione os outros jogadores da primeira equipe aqui
                new Jogador(3, "Eva", "E", LocalDate.of(1998, 12, 9), 3, "Defesa", 90),
                new Jogador(4, "Hadja", "minela", LocalDate.of(1993, 2, 3), 5, "Ponta", 99),
                new Jogador(5, "Osvaldo", "apelido", LocalDate.of(1998, 12, 9), 6, "Ponta", 85),
                new Jogador(6, "Celio", "bani", LocalDate.of(1998, 12, 9), 1, "lateral", 10),
                new Jogador(7, "Neves", "Nelito", LocalDate.of(1998, 12, 9), 2, "esquerda", 100),
                new Jogador(8, "Evo", "E", LocalDate.of(1998, 12, 9), 3, "Esquerda", 80),
                new Jogador(9, "Novais", "minela", LocalDate.of(1998, 12, 9), 5, "qq", 79),
                new Jogador(10, "Kinwane", "apelido", LocalDate.of(1998, 12, 9), 6, "defesa", 5),
                new Jogador(11, "neto", "bani", LocalDate.of(1998, 12, 9), 1, "lateral", 100),
                new Jogador(12, "Peterson", "Nelito", LocalDate.of(1998, 12, 9), 2, "esquerda", 60),
                new Jogador(13, "Elvis", "E", LocalDate.of(1998, 12, 9), 3, "Central", 50),
                new Jogador(14, "Ramos", "minela", LocalDate.of(1998, 12, 9), 5, "qq", 39),
                new Jogador(15, "Oliveira", "apelido", LocalDate.of(1998, 12, 9), 6, "lateral", 10),
                new Jogador(16, "Nelson", "bani", LocalDate.of(1997, 2, 5), 1, "lateral", 14),
                new Jogador(17, "Nelito", "Nelito", LocalDate.of(1996, 4, 2), 2, "esquerda", 60),
                new Jogador(18, "Ricardo", "E", LocalDate.of(1995, 1, 8), 3, "Esquerda", 96),
                new Jogador(19, "minela", "minela", LocalDate.of(1994, 11, 3), 5, "ponta", 55),
                new Jogador(20, "Luvumbo", "apelido", LocalDate.of(1998, 2, 8), 6, "Central", 77),
                new Jogador(21, "Zito", "bani", LocalDate.of(1998, 12, 9), 1, "lateral", 88),
                new Jogador(22, "Nito", "Nelito", LocalDate.of(1994, 12, 9), 2, "esquerda", 30),
                new Jogador(23, "Elis", "E", LocalDate.of(1998, 12, 9), 3, "Central", 40)
            );
    
            for (Jogador jogador : jogadoresEquipe1) {
                equipe1.adicionarJogador(jogador);
            }
    
            System.out.println("Jogadores adicionados com sucesso na equipe: " + nomeEquipe1);
        } else {
            System.out.println("Primeira equipe não encontrada.");
            return;
        }
    
        // Nome da segunda equipe
        System.out.print("Nome da segunda equipe: ");
        String nomeEquipe2 = scanner.nextLine();
        Optional<Equipa> equipe2Opt = equipes.stream().filter(e -> e.getNome().equalsIgnoreCase(nomeEquipe2)).findFirst();
    
        if (equipe2Opt.isPresent()) {
            Equipa equipe2 = equipe2Opt.get();
    
            // Lista de jogadores para a segunda equipe
            List<Jogador> jogadoresEquipe2 = Arrays.asList(
                // Adicione os jogadores da segunda equipe aqui
                new Jogador(1, "Costa", "Costinha", LocalDate.of(2002, 8, 9), 1, "lateral", 100),
                new Jogador(2, "Joy", "Nelito", LocalDate.of(2003, 12, 9), 2, "esquerda", 0),
                // Adicione os outros jogadores da segunda equipe aqui
                new Jogador(3, "Toniel", "E", LocalDate.of(1997, 1, 9), 3, "central", 90),
                new Jogador(4, "Pavi", "minela", LocalDate.of(1986, 2, 9), 5, "cental", 99),
                new Jogador(5, "Gregorio", "apelido", LocalDate.of(1981, 12, 9), 6, "Ponta", 85),
                new Jogador(6, "Franisco", "bani", LocalDate.of(1978, 3, 9), 1, "lateral", 10),
                new Jogador(7, "Afonso", "Nelito", LocalDate.of(1998, 4, 8), 2, "esquerda", 100),
                new Jogador(8, "Antonio", "E", LocalDate.of(1987, 11, 5), 3, "Ponta", 80),
                new Jogador(9, "Menese", "minela", LocalDate.of(1998, 10, 9), 5, "qq", 79),
                new Jogador(10, "Olimpio", "apelido", LocalDate.of(1998, 12, 9), 6, "Defesa", 5),
                new Jogador(11, "Silvs", "bani", LocalDate.of(1998, 12, 9), 1, "lateral", 100),
                new Jogador(12, "Cardoso", "Nelito", LocalDate.of(1998, 12, 9), 2, "esquerda", 60),
                new Jogador(13, "Eric", "E", LocalDate.of(1998, 12, 9), 3, "Central", 50),
                new Jogador(14, "Domingos", "minela", LocalDate.of(1999, 12, 9), 5, "qq", 39),
                new Jogador(15, "Paulo", "apelido", LocalDate.of(1989, 12, 9), 6, "central", 10),
                new Jogador(16, "Matano", "bani", LocalDate.of(1990, 12, 9), 1, "lateral", 14),
                new Jogador(17, "Maria", "Nelito", LocalDate.of(1992, 12, 9), 2, "esquerda", 60),
                new Jogador(18, "Marcos", "E", LocalDate.of(1993, 12, 9), 3, "Esquerda", 96),
                new Jogador(19, "marcelino", "minela", LocalDate.of(1994, 12, 9), 5, "qq", 55),
                new Jogador(20, "Gerilson", "apelido", LocalDate.of(1995, 12, 9), 6, "Defesa", 77),
                new Jogador(21, "Dalla", "bani", LocalDate.of(1996, 12, 9), 1, "lateral", 88),
                new Jogador(22, "Elias", "Nelito", LocalDate.of(1997, 12, 9), 2, "esquerda", 30),
                new Jogador(23, "Eliseu", "E", LocalDate.of(1998, 12, 9), 3, "Pomta", 40)
            );
    
            for (Jogador jogador : jogadoresEquipe2) {
                equipe2.adicionarJogador(jogador);
            }
    
            System.out.println("Jogadores adicionados com sucesso na equipe: " + nomeEquipe2);
        } else {
            System.out.println("Segunda equipe não encontrada.");
        }
    }
    /**
     * Relaciona os jogadores das equipes para uma partida.
     */
    
    private static void relacionarJogadores() {
        for (Equipa equipe : equipes) {
            equipe.relacionarJogadores();
        }
        System.out.println("Jogadores relacionados com sucesso.");
    }
 
    /**
     * Inicia uma partida entre duas equipes.
     */

    private static void iniciarJogo() {
        if (equipes.size() < 2) {
            System.out.println("É necessário ter pelo menos 2 equipes.");
            return;
        }
         // Verifica se há jogadores suficientes em ambas as equipes
    for (Equipa equipe : equipes) {
        if (equipe.getPlantel().size() < 11 || equipe.getPlantel().size() < 18) {
            System.out.println("Não há jogadores suficientes na equipe " + equipe.getNome() + " para iniciar o jogo.");
            return;
        }
    }
        Equipa mandante = equipes.get(0);
        Equipa visitante = equipes.get(1);

        LocalDate dataDoJogo = LocalDate.now(); // Data atual


        System.out.print("Estádio: ");
        String estadio = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        Jogo jogo = new Jogo(mandante, visitante, dataDoJogo, estadio, cidade);
       
        jogo.gerarLesoes();
        jogo.gerarCartoes();

        historicoPartidas.add(jogo);

        System.out.println("Eventos do Jogo:");
        jogo.getEventos().forEach(System.out::println);
        jogo.gerarResultado();
        System.out.println("Resultado Final: " + jogo.relatorioResultado());
    

        // Simular treinamento
        System.out.println("Jogadores treinando...");
        jogo.permitirTreinamento();

        System.out.println("Deseja iniciar outro jogo? (s/n)");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            imprimirEscalacaoPartida();
        } else {
            System.out.println("Jogo finalizado.");
        }
    }

    
    
    /**
     * Imprime a escalação das equipes para a partida.
     */
    private static void imprimirEscalacaoPartida() {
        // Verifica se há pelo menos duas equipes para imprimir a escalação
        if (equipes.size() < 2) {
            System.out.println("É necessário ter pelo menos 2 equipes.");
            return;
        }

        // Imprime a escalação das equipes mandante e visitante
        equipes.get(0).imprimirEscalacao();
        equipes.get(1).imprimirEscalacao();
    }
    
   /**
     * Exibe o relatório das partidas realizadas.
     */
    private static void relatorioPartida() {
        // Verifica se há partidas no histórico
        if (historicoPartidas.isEmpty()) {
            System.out.println("Nenhuma partida realizada.");
            return;
        }

        // Exibe o relatório de cada partida no histórico
        for (Jogo jogo : historicoPartidas) {
            System.out.println(jogo.relatorioPartida());
        }
    }

    /**
     * Procura um jogador pelo nome em todas as equipes.
     */
    private static void procurarJogadorPorNome() {
        // Solicita o nome do jogador a ser procurado
        System.out.print("Nome do jogador: ");
        String nomeJogador = scanner.nextLine();

        // Procura o jogador pelo nome em todas as equipes
        Optional<Jogador> jogadorOpt = equipes.stream()
                .flatMap(e -> e.getPlantel().stream())
                .filter(j -> j.getNome().equalsIgnoreCase(nomeJogador))
                .findFirst();

        // Exibe o resultado da busca
        if (jogadorOpt.isPresent()) {
            Jogador jogador = jogadorOpt.get();
            System.out.println("Jogador encontrado: " + jogador);
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }
}