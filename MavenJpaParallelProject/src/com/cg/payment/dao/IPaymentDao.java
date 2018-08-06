package com.cg.payment.dao;

import com.cg.payment.bean.Payment;
import com.cg.payment.exception.PaymentException;


public interface IPaymentDao {
	public String createAccount(Payment account) throws PaymentException;
	public double showBalance(String mobileNo) throws PaymentException;
	Payment deposit(String mobileNo,double balance) throws PaymentException;
	Payment withdraw(String mobileNo,double balance) throws PaymentException;
    Payment printTransactionDetails(String mobileNo) throws PaymentException;
   public boolean fundTransfer(String sourceMobileNo,String destMobileNo,double transferAmount) throws PaymentException;
}
