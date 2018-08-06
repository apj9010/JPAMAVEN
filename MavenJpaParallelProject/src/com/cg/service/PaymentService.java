package com.cg.service;

import java.time.LocalDateTime;

import com.cg.payment.bean.Payment;
import com.cg.payment.dao.IPaymentDao;
import com.cg.payment.dao.PaymentDao;
import com.cg.payment.exception.PaymentException;

public class PaymentService implements IPaymentService {
IPaymentDao dao=new PaymentDao();
	
	@Override
	public String createAccount(Payment account) throws PaymentException {
	if(!account.getMobile_no().matches("\\d{10}")){
		throw new PaymentException("Mobile number should contain 10 digits");
	}
	if(account.getCustomer_name().isEmpty()||account.getCustomer_name()==null){
		throw new PaymentException("Name cannot be empty");
	} else{
		if(!account.getCustomer_name().matches("[A-Z][A-Za-z]{3,}")){
			throw new PaymentException("Name should start with Capital letter and should contain only alphabets");
		}
	}
	if(!account.getEmail_id().matches("[a-z0-9]+@[a-z]+\\.com")){
		throw new PaymentException("Enter a valid EmailID");
	}
	if(account.getBalance()<=0){
		throw new PaymentException("Balance should be greater than zero");
	}
		return dao.createAccount(account);
	}

	@Override
	public double showBalance(String mobileNo) throws PaymentException {
		if(!mobileNo.matches("\\d{10}")){
			throw new PaymentException("Mobile number should contain 10 digits");
		}
		return dao.showBalance(mobileNo);
	}

	@Override
	public Payment deposit(String mobileNo, double depositAmount)
			throws PaymentException {
		if(!mobileNo.matches("\\d{10}")){
			throw new PaymentException("Mobile number should contain 10 digits");
		}
		
		if(depositAmount<=0){
				throw new PaymentException("deposit amount must be greater than zero");
		}
		Payment account=dao.deposit(mobileNo, depositAmount);
		return account;
	}

	@Override
	public Payment withdraw(String mobileNo, double withdrawAmount)
			throws PaymentException {
		//Payment account=dao.withdraw(mobileNo, withdrawAmount);
		if(!mobileNo.matches("\\d{10}")){
			throw new PaymentException("Mobile number should contain 10 digits");
		}
		 if(withdrawAmount<=0){
			throw new PaymentException("Amount should be greater than zero");	
		}
		 Payment account=dao.withdraw(mobileNo, withdrawAmount);
		 if(withdrawAmount>account.getBalance()){
			throw new PaymentException("Balance should be greater than the withdraw amount");
		}
		/*else if(!mobileNo.equals(account.getMobile_no())){
			throw new AccountException("the mobile number is not there in the data base");
		}*/
		
		
			return account;
			
		
		}
	
	

	@Override
	public Payment printTransactionDetails(String mobileNo)
			throws PaymentException {
		if(!mobileNo.matches("\\d{10}")){
			throw new PaymentException("Mobile number should contain 10 digits");
		}
		else
		{
		return dao.printTransactionDetails(mobileNo);
	}}

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destMobileNo, double transferAmount) throws PaymentException {
		if(!sourceMobileNo.matches("\\d{10}")){
			throw new PaymentException("Mobile number should contain 10 digits");
		}
			if(!destMobileNo.matches("\\d{10}")){
				throw new PaymentException("Mobile number should contain 10 digits");
			}
		IPaymentService service =new PaymentService();
		service.withdraw(sourceMobileNo, transferAmount);
		service.deposit(destMobileNo, transferAmount);
		
		return true;
	}


}