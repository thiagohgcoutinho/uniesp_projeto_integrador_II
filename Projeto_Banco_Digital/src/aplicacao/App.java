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

        System.out.println("Criado a conta de " + usuario1.getNome());

        Usuario usuario2 = new Usuario(
                "Luiz",
                "014.983.852-54",
                "luizcarlos@gmail.com",
                19,
                "83 98751-2373",
                "Rua Gov. Flávio Ribeiro Coutinho, 1754",
                "109421"
        );

        System.out.println("Criado a conta de " + usuario2.getNome());

        Login login1 = new Login(usuario1, "thiagohgcoutinho@gmail.com", "231287");

        login1.fazerLogin();

        login1.esqueciSenha("thiagohgcoutinho@gmail.com", "058.945.024-70", "140320");

        ContaCorrente contaCorrente1 = new ContaCorrente(usuario1);

        ContaCorrente contaCorrente2 = new ContaCorrente(usuario2);

        contaCorrente1.consultarDadosUsuario();

        contaCorrente1.consultarDadosContaCorrente();

        contaCorrente1.consultarSaldo();

        contaCorrente1.consultarLimiteChequeEspecial();

        contaCorrente1.depositar(1000.0);

        contaCorrente1.transferir(contaCorrente2,200.0);

        CartaoDeCredito cartaoDeCredito1 = new CartaoDeCredito(contaCorrente1);

        cartaoDeCredito1.solicitarUpgradeParaPlatinum();

        cartaoDeCredito1.solicitarUpgradeParaBlack();

        cartaoDeCredito1.alterarSenha("1463");

        cartaoDeCredito1.valorCompraCartao(350.0, LocalDate.ofEpochDay(2023-4-29));

        cartaoDeCredito1.consultarFatura(4, 2023);

        cartaoDeCredito1.pagarFatura(4, 2023, usuario1);

        contaCorrente1.consultarSaldo();

        Pagamento pagamento1 = new Pagamento(contaCorrente1, 100, "1234567890", LocalDate.ofEpochDay(2023-4-29));

        pagamento1.realizarPagamento();

        contaCorrente1.consultarSaldo();

        Emprestimo emprestimo1 = new Emprestimo(contaCorrente1, 20000, 60, LocalDate.ofEpochDay(2023-4-29));

        emprestimo1.realizarEmprestimo();

        emprestimo1.consultarDadosEmprestimo();

        contaCorrente1.consultarSaldo();

    }

}
