package entidades;

import java.time.LocalDate;

public class Pagamento {
    private double valorPagamento;
    private String numeroBoleto;
    private LocalDate dataPagamento;
    private ContaCorrente contaCorrente;

    public Pagamento(ContaCorrente contaCorrente, double valorPagamento, String numeroBoleto, LocalDate dataPagamento) {
        this.contaCorrente = contaCorrente;
        this.valorPagamento = valorPagamento;
        this.numeroBoleto = numeroBoleto;
        this.dataPagamento = dataPagamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public void realizarPagamento() {
        if (contaCorrente.getSaldo() >= this.valorPagamento) {
            contaCorrente.debitar(this.valorPagamento);
            System.out.println("Pagamento realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para realizar o pagamento!");
        }
    }
}