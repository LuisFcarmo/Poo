public interface IPagamento {
    public boolean processarPagamento(double valor);
    public StatusPagamento getStatus();
}
