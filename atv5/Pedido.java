import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class Pedido {
    private LocalDate data;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private IPagamento metodoPagamento;

    public Pedido(Cliente cliente,  LocalDate data, IPagamento metodoPagamento) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.data = data;
        this.metodoPagamento = metodoPagamento;
    }

    public void process(double valor){
        if(this.metodoPagamento.processarPagamento(valor) == true){
            System.out.println("Pagamento realizado com sucesso");
        }

        else System.out.println("Pagamento recusado.");
    }

    public String getCliente() {
        return this.cliente.nome;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        this.itens.add(new ItemPedido(produto, quantidade));
    }

    public double getValorTotal() {
        double total = 0.0;
        for (int i = 0; i < this.itens.size(); i++) {
            total += this.itens.get(i).getSubtotal();
        }
        return total;
    }


}