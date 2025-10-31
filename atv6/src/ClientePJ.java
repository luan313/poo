public class ClientePJ extends Cliente {
    private String cnpj;
    private String razaoSocial;
    private String inscricaoEstadual;

    public ClientePJ(String name, String email, String id, String telefone, String cnpj, String razaoSocial, String inscricaoEstadual) {
        super(name, email, id, telefone);

        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    //Retorna o cnpj, que é o identificador único
    @Override
    public String getIdentificadorUnico() {
        return this.cnpj;
    }
}
