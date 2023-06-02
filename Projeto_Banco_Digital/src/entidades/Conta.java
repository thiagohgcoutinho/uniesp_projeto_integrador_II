package entidades;

import java.util.Random;

public abstract class Conta {

    private int numConta;
    private Usuario usuario;

    public Conta (Usuario usuario) {
        this.usuario = usuario;
        this.numConta = gerarNumConta();
    }

    public int getNumConta() {
        return numConta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int gerarNumConta() {
        Random random = new Random();
        return 10000 + random.nextInt(90000);
    }

    public abstract double consultarSaldo();

    public abstract void consultarDadosConta();

    public abstract void depositar(double valor);

    public abstract void sacar(double valor);

    public void consultarDadosUsuario() {
        System.out.println("Nome: " + this.usuario.getNome());
        System.out.println("CPF: " + this.usuario.getCpf());
        System.out.println("Email: " + this.usuario.getEmail());
        System.out.println("Idade: " + this.usuario.getIdade());
        System.out.println("Telefone: " + this.usuario.getTelefone());
        System.out.println("Endereço: " + this.usuario.getEndereco());
    }



}
