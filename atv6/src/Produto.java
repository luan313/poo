public class Produto {
    protected String id;
    protected String nome;
    protected double preco;
    protected String descricao;
    protected int quantidade;

    public Produto(String id, String nome, double preco, String descricao, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = 0;
    }

    public String getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public void adicionarEstoque(int quantidade) {
        this.quantidade += quantidade;
    }
}