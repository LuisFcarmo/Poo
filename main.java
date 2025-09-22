import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Produto notebook = new Produto("Notebook", 1500.0, 10);
        Produto mouse = new Produto("Mouse", 50.0, 20);

        ClientePF cliente1 = new ClientePF("João", "joao@email.com", "123.456.789-00");
        ClientePJ cliente2 = new ClientePJ("Tech Ltda", "contato@tech.com", "12.345.678/0001-99");

        Pedido pedido1 = new Pedido(LocalDate.now(), cliente1, new PagamentoCartaoCredito());
        pedido1.adicionarItem(mouse, 3);
        System.out.println("Pedido 1 total: " + pedido1.CalcularTotal());
        System.out.println("Pagamento aprovado? " + pedido1.FecharPedido());

        Pedido pedido2 = new Pedido(LocalDate.now(), cliente1, new PagamentoCartaoCredito());
        pedido2.adicionarItem(mouse, 10);
        System.out.println("Pedido 2 total: " + pedido2.CalcularTotal());
        System.out.println("Pagamento aprovado? " + pedido2.FecharPedido());

        Pedido pedido3 = new Pedido(LocalDate.now(), cliente2, new PagamentoBoleto());
        pedido3.adicionarItem(mouse, 16); ;
        System.out.println("Pedido 3 total: " + pedido3.CalcularTotal());
        System.out.println("Pagamento aprovado? " + pedido3.FecharPedido());

        Pedido pedido4 = new Pedido(LocalDate.now(), cliente2, new PagamentoBoleto());
        pedido4.adicionarItem(notebook, 1);
        System.out.println("Pedido 4 total: " + pedido4.CalcularTotal());
        System.out.println("Pagamento aprovado? " + pedido4.FecharPedido());
    }
}
