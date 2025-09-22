public class PagamentoBoleto implements IPagamento {
    @Override
    public boolean processarPagamento(double valor) {
        return !(valor >= 1000);
    }

    public PagamentoBoleto() {
    }
}
