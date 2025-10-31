import java.time.LocalDate;

public class PagamentoCartaoCredito implements IPagamento{
    private String numeroCartao;
    private String nomeTitular;
    private LocalDate dataValidade;
    private StatusPagamento statusPagamento;

    @Override
    public boolean processarPagamento(double valor) {
        if (valor < 5000) {
            this.statusPagamento = StatusPagamento.APROVADO;
            return true;
        }

        else {
            this.statusPagamento = StatusPagamento.RECUSADO;
            return false;
        }
    }

    @Override
    public StatusPagamento getStatus() {
        return this.statusPagamento;
    }
}
