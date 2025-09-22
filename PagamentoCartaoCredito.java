public class PagamentoCartaoCredito implements  IPagamento {
    @Override
    public boolean processarPagamento(double valor) {
        return !(valor >= 200.0);
    }

    public PagamentoCartaoCredito() {
    }
}
