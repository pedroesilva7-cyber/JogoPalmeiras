public class PerguntaVerdadeiroFalso extends Pergunta {
    private boolean respostaCorreta;

    public PerguntaVerdadeiroFalso(String enunciado, int pontos, boolean respostaCorreta) {
        super(enunciado, pontos);
        this.respostaCorreta = respostaCorreta;
    }

    @Override
    public boolean verificarResposta(String resposta) {
        boolean respUsuario = resposta.trim().equalsIgnoreCase("V");
        return respUsuario == respostaCorreta;
    }

    public void exibirPergunta() {
        System.out.println("\n[VERDADEIRO OU FALSO] " + getEnunciado() + " (Responda V ou F)");
    }
}