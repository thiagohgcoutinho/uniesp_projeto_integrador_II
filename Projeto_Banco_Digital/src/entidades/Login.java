package entidades;

public class Login {

    // Atributos da classe Login
    private Usuario usuario;
    private String email;
    private String senha;

    // Construtor da classe Login
    public Login(Usuario usuario, String email, String senha) {
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }

    // Métodos da classe Login
    public boolean fazerLogin() {

        if (this.email.equals(this.usuario.getEmail()) && this.senha.equals(this.usuario.getSenha())) {
            System.out.println("Login de " + this.usuario.getNome() + " realizado com sucesso!");
            return true;
        } else {
            System.out.println("Email ou senha incorretos, tente novamente.");
            return false;
        }
    }

    public void esqueciSenha(String email, String cpf, String novaSenha) {

        if (this.usuario.getEmail().equals(email) && this.usuario.getCpf().equals(cpf)) {
            this.usuario.setSenha(novaSenha);
            System.out.println("Nova senha criada com sucesso!");
        } else {
            System.out.println("Dados incorretos, não foi possível criar nova senha.");
        }
    }

}
