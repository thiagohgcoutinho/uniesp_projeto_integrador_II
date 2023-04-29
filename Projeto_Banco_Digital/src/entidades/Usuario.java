package entidades;

public class Usuario {

    // Atributos da classe Usuario
    private String nome;
    private String cpf;
    private String email;
    private int idade;
    private String telefone;
    private String endereco;
    private String senha;

    // Construtor da classe Usuario
    public Usuario(String nome, String cpf, String email, int idade, String telefone, String endereco, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.idade = idade;
        this.telefone = telefone;
        this.endereco = endereco;
        this.senha = senha;
    }

    // Métodos getters e setters da classe Usuario
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Métodos adicionais da classe Usuario
    public void abrirConta() {
        System.out.println("Conta bancária aberta com sucesso!");
    }

    public void fecharConta() {
        System.out.println("Conta bancária fechada com sucesso!");
    }
}
