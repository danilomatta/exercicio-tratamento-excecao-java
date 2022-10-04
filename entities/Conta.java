package SECAO15_177_EXERCICIO_TRATAMENTO_EXCESSOES.entities;

import SECAO15_177_EXERCICIO_TRATAMENTO_EXCESSOES.exceptions.DomainExceptions;

public class Conta {

	private int numeroConta;
	private String titular;
	private double saldo;
	private double limiteSaque;
	private double saldoAnterior;
	
	
	
	public Conta(int numeroConta, String titular, double saldo, double limiteSaque) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
		saldoAnterior = this.saldo;
	}

	public void depositar(double valor) {
		saldo +=valor;
	}
	
	public void sacar(double valor) throws DomainExceptions {
		if(valor > limiteSaque) {
			throw new DomainExceptions("Valor excede limite de saque");
		}else {
			if(valor > saldo) {
				throw new DomainExceptions("Saldo indisponível");
			}
		}
		saldo-=valor;
		
	}
	
	@Override
	public String toString() {
		return "Saldo anterior: "+saldoAnterior+"\n"
				+". Saldo atual: "+saldo;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public double getLimiteSaque() {
		return limiteSaque;
	}
}
