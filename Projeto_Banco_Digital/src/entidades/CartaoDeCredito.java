package entidades;

import java.time.LocalDate;
import java.util.Calendar;

public class CartaoDeCredito {

    // Atributos da classe CartaoDeCredito
    private String numeroCartao;
    private String tipoCartao;
    private String senhaCartao;
    private double limiteCartao;
    private double valorCompraCartao;
    private LocalDate vencimentoCartao;
    private double valorTotalFatura;
    private ContaCorrente contaCorrente;
    private double cashback;

    // Construtor da classe CartaoDeCredito
    public CartaoDeCredito(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
        this.numeroCartao = String.valueOf((long) (Math.random() * 10000000000000000L));
        this.tipoCartao = "Gold";
        this.senhaCartao = String.valueOf((long) (Math.random() * 9999));
        this.limiteCartao = 5000.00;
        this.valorCompraCartao = 0.00;
        this.vencimentoCartao = LocalDate.now().plusYears(3);
        this.valorTotalFatura = 0.00;
        this.cashback = 0.0;
    }

    // Métodos getters e setters da classe CartaoDeCredito
    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public String getSenhaCartao() {
        return senhaCartao;
    }

    public void setSenhaCartao(String senhaCartao) {
        this.senhaCartao = senhaCartao;
    }

    public double getLimiteCartao() {
        return limiteCartao;
    }

    public void setLimiteCartao(double limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    public double getValorCompraCartao() {
        return valorCompraCartao;
    }

    public void setValorCompraCartao(double valorCompraCartao) {
        this.valorCompraCartao = valorCompraCartao;
    }

    public LocalDate getVencimentoCartao() {
        return vencimentoCartao;
    }

    public void setVencimentoCartao(LocalDate vencimentoCartao) {
        this.vencimentoCartao = vencimentoCartao;
    }

    public double getValorTotalFatura(int mesCompra, int anoCompra) {
        return valorTotalFatura;
    }

    public void setValorTotalFatura(int mesCompra, int anoCompra, double valorTotalFatura) {
        this.valorTotalFatura = valorTotalFatura;
    }

    public double getCashback(){
        return cashback;
    }

    public void consultarDadosCartao() {
        System.out.println("Número do Cartão: " + this.numeroCartao);
        System.out.println("Tipo do Cartão: " + this.tipoCartao);
        System.out.println("Limite do Cartão: " + this.limiteCartao);
        System.out.println("Senha do Cartão: " + this.senhaCartao);
        System.out.println("Vencimento do Cartão: " + this.vencimentoCartao);
    }

    public void solicitarUpgradeParaPlatinum() {
        if (this.tipoCartao.equals("Gold")) {
            this.tipoCartao = "Platinum";
            this.limiteCartao = 10000.0;
        } else {
            System.out.println("Não é possível solicitar upgrade para Platinum. Seu cartão atual é do tipo " + this.tipoCartao);
        }
    }

    public void solicitarUpgradeParaBlack() {
        if (this.tipoCartao.equals("Platinum")) {
            this.tipoCartao = "Black";
            this.limiteCartao = 25000.0;
        } else {
            System.out.println("Não é possível solicitar upgrade para Black. Seu cartão atual é do tipo " + this.tipoCartao);
        }
    }

    public void alterarSenha(String novaSenha) {
        if (novaSenha.matches("\\d{4}")) {
            this.senhaCartao = novaSenha;
            System.out.println("Senha do cartão alterada com sucesso!");
        } else {
            System.out.println("A senha deve conter exatamente 4 dígitos numéricos!");
        }
    }

    public void valorCompraCartao(double valor, LocalDate data) {
        int mesCompra = data.getMonthValue();
        int anoCompra = data.getYear();

        // Adiciona o valor da compra ao total da fatura do mês correspondente
        double novoValorFatura = this.getValorTotalFatura(mesCompra, anoCompra) + valor;
        this.setValorTotalFatura(mesCompra, anoCompra, novoValorFatura);
    }

    public double consultarFatura(int mes, int ano) {
        double valorFatura = 0.0;

        if (mes < 1 || mes > 12) {
            System.out.println("Mês inválido.");
            return valorFatura;
        }

        valorFatura = this.getValorTotalFatura(mes, ano);

        if (valorFatura == 0.0) {
            System.out.println("Fatura não encontrada.");
        } else {
            System.out.println("Valor total da fatura do mês " + mes + " do ano " + ano + ": R$ " + valorFatura);
        }

        return valorFatura;
    }

    public void pagarFatura(int mes, int ano, Usuario usuario) {
       double valorFatura = this.getValorTotalFatura(mes, ano);

        if (this.contaCorrente.getSaldo() < valorFatura) {
            System.out.println("Saldo insuficiente para pagar a fatura.");
            return;
        }

        // Subtrair o valor da fatura do saldo da conta corrente do usuário
        contaCorrente.debitar(valorFatura);

        // Calcula e credita o cashback na conta corrente do usuário
        double cashback = valorFatura * 0.01;
        this.contaCorrente.creditarCashback(cashback);
        System.out.println("O valor do cashback referente ao mês " + mes + " de " + ano + " é: R$ " + cashback);

        // Zerar o valor da fatura para o mês e ano informados
        this.setValorTotalFatura(mes, ano, 0.0);

        System.out.println("Fatura do mês " + mes + "/" + ano + " paga com sucesso.");
    }




}