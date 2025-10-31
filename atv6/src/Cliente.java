public abstract class Cliente {
    protected String nome;
    protected String email;
    protected String id;
    protected String telefone;

    public Cliente(String nome, String email, String id, String telefone) {
        this.nome = nome;
        this.email = email;
        this.id = id;
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public String getTelefone() {
        return telefone;
    }

    public abstract String getIdentificadorUnico();
}
