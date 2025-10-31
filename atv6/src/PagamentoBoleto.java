import java.time.LocalDate;

public class PagamentoBoleto implements IPagamento{
    private String codigoBarras;
    private LocalDate dataVencimento;
    private double valor;
    private StatusPagamento statusPagamento;

    @Override
    public boolean processarPagamento(double valor) {
        this.statusPagamento = StatusPagamento.APROVADO;

        return true;
    }

    @Override
    public StatusPagamento getStatus() {
        return this.statusPagamento;
    }
}
