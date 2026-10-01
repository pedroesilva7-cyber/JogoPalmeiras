public class PerguntaMultiplaEscolha extends Pergunta {
    private String[] alternativas;
    private int respostaCorreta;

    public PerguntaMultiplaEscolha(String enunciado, int pontos, String[] alternativas, int respostaCorreta) {
        super(enunciado, pontos);
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
    }

    @Override
    public boolean verificarResposta(String resposta) {
        try {
            int escolha = Integer.parseInt(resposta.trim());
            return escolha == respostaCorreta;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void exibirPergunta() {
        System.out.println("\n[MÚLTIPLA ESCOLHA] " + getEnunciado());
        for (int i = 0; i < alternativas.length; i++) {
            System.out.println((i + 1) + ") " + alternativas[i]);
        }
    }
}