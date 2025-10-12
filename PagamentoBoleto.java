public class PagamentoBoleto implements IPagamento {
    private StatusPagamento statusPagamento;

    public PagamentoBoleto() {
        this.statusPagamento = StatusPagamento.PENDENTE;
    }

    @Override
    public boolean processarPagamento(double valor) {
        // Simula a geração do boleto, que é sempre bem-sucedida.
        this.statusPagamento = StatusPagamento.APROVADO;
        return true;
    }

    @Override
    public StatusPagamento getStatus() {
        return this.statusPagamento;
    }
}
