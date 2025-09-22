public class ClientePF extends Cliente{
    private String cpf;

    public ClientePF(String nome, String email, String cnpj) {
        super(nome, email);
        this.cpf = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
