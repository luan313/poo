import java.time.LocalDate;

public class ClientePF extends Cliente{
    private String cpf;
    private LocalDate dataNascimento;

    public ClientePF(String name, String email, String id, String telefone, String cpf, LocalDate dataNascimento) {
        super(name, email, id, telefone);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    //Retorna o cpf, que é o identificador único
    @Override
    public String getIdentificadorUnico() {
        return this.cpf;
    }
}
