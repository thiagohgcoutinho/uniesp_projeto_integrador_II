package entidades;

public class ContaCorrente extends Conta{

    // Atributos da classe ContaCorrente
    private double saldo;
    private double limiteChequeEspecial;

    // Construtor da classe ContaCorrente
    public ContaCorrente(Usuario usuario) {
        super(usuario);
        this.saldo = 0.0;
        this.limiteChequeEspecial = 500.0;
    }

    // Métodos getters e setters da classe ContaCorrente

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }


    // Métodos da classe ContaCorrente

    @Override
    public double consultarSaldo() {
        System.out.println("O saldo atual é R$ " + this.saldo);
        return this.saldo;
    }

    @Override
    public void consultarDadosConta() {
        System.out.println("Número da Conta: " + getNumConta());
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Limite do cheque especial: " + this.limiteChequeEspecial);
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso na conta de " + getUsuario().getNome() + "! Saldo Atual de R$ " + this.saldo);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= (this.saldo + this.limiteChequeEspecial)) {
            this.saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso! Saldo Atual de R$ " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    public void consultarLimiteChequeEspecial() {
        System.out.println("O limete do Cheque Especial atual é R$ " + this.limiteChequeEspecial);
    }

    public void transferir(ContaCorrente contaDestino, double valor) {
        if (valor <= (this.saldo + this.limiteChequeEspecial)) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso!");
            System.out.println("Novo saldo de R$ " + this.saldo + " na conta de " + this.getUsuario().getNome() + "!");
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
