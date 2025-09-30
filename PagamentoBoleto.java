public class PagamentoBoleto implements IPagamento{
    private String codigoBarras;

    public PagamentoBoleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public boolean processarPagamento(double valor){
        if(valor >= 1000) return false;

        else return true;
    }
}
