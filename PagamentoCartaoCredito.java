
public class PagamentoCartaoCredito implements  IPagamento {
    private StatusPagamento statusPagamento;

    public PagamentoCartaoCredito() {
        this.statusPagamento = StatusPagamento.PENDENTE;
    }

    @Override
    public boolean processarPagamento(double valor) {
        if (valor < 5000) {
            this.statusPagamento = StatusPagamento.APROVADO;
            return true;
        } else {
            this.statusPagamento = StatusPagamento.RECUSADO;
            return false;
        }
    }

    @Override
    public StatusPagamento getStatus() {
        return this.statusPagamento;
    }
}
