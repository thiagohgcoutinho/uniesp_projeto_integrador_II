package aplicacao;

import entidades.*;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        Usuario usuario1 = new Usuario(
                "Thiago",
                "058.945.024-70",
                "thiagohgcoutinho@gmail.com",
                37,
                "83 99144-5979",
                "Rua Antônio Vieira da Silva, 400",
                "231287"
        );

        System.out.println("Criada a conta de " + usuario1.getNome() + ".");

        Usuario usuario2 = new Usuario(
                "Luiz",
                "014.983.852-54",
                "luizcarlos@gmail.com",
                19,
                "83 98751-2373",
                "Rua Gov. Flávio Ribeiro Coutinho, 1754",
                "109421"
        );

        System.out.println("Criada a conta de " + usuario2.getNome() + ".");

        System.out.println("Realizando Login de " + usuario1.getNome() + " com e-mail e senha.");

        Login login1 = new Login(usuario1, "thiagohgcoutinho@gmail.com", "231287");

        login1.fazerLogin();

        System.out.println("Alterando a senha, confirmando os dados de e-mail, CPF e digitando a nova senha.");

        login1.esqueciSenha("thiagohgcoutinho@gmail.com", "058.945.024-70", "140320");

        System.out.println("Criando a Conta Corrente para " + usuario1.getNome() + ".");

        ContaCorrente contaCorrente1 = new ContaCorrente(usuario1);

        System.out.println("Criando a Conta Poupança para " + usuario1.getNome() + ".");

        ContaPoupanca contaPoupanca1 = new ContaPoupanca(usuario1);

        System.out.println("Criando a Conta Investimento para " + usuario1.getNome() + ".");

        ContaInvestimento contaInvestimento1 = new ContaInvestimento(usuario1);

        System.out.println("Criando a Conta Corrente para " + usuario2.getNome() + ".");

        ContaCorrente contaCorrente2 = new ContaCorrente(usuario2);

        System.out.println("Consulta dos dados de " + usuario1.getNome() + ".");

        contaCorrente1.consultarDadosUsuario();

        System.out.println("Consulta dos dados da Conta Corrente de " + usuario1.getNome() + ".");

        contaCorrente1.consultarDadosConta();

        System.out.println("Consulta do saldo da Conta Corrente de " + usuario1.getNome() + ".");

        contaCorrente1.consultarSaldo();

        System.out.println("Consulta do Limite do Cheque Especial da Conta Corrente de " + usuario1.getNome() + ".");

        contaCorrente1.consultarLimiteChequeEspecial();

        System.out.println("Consulta dos dados da Conta Poupança de " + usuario1.getNome() + ".");

        contaPoupanca1.consultarDadosConta();

        System.out.println("Consulta do saldo da Conta Poupança de " + usuario1.getNome() + ".");

        contaPoupanca1.consultarSaldo();

        System.out.println("Consulta dos dados da Conta Investimento de " + usuario1.getNome() + ".");

        contaInvestimento1.consultarDadosConta();

        System.out.println("Consulta do saldo da Conta Investimento de " + usuario1.getNome() + ".");

        contaInvestimento1.consultarSaldo();

        System.out.println("Depósito na Conta Corrente de " + usuario1.getNome() + ".");

        contaCorrente1.depositar(1000.0);

        System.out.println("Saque na Conta Corrente de " + usuario1.getNome() + ".");

        contaCorrente1.sacar(150.0);

        System.out.println("Depósito na Conta Poupança de " + usuario1.getNome() + ".");

        contaPoupanca1.depositar(5000.0);

        System.out.println("Saque na Conta Poupança de " + usuario1.getNome() + ".");

        contaPoupanca1.sacar(250.0);

        System.out.println("Depósito na Conta Investimento de " + usuario1.getNome() + ".");

        contaInvestimento1.depositar(10000.0);

        System.out.println("Saque na Conta Investimento de " + usuario1.getNome() + ".");

        contaInvestimento1.sacar(1250.0);

        System.out.println("Rendimento da Conta Poupança de " + usuario1.getNome() + ".");

        contaPoupanca1.rendimentoPoupanca();

        System.out.println("Rendimento da Conta Investimento de " + usuario1.getNome() + ".");

        contaInvestimento1.rendimentoInvestimento();

        System.out.println("Transferência da Conta Corrente de " + usuario1.getNome() + " para Conta Corrente de " + usuario2.getNome() + ".");

        contaCorrente1.transferir(contaCorrente2,200.0);

        System.out.println("Solicitação de Cartão de Crédito de " + usuario1.getNome() + ".");

        CartaoDeCredito cartaoDeCredito1 = new CartaoDeCredito(contaCorrente1);

        System.out.println("Consultar dados do Cartao de Crédito de " + usuario1.getNome());

        cartaoDeCredito1.consultarDadosCartao();

        System.out.println("Solicitação de Upgrade de Cartão de Crédito de " + usuario1.getNome() + ".");

        cartaoDeCredito1.solicitarUpgradeParaPlatinum();

        cartaoDeCredito1.consultarDadosCartao();

        System.out.println("Solicitação de novo Upgrade de Cartão de Crédito de " + usuario1.getNome() + ".");

        cartaoDeCredito1.solicitarUpgradeParaBlack();

        cartaoDeCredito1.consultarDadosCartao();

        System.out.println("Alteração de senha de Cartão de Crédito de " + usuario1.getNome() + ".");

        cartaoDeCredito1.alterarSenha("1463");

        System.out.println("Realização de compra no Cartão de Crédito de " + usuario1.getNome() + ".");

        cartaoDeCredito1.valorCompraCartao(350.0, LocalDate.ofEpochDay(2023-4-29));

        System.out.println("Consulta da fatura do Cartão de Crédito de " + usuario1.getNome() + ".");

        cartaoDeCredito1.consultarFatura(4, 2023);

        System.out.println("Pagamento da fatura do Cartão de Crédito de " + usuario1.getNome() + ".");

        cartaoDeCredito1.pagarFatura(4, 2023, usuario1);

        System.out.println("Consulta do saldo da Conta Corrente de " + usuario1.getNome() + ".");

        contaCorrente1.consultarSaldo();

        System.out.println("Realização de um pagamento de boleto na Conta Corrente de " + usuario1.getNome() + ".");

        Pagamento pagamento1 = new Pagamento(contaCorrente1, 100, "1234567890", LocalDate.ofEpochDay(2023-4-29));

        pagamento1.realizarPagamento();

        System.out.println("Consulta do saldo da Conta Corrente de " + usuario1.getNome() + ".");

        contaCorrente1.consultarSaldo();

        System.out.println("Realização de empréstimo da Conta Corrente de " + usuario1.getNome() + ".");

        Emprestimo emprestimo1 = new Emprestimo(contaCorrente1, 20000, 60, LocalDate.of(2023, 5, 14));

        emprestimo1.realizarEmprestimo();

        System.out.println("Consulta dos dados do empréstimo da Conta Corrente de " + usuario1.getNome() + ".");

        emprestimo1.consultarDadosEmprestimo();

        System.out.println("Consulta do saldo da Conta Corrente de " + usuario1.getNome() + ".");

        contaCorrente1.consultarSaldo();

    }

}
