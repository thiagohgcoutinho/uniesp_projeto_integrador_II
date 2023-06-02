package entidades;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.time.LocalDate;

public class Emprestimo {
    private ContaCorrente contaCorrente;
    private double valorEmprestimo;
    private int parcelas;
    private double taxaJuros;
    private double valorParcela;
    private LocalDate dataSimulacao;
    private LocalDate dataEmprestimo;
    private boolean realizado;


    public Emprestimo(ContaCorrente contaCorrente, double valorEmprestimo, int parcelas, LocalDate dataSimulacao) {
        this.contaCorrente = contaCorrente;
        this.valorEmprestimo = valorEmprestimo;
        this.parcelas = parcelas;
        this.dataSimulacao = dataSimulacao;
        this.taxaJuros = (parcelas <= 48) ? 0.0438 : 0.0589;
        this.valorParcela = calcularValorParcela();
        this.realizado = false;
    }

    public double getValor() {
        return valorEmprestimo;
    }

    public int getParcelas() {
        return parcelas;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public LocalDate getDataSimulacao() {
        return dataSimulacao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void realizarEmprestimo() {
        if (!realizado) {
            contaCorrente.depositar(valorEmprestimo);
            dataEmprestimo = LocalDate.now();
            realizado = true;
        }
    }

    public void consultarDadosEmprestimo() {
        System.out.println("Valor do empréstimo: R$" + this.valorEmprestimo);
        System.out.println("Número de parcelas: " + this.parcelas);
        System.out.println("Taxa de juros mensal: " + this.taxaJuros * 100 + "%");
        System.out.println("Valor da parcela: R$" + this.valorParcela);
        System.out.println("Data da simulação: " + this.dataSimulacao);
        System.out.println("Empréstimo realizado: " + this.realizado);
        if (this.realizado) {
            System.out.println("Data do empréstimo: " + this.dataEmprestimo);
        }
    }

    private double calcularValorParcela() {
        double juros = Math.pow(1 + taxaJuros, parcelas);
        double valorParcela = valorEmprestimo * ((juros * taxaJuros) / (juros - 1));

        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat formato = new DecimalFormat("#0.00", formatSymbols);
        String valorParcelaFormatado = formato.format(valorParcela);

        return Double.parseDouble(valorParcelaFormatado);

    }
}