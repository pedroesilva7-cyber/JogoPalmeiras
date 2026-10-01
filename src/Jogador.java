public class Jogador implements Pontuavel {
    private String nome;
    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
    }

    @Override
    public void adicionarPontos(int pontos) {
        this.pontuacao += pontos;
    }

    @Override
    public int getPontuacao() {
        return pontuacao;
    }

    public String getNome() {
        return nome;
    }
}