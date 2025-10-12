import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Produto notebook = new Produto("Notebook", 4500.0, 10);
        Produto mouse = new Produto("Mouse", 150.0, 50);
        Produto teclado = new Produto("Teclado Mecânico", 350.0, 20);

        ClientePF cliente1 = new ClientePF("João da Silva", "joao@email.com", "123.456.789-00");
        ClientePJ cliente2 = new ClientePJ("Tech Solutions Ltda", "contato@tech.com", "12.345.678/0001-99");

        System.out.println("--- Início das Simulações de Pedidos ---\n");

        System.out.println("--- Pedido 1 ---");
        Pedido pedido1 = new Pedido(LocalDate.now(), cliente1, new PagamentoCartaoCredito());
        pedido1.adicionarItem(mouse, 2);
        pedido1.adicionarItem(teclado, 1);
        System.out.println("Status inicial: " + pedido1.getStatusPedido());
        System.out.printf("Total do Pedido 1: R$ %.2f\n", pedido1.calcularTotal());
        boolean aprovado1 = pedido1.confirmarPedido();
        System.out.println("Pagamento aprovado? " + aprovado1);
        System.out.println("Status do Pagamento: " + pedido1.getMetodoPagamento().getStatus());
        System.out.println("Status final do Pedido: " + pedido1.getStatusPedido());
        System.out.println("------------------\n");


        
        System.out.println("--- Pedido 2 ---");
        Pedido pedido2 = new Pedido(LocalDate.now(), cliente1, new PagamentoCartaoCredito());
        pedido2.adicionarItem(notebook, 1);
        pedido2.adicionarItem(teclado, 2);
        System.out.println("Status inicial: " + pedido2.getStatusPedido());
        System.out.printf("Total do Pedido 2: R$ %.2f\n", pedido2.calcularTotal());
        boolean aprovado2 = pedido2.confirmarPedido();
        System.out.println("Pagamento aprovado? " + aprovado2);
        System.out.println("Status do Pagamento: " + pedido2.getMetodoPagamento().getStatus());
        System.out.println("Status final do Pedido: " + pedido2.getStatusPedido());
        System.out.println("------------------\n");

        System.out.println("--- Pedido 3 ---");
        Pedido pedido3 = new Pedido(LocalDate.now(), cliente2, new PagamentoBoleto());
        pedido3.adicionarItem(notebook, 2);
        pedido3.aplicarDesconto(500.0);
        System.out.println("Status inicial: " + pedido3.getStatusPedido());
        System.out.printf("Total Bruto: R$ 9000.00 | Desconto: R$ %.2f\n", pedido3.getDesconto());
        System.out.printf("Total do Pedido 3: R$ %.2f\n", pedido3.calcularTotal());
        boolean aprovado3 = pedido3.confirmarPedido();
        System.out.println("Pagamento (geração de boleto) aprovado? " + aprovado3);
        System.out.println("Status do Pagamento: " + pedido3.getMetodoPagamento().getStatus());
        System.out.println("Status final do Pedido: " + pedido3.getStatusPedido());
        System.out.println("------------------\n");

        System.out.println("--- Pedido 4 ---");
        Pedido pedido4 = new Pedido(LocalDate.now(), cliente1, new PagamentoCartaoCredito());
        pedido4.adicionarItem(mouse, 1);
        System.out.println("Quantidade de itens no pedido: " + pedido4.getItens().size());
        System.out.printf("Total parcial: R$ %.2f\n", pedido4.calcularTotal());
        pedido4.adicionarItem(mouse, 3);
        System.out.println("Quantidade de itens no pedido (após adicionar mais): " + pedido4.getItens().size());
        System.out.println("Quantidade do item 'Mouse': " + pedido4.getItens().get(0).getQuantidade());
        System.out.printf("Total final do Pedido 4: R$ %.2f\n", pedido4.calcularTotal());
        boolean aprovado4 = pedido4.confirmarPedido();
        System.out.println("Pagamento aprovado? " + aprovado4);
        System.out.println("Status final do Pedido: " + pedido4.getStatusPedido());
        System.out.println("------------------\n");
    }
}