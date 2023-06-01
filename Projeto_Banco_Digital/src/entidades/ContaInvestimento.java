package entidades;

public class ContaInvestimento extends ContaCorrente{
    private int numeroContaInvestimento;
    private double saldo;
    private Usuario usuario;

    public ContaInvestimento(Usuario usuario) {
        super(usuario);
        this.numeroContaInvestimento = gerarNumeroContaInvestimento(usuario);
        this.saldo = 0.0;
    }

    public int getNumeroContaInvestimento() {
        return numeroContaInvestimento;
    }

    public double getSaldoInvestimento() {
        return saldo;
    }

    private void setSaldoInvestimento(double saldo) {
        this.saldo = saldo;
    }

    public int gerarNumeroContaInvestimento(Usuario usuario) {
        int numContaCorrente = getNumeroConta() / 10;
        return numContaCorrente * 10;
    }

    public double consultarSaldoInvestimento() {
        System.out.println("O saldo atual da Conta Investimento é R$ " + this.saldo);
        return this.saldo;
    }

    public void depositarInvestimento(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso na conta investimento de " + getUsuario().getNome() + "! Saldo Atual de R$ " + this.saldo);
    }

    public void sacarInvestimento(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso! Saldo Atual de R$ " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente para realizar o saque na conta investimento.");
        }
    }

    public double rendimentoInvestimento() {
        double rendimento = this.saldo * 0.1;
        this.saldo += rendimento;
        System.out.println("Rendimento de R$ " + rendimento + " aplicado na conta investimento de " + getUsuario().getNome() + "! Saldo Atual de R$ " + this.saldo);
        return rendimento;
    }

    public void consultarDadosContaInvestimento() {
        System.out.println("Número da Conta Poupança: " + this.numeroContaInvestimento);
        System.out.println("Saldo: " + this.saldo);
    }
}