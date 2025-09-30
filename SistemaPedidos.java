import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class SistemaPedidos {
    public static void main(String[] args) {
        ClientePF cliente1 = new ClientePF("123123456", "Luan Fernandes", "luanfernandes@gmail");
        ClientePF cliente2 = new ClientePF("111111111", "Leonardo Oliveira", "leonardooliveira@gmail");

        ClientePJ cliente3 = new ClientePJ("121233456", "Arhur Ferreira", "ArthurOliveira@gmail");
        ClientePJ cliente4 = new ClientePJ("11545434112", "Guilherme Barros", "GuilhermeBarros@gmail");

        Produto produto1 = new Produto("Mouse", 75);
        Produto produto2 = new Produto("Teclado", 100);
        Produto produto3 = new Produto("Gabinete", 300);

        PagamentoCartaoCredito pagCartao1 = new PagamentoCartaoCredito("983672");
        PagamentoCartaoCredito pagCartao2 = new PagamentoCartaoCredito("999999");

        PagamentoBoleto pagBoleto1 = new PagamentoBoleto("09781235");
        PagamentoBoleto pagBoleto2 = new PagamentoBoleto("87625636");

        Pedido pedido1 = new Pedido(cliente1, LocalDate.now(), pagCartao1);
        Pedido pedido2 = new Pedido(cliente2, LocalDate.now(), pagCartao2);

        Pedido pedido3 = new Pedido(cliente3, LocalDate.now(), pagBoleto1);
        Pedido pedido4 = new Pedido(cliente4, LocalDate.now(), pagBoleto2);

        pedido1.adicionarItem(produto1, 2);
        pedido2.adicionarItem(produto2, 2);
        pedido2.adicionarItem(produto3, 1);

        pedido3.adicionarItem(produto2, 2);
        pedido3.adicionarItem(produto3, 2);
        pedido4.adicionarItem(produto3, 5);

        pedido1.process(pedido1.getValorTotal());
        System.out.println(pedido1.getValorTotal());
        System.out.println(pedido1.getCliente() + "\n");

        pedido2.process(pedido2.getValorTotal());
        System.out.println(pedido2.getValorTotal());
        System.out.println(pedido2.getCliente() + "\n");

        pedido3.process(pedido3.getValorTotal());
        System.out.println(pedido3.getValorTotal());
        System.out.println(pedido3.getCliente() + "\n");

        pedido4.process(pedido4.getValorTotal());
        System.out.println(pedido4.getValorTotal());
        System.out.println(pedido4.getCliente());

    }
}