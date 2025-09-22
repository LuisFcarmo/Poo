import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private LocalDate localDate;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private IPagamento metodoPagamento;

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public IPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setMetodoPagamento(IPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Pedido(LocalDate localDate, Cliente cliente, IPagamento metodoPagamento) {
        this.localDate = localDate;
        this.cliente = cliente;
        this.metodoPagamento = metodoPagamento;
    }

    public void adicionarItem(Produto produto, int quantidade){
        this.itens.add(new ItemPedido(produto, quantidade));
    }

    public double CalcularTotal(){
        return itens.stream()
                .mapToDouble(ItemPedido::getSubTotal)
                .sum();
    }

    public boolean FecharPedido(){
        double valortotal = CalcularTotal();
        return metodoPagamento.processarPagamento(valortotal);
    }
}
