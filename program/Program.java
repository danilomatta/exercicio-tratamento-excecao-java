package SECAO15_177_EXERCICIO_TRATAMENTO_EXCESSOES.program;

import java.util.InputMismatchException;
import java.util.Scanner;

import SECAO15_177_EXERCICIO_TRATAMENTO_EXCESSOES.entities.Conta;
import SECAO15_177_EXERCICIO_TRATAMENTO_EXCESSOES.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			
			System.out.print("Informe numero da conta: ");
			int numeroConta = scan.nextInt();
			scan.nextLine();
			System.out.print("Titular da conta: ");
			String titular = scan.nextLine();
			System.out.print("Saldo inicial: ");
			double saldo = scan.nextDouble();
			System.out.print("Limite para saque: ");
			double limiteSaque = scan.nextDouble();
			Conta conta = new Conta(numeroConta, titular, saldo, limiteSaque);
			System.out.println("digite o valor de saque: ");
			double saque = scan.nextDouble();
			conta.sacar(saque);
			System.out.println(conta);
		}

		catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Numero da conta nao pode ser decimal nem caractere");
		}
		scan.close();
	}

}
