package entidades;

public class ContaPoupanca extends ContaCorrente{
    private int numeroContaPoupanca;
    private double saldo;
    private Usuario usuario;

    public ContaPoupanca(Usuario usuario) {
        super(usuario);
        this.numeroContaPoupanca = gerarNumeroContaPoupanca(usuario);
        this.saldo = 0.0;
    }

    public int getNumeroContaPoupanca() {
        return numeroContaPoupanca;
    }

    public double getSaldoPoupanca() {
        return saldo;
    }

    private void setSaldoPoupanca(double saldo) {
        this.saldo = saldo;
    }

    public int gerarNumeroContaPoupanca(Usuario usuario) {
        int numContaCorrente = getNumeroConta() / 10;
        return numContaCorrente * 10;
    }

    public double consultarSaldoPoupanca() {
        System.out.println("O saldo atual da Conta Poupança é R$ " + this.saldo);
        return this.saldo;
    }

    public void depositarPoupanca(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso na conta poupança de " + getUsuario().getNome() + "! Saldo Atual de R$ " + this.saldo);
    }

    public void sacarPoupanca(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso! Saldo Atual de R$ " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente para realizar o saque na conta poupança.");
        }
    }

    public double rendimentoPoupanca() {
        double rendimento = this.saldo * 0.02;
        this.saldo += rendimento;
        System.out.println("Rendimento de R$ " + rendimento + " aplicado na conta poupança de " + getUsuario().getNome() + "! Saldo Atual de R$ " + this.saldo);
        return rendimento;
    }

    public void consultarDadosContaPoupanca() {
        System.out.println("Número da Conta Poupança: " + this.numeroContaPoupanca);
        System.out.println("Saldo: " + this.saldo);
    }
}
