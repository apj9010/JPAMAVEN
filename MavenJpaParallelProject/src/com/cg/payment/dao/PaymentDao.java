package com.cg.payment.dao;

import java.time.LocalDateTime;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.payment.bean.Payment;
import com.cg.payment.exception.PaymentException;



public class PaymentDao implements IPaymentDao{
//	static HashMap<String, Account> accountEntry=AccountDB.getAccountDb();
	EntityManagerFactory fact=Persistence.createEntityManagerFactory("hello");
	EntityManager em=fact.createEntityManager();
	@Override
	public String createAccount(Payment account) throws PaymentException {
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		return account.getMobile_no();
	}

	@Override
	public double showBalance(String mobileNo) throws PaymentException {
		String strqry="select e from Account e where e.mobile_no=?";
		TypedQuery<Payment> query=em.createQuery(strqry,Payment.class);
		query.setParameter(1,mobileNo);
		Payment acc=query.getSingleResult();
   if(!mobileNo.equals(acc.getMobile_no())){
	throw new PaymentException("the mobile number is not there in the data base");}
   else{
		return acc.getBalance();
   }
	}

	@Override
	public Payment deposit(String mobileNo,double balance) throws PaymentException {
		em.getTransaction().begin();
		String strqry="select e from Account e where e.mobile_no=?";
		TypedQuery<Payment> query=em.createQuery(strqry,Payment.class);
		query.setParameter(1,mobileNo);
		Payment acc=query.getSingleResult();
		if(acc==null){
			throw new PaymentException("the mobile number is not there in the data base");
		}
		double d=acc.getBalance()+balance;
		acc.setBalance(d);
		em.merge(acc);
		em.getTransaction().commit();
		return acc;
	}

	@Override
	public Payment withdraw(String mobileNo,double balance) throws PaymentException {
		em.getTransaction().begin();
		String strqry="select e from Account e where e.mobile_no=?";
		TypedQuery<Payment> query=em.createQuery(strqry,Payment.class);
		query.setParameter(1,mobileNo);
		Payment acc=query.getSingleResult();
		if(acc==null){
			throw new PaymentException("the mobile number is not there in the data base");
		}
		double d=acc.getBalance()-balance;
		acc.setBalance(d);
		em.merge(acc);
		em.getTransaction().commit();
		
		return acc;
	}

	@Override
	public Payment printTransactionDetails(String mobileNo)
			throws PaymentException {
		String strqry="select e from Account e where e.mobile_no=?";
		TypedQuery<Payment> query=em.createQuery(strqry,Payment.class);
		query.setParameter(1,mobileNo);
		Payment acc=query.getSingleResult();
   if(acc==null){
	throw new PaymentException("the mobile number is not there in the data base");

}
		return acc;
	}

	@Override
	public boolean fundTransfer(String sourceMobileNo, String destMobileNo,
			double transferAmount) throws PaymentException {
		String strqry="select e from Account e where e.mobile_no=?";
			TypedQuery<Payment> query=em.createQuery(strqry,Payment.class);
			query.setParameter(1,sourceMobileNo);
			Payment acc=query.getSingleResult();
			String strqry1="select e from Account e where e.mobile_no=?";
			TypedQuery<Payment> query1=em.createQuery(strqry1,Payment.class);
			query1.setParameter(1,destMobileNo);
			Payment acc1=query.getSingleResult();
		if(acc==null){
			throw new PaymentException("the mobile number is not there in the data base");
		}
		else if(acc1==null)
		{
			throw new PaymentException("the mobile number is not there in the data base");
		}
		else
		{
		return true;
		}
	}


}
