package test.exception;

import test.exception.OverDraftException;

public class Account {
	
	// 余额
	protected double balance;
	
	// 透支额
	protected double deficit;
	
	/**
	 * 初始化
	 * @param balance
	 */
	public Account(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	/**
	 *  存钱
	 * @param amt
	 */
	public void deposit(double amt) {
		this.balance += amt;
	}
	
	/**
	 * 取钱
	 * @param money
	 * @throws OverDraftException
	 */
	public void withdraw(double money) throws OverDraftException {
		// 如果余额不够，则抛出异常
		if(this.balance < money) {
			throw new OverDraftException("余额不足", money - this.balance);
		}
		
		this.balance -= money;
	}
	
	 public static void main(String[] args) {
		 // 开户存了 100
		 Account a = new Account(100);
		 
		 a.deposit(1000);
		 
		 // 查看余额
		 System.out.println(a.getBalance());
		 
		 try {
			 a.withdraw(2000);
			 
		 } catch(OverDraftException e) {
			 System.err.println("透支金额："+ e.getDeficit());
			 e.printStackTrace();
			 
		 }
	 }
	

}
