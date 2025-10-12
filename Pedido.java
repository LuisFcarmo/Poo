import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pedido {
    private LocalDate localDate;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private IPagamento metodoPagamento;
    private StatusPedido statusPedido;
    private double desconto;

    public Pedido(LocalDate localDate, Cliente cliente, IPagamento metodoPagamento) {
        this.localDate = localDate;
        this.cliente = cliente;
        this.metodoPagamento = metodoPagamento;
        this.statusPedido = StatusPedido.PENDENTE;
        this.desconto = 0.0;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        Optional<ItemPedido> itemExistente = itens.stream()
                .filter(item -> item.getProduto().equals(produto))
                .findFirst();

        if (itemExistente.isPresent()) {
            ItemPedido item = itemExistente.get();
            item.setQuantidade(item.getQuantidade() + quantidade);
        } else {
            this.itens.add(new ItemPedido(produto, quantidade));
        }
    }

    public void removerItem(ItemPedido item) {
        this.itens.remove(item);
    }

    public double calcularTotal() {
        double totalBruto = itens.stream()
                .mapToDouble(ItemPedido::getSubtotal)
                .sum();
        double totalLiquido = totalBruto - this.desconto;
        return Math.max(totalLiquido, 0);
    }

    public void aplicarDesconto(double desconto) {
        this.desconto = desconto;
    }

    public boolean confirmarPedido() {
        if (this.statusPedido != StatusPedido.PENDENTE) {
            System.out.println("Erro: O pedido não está com o status PENDENTE.");
            return false;
        }

        if (this.metodoPagamento == null) {
            System.out.println("Erro: Nenhum método de pagamento foi definido.");
            return false;
        }

        boolean pagamentoAprovado = this.metodoPagamento.processarPagamento(this.calcularTotal());

        if (pagamentoAprovado) {
            this.statusPedido = StatusPedido.PROCESSANDO;
        }

        return pagamentoAprovado;
    }


    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public IPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(IPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public double getDesconto() {
        return desconto;
    }
}