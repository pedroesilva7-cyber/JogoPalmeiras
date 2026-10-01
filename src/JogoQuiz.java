import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogoQuiz {
    private Jogador jogador;
    private List<Pergunta> perguntas;
    private Scanner scanner;

    public JogoQuiz() {
        this.perguntas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("=========================================");
        System.out.println("      QUIZ VERDÃO: DESAFIO PALMEIRAS     ");
        System.out.println("=========================================");

        System.out.print("Digite o seu nome, palmeirense: ");
        String nome = scanner.nextLine();
        this.jogador = new Jogador(nome);

        carregarPerguntas();

        System.out.println("\nBem-vindo, " + jogador.getNome() + "! Responda às perguntas abaixo:");

        for (Pergunta p : perguntas) {
            if (p instanceof PerguntaMultiplaEscolha) {
                ((PerguntaMultiplaEscolha) p).exibirPergunta();
            } else if (p instanceof PerguntaVerdadeiroFalso) {
                ((PerguntaVerdadeiroFalso) p).exibirPergunta();
            }

            System.out.print("Sua resposta: ");
            String resp = scanner.nextLine();

            if (p.verificarResposta(resp)) {
                System.out.println("✅ Correto! +" + p.getPontos() + " pontos!");
                jogador.adicionarPontos(p.getPontos());
            } else {
                System.out.println("❌ Resposta incorreta!");
            }
        }

        System.out.println("\n=========================================");
        System.out.println("FIM DO QUIZ!");
        System.out.println("Jogador: " + jogador.getNome());
        System.out.println("Pontuação Final: " + jogador.getPontuacao() + " pontos.");

        if (jogador.getPontuacao() >= 30) {
            System.out.println("Status: Verdadeiro Palestrino! 🟢🏆");
        } else {
            System.out.println("Status: Precisa estudar mais a história do Verdão! ⚽");
        }
        System.out.println("=========================================");
    }

    private void carregarPerguntas() {
        String[] alt1 = {"1914", "1951", "1999", "2020"};
        perguntas.add(new PerguntaMultiplaEscolha("Em qual ano o Palestra Italia foi fundado?", 10, alt1, 1));

        perguntas.add(new PerguntaVerdadeiroFalso("O Palmeiras conquistou a Copa Rio em 1951.", 10, true));

        String[] alt2 = {"Ademir da Guia", "Marcos", "Dudu", "Evair"};
        perguntas.add(new PerguntaMultiplaEscolha("Quem é conhecido como 'O Divino' na história do clube?", 10, alt2, 1));

        perguntas.add(new PerguntaVerdadeiroFalso("Abel Ferreira conquistou a Libertadores de 1999 como treinador.", 10, false));
    }
}