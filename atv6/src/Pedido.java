import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private LocalDate data;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private IPagamento metodoPagamento;
    private StatusPedido statusPedido;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.data = LocalDate.now();
        this.statusPedido = StatusPedido.PENDENTE;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Produto produto, int quantidade) {
        boolean itemEncontrado = false;

        for(ItemPedido item : this.itens) {
            if (item.getProduto().equals(produto)){
                int novaQuantidade = item.getQuantidade() + quantidade;

                item.setQuantidade(novaQuantidade);

                itemEncontrado = true;
                break;
            }
        }

            if(!itemEncontrado) {
                this.itens.add(new ItemPedido(produto, quantidade));
            }
    }

    public void removerItem(ItemPedido item) {
        this.itens.remove(item);
    }

    public double calcularTotal() {
        double total = 0;

        for(ItemPedido item : this.itens) {
            total += item.getSubtotal();
        }

        return total;
    }

    //Sobrecarga de método utilizada, já que não há varíável que armazene o desconto.
    public double calcularTotal(double desconto) {

        return calcularTotal() - desconto;
    }

    public boolean confirmarPedido() {
        if(this.statusPedido != StatusPedido.PENDENTE || this.metodoPagamento == null){
            return false;
        }

        boolean retorno = this.metodoPagamento.processarPagamento(this.calcularTotal());

        if(retorno){
            this.statusPedido = StatusPedido.PROCESSANDO;
        }

        else{
            this.statusPedido = StatusPedido.PENDENTE;
        }

        return retorno;
    }

    public List<ItemPedido> getItens() {
        return this.itens;
    }
}
