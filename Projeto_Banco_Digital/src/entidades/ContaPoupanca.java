package entidades;

public class ContaPoupanca extends Conta{

    private double saldo;

    public ContaPoupanca(Usuario usuario) {
        super(usuario);
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public double consultarSaldo() {
        System.out.println("O saldo atual da Conta Poupança é R$ " + this.saldo);
        return this.saldo;
    }

    @Override
    public void consultarDadosConta() {
        System.out.println("Número da Conta: " + getNumConta());
        System.out.println("Saldo: " + this.saldo);
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso na Conta Poupança de " + getUsuario().getNome() + "! Saldo Atual de R$ " + this.saldo);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso! Saldo Atual de R$ " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente para realizar o saque na Conta Poupança.");
        }
    }

    public double rendimentoPoupanca() {
        double rendimento = this.saldo * 0.02;
        this.saldo += rendimento;
        System.out.println("Rendimento de R$ " + rendimento + " aplicado na Conta Poupança de " + getUsuario().getNome() + "! Saldo Atual de R$ " + this.saldo);
        return rendimento;
    }

}