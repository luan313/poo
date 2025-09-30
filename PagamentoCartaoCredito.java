public class PagamentoCartaoCredito implements IPagamento{
    private String numeroCartao;

    public PagamentoCartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public boolean processarPagamento(double valor) {
        if(valor >= 200) return false;

        else return true;
    }
}
