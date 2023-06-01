package entidades;

import java.util.Random;

public class ContaCorrente {

    // Atributos da classe ContaCorrente
    private int numeroConta;
    private double saldo;
    private double limiteChequeEspecial;
    private Usuario usuario;

    // Construtor da classe ContaCorrente
    public ContaCorrente(Usuario usuario) {
        this.usuario = usuario;
        this.numeroConta = gerarNumeroConta();
        this.saldo = 0.0;
        this.limiteChequeEspecial = 500.0;
    }

    // Métodos getters e setters da classe ContaCorrente
    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    // Métodos da classe ContaCorrente
    public int gerarNumeroConta() {
        Random random = new Random();
        return 10000 + random.nextInt(90000);
    }

    public double consultarSaldo() {
        System.out.println("O saldo atual é R$ " + this.saldo);
        return this.saldo;
    }

    public double consultarLimiteChequeEspecial() {
        System.out.println("O limete do Cheque Especial atual é R$ " + this.limiteChequeEspecial);
        return this.limiteChequeEspecial;
    }

    public void consultarDadosUsuario() {
        System.out.println("Nome: " + this.usuario.getNome());
        System.out.println("CPF: " + this.usuario.getCpf());
        System.out.println("Email: " + this.usuario.getEmail());
        System.out.println("Idade: " + this.usuario.getIdade());
        System.out.println("Telefone: " + this.usuario.getTelefone());
        System.out.println("Endereço: " + this.usuario.getEndereco());
    }

    public void consultarDadosContaCorrente() {
        System.out.println("Número da conta: " + this.numeroConta);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite do cheque especial: " + this.limiteChequeEspecial);
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso na conta de " + this.usuario.getNome() + "! Saldo Atual de R$ " + this.saldo);
    }

    public void sacar(double valor) {
        if (valor <= (this.saldo + this.limiteChequeEspecial)) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso! Saldo Atual de R$ " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    public void transferir(ContaCorrente contaDestino, double valor) {
        if (valor <= (this.saldo + this.limiteChequeEspecial)) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso!");
            System.out.println("Novo saldo de R$ " + this.saldo + " na conta de " + this.usuario.getNome() + "!");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }

    public double debitar(double valor) {
        if (valor <= (this.saldo + this.limiteChequeEspecial)) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente para realizar o pagamento.");
        }
        return this.saldo;
    }

    public void creditarCashback(double valor) {
        double novoSaldo = this.getSaldo() + valor;
        this.setSaldo(novoSaldo);
    }

}
