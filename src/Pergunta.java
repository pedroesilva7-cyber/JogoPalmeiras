public abstract class Pergunta {
    private String enunciado;
    private int pontos;

    public Pergunta(String enunciado, int pontos) {
        this.enunciado = enunciado;
        this.pontos = pontos;
    }

    public abstract boolean verificarResposta(String resposta);

    public String getEnunciado() {
        return enunciado;
    }

    public int getPontos() {
        return pontos;
    }
}