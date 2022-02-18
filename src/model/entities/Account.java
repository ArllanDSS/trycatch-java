package model.entities;

import model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account(Integer number, String holde, Double balance, Double withdrawLimit) {

		this.number = number;
		this.holder = holde;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;

	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(Double deposit) {
		
		balance += deposit;

	}

	public void withdraw(Double withdraw) throws DomainException {

		if(withdraw > withdrawLimit) {
			
			throw new DomainException("The amount exceeds withdraw limit");
			
		}
		
		if(withdraw > balance) {
			
			throw new DomainException("Not enough balance");
			
		}
			
		balance -= withdraw;

	}
	
	@Override
	public String toString() {
		
		return  "New Balance: " + String.format("%.2f", balance);
		
	}

}
