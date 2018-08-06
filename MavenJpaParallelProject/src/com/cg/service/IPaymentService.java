package com.cg.service;

import com.cg.payment.bean.Payment;
import com.cg.payment.exception.PaymentException;

public interface IPaymentService {

	public String createAccount(Payment account) throws PaymentException;
	public double showBalance(String mobileNo) throws PaymentException;
	public Payment deposit(String mobileNo,double depositAmount) throws PaymentException;
	public Payment withdraw(String mobileNo,double withdrawAmount) throws PaymentException;
	public Payment printTransactionDetails(String mobileNo) throws PaymentException;
    public boolean fundTransfer(String sourceMobileNo,String destMobileNo,double transferAmount) throws PaymentException;
}
