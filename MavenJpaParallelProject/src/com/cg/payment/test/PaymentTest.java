package com.cg.payment.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.payment.bean.Payment;
import com.cg.payment.exception.PaymentException;
import com.cg.service.IPaymentService;
import com.cg.service.PaymentService;

public class PaymentTest { 

	private IPaymentService service= new PaymentService();
	
	@Test
	public void testCreateAccountForMobile() {
	Payment ac = new Payment();
	ac.setMobile_no("1234");
	ac.setCustomer_name("Santosh");
	ac.setEmail_id("santu247908@gmail.com");
	ac.setBalance(5000.0);
	try {
	service.createAccount(ac);
	} catch (PaymentException e) {
	assertEquals("Mobile number should contain 10 digits", e.getMessage());
	}
	}
	 
	@Test
	public void testCreateAccountForName() {
	Payment ac = new Payment();
	ac.setMobile_no("9848275672");
	ac.setCustomer_name("santu152670");
	ac.setEmail_id("subha@gmail.com");
	ac.setBalance(6000.0);
	try {
	service.createAccount(ac);
	} catch (PaymentException e) {
	assertEquals("Name should start with Capital letter and should contain only alphabets", e.getMessage());
	}
	}
	 
	@Test
	public void testCreateAccountForNameIsEmpty() {
	Payment ac = new Payment();
	ac.setMobile_no("9848216090");
	ac.setCustomer_name("");
	ac.setEmail_id("thammu@gmail.com");
	ac.setBalance(10000.0);
	try {
	service.createAccount(ac);
	} catch (PaymentException e) {
	assertEquals("Name cannot be empty", e.getMessage());
	}
	}	 
	@Test
	public void testCreateAccountForEmailId() {
	Payment ac = new Payment();
	ac.setMobile_no("8985102604");
	ac.setCustomer_name("Navya");
	ac.setEmail_id("ushasainavyasri5031@@23gmail.com");
	ac.setBalance(7000.0);
	try {
	service.createAccount(ac);
	} catch (PaymentException e) {
	assertEquals("Enter a valid EmailID", e.getMessage());
	}
	}

	
	

	@Test
	public void testCreateAccount() {
	Payment ac = new Payment();
	ac.setMobile_no("9444564560");
	ac.setCustomer_name("Sappaji");
	ac.setEmail_id("sri@gmail.com");
	ac.setBalance(53000.0);
	 
	try {
	String s=service.createAccount(ac);
	assertNotNull(s);
	} catch (PaymentException e) { 
	}	 
	}
	
	
	
	 
	/*@Test
	public void testShowBalanceForMobileNo() {
	try {
	service.showBalance("95059");
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	 
	@Test
	public void testShowBalanceForMobileNoDoesNotExist() {
	try {
	service.showBalance("9505928505");
	} catch (AccountException e) {
    assertEquals("the mobile number is not there in the data base",e.getMessage());
	}
	}*/
	
	/*@Test
	public void testShowBalanceForMobileNoCorrectCase() {
	try {
	service.showBalance("9848275682");
	} catch (AccountException e) {
    assertEquals("the mobile number is not there in the data base",e.getMessage());
	}
	}*/
	
	@Test
	public void testDepositForMobileNo() {
	Payment ac=new Payment();
	ac.setMobile_no("95345");
	try {
	service.deposit(ac.getMobile_no(), 230);
	} catch (PaymentException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	/*@Test
	public void testDepositForMobileNoDoesNotExist() {
	Account ac=new Account();
	ac.setMobile_no("9505934512");
	try {
	service.deposit(ac.getMobile_no(), 230);
	} catch (AccountException e) {
	assertEquals("the mobile number is not there in the data base",e.getMessage());
	}
	}
	@Test
	public void testDepositForDepositAmt1() {
	Account ac=new Account();
	ac.setMobile_no("9440275672");
	try {
	service.deposit(ac.getMobile_no(), -230);
	} catch (AccountException e) {
	assertEquals("deposit amount must be greater than zero",e.getMessage());
	}
	}
	@Test
	public void testDepositForDepositAmt1IsZero() {
	Account ac=new Account();
	ac.setMobile_no("8985102604");
	try {
	service.deposit(ac.getMobile_no(), 0);
	} catch (AccountException e) {
	assertEquals("deposit amount must be greater than zero",e.getMessage());
	}
	}
	 
	@Test
	public void testDeposit() {
	Account ac=new Account();
	ac.setMobile_no("8985102604");
	try {
	Account ac1=service.deposit("9999999999", 500);
	assertNotNull(ac1);
	} catch (AccountException e) {
	 
	//System.out.println(e.getMessage());
	}
	}
	 
	@Test
	public void testWithDrawForMobileNo() {
	Account ac=new Account();
	ac.setMobile_no("9345");
	try {
	service.withdraw(ac.getMobile_no(), 230);
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testWithdrawForMobileNoDoesNotExist() {
	Account ac=new Account();
	ac.setMobile_no("9505934512");
	try {
	service.withdraw(ac.getMobile_no(), 230);
	} catch (AccountException e) {
	assertEquals("the mobile number is not there in the data base",e.getMessage());
	}
	}
	@Test
	public void testWithdrawForAmt() {
	Account ac=new Account();
	ac.setMobile_no("8985102604");
	try {
	service.withdraw(ac.getMobile_no(), -230);
	} catch (AccountException e) {
	assertEquals("Amount should be greater than zero",e.getMessage());
	}
	}
	
	@Test
	public void testWithdrawForAmtIsZero() {
	Account ac=new Account();
	ac.setMobile_no("8985102604");
	try {
	service.withdraw(ac.getMobile_no(), 0);
	} catch (AccountException e) {
	assertEquals("Amount should be greater than zero",e.getMessage());
	}
	}*/
	 
	@Test
	public void testFundTransferForMobileNo() {
	Payment ac=new Payment();
	Payment ac2=new Payment();
	ac.setMobile_no("78945620");
	ac2.setMobile_no("1234");
	try {
	service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(), 230);
	} catch (PaymentException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	/*@Test
	public void testFundTransferForMobileNoDoesNotExist() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("1234567890");
	ac2.setMobile_no("0987654321");
	try {
	service.fundTransfer(ac.getMobile_no(), ac2.getMobile_no(),  230);
	} catch (AccountException e) {
	assertEquals("the mobile number is not there in the data base",e.getMessage());
	}
	}
	@Test
	public void testFundTransferForAmt() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("9440275672");
	ac2.setMobile_no("8985102604");
	try {
	service.fundTransfer(ac.getMobile_no(), ac2.getMobile_no(),  -230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	assertEquals("Amount should be greater than zero",e.getMessage());
	}
	}
	@Test
	public void testFundTransfer() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("9505928555");
	ac2.setMobile_no("9848468242");
	try {
	assertTrue(service.fundTransfer(ac.getMobile_no(), ac2.getMobile_no(),  230));
	} catch (AccountException e) {
	}
	}*/
/*	@Test
	public void testPrinttransactionDetails() {
	Payment ac=new Payment();
	ac.setMobile_no("9848468242");
	try {
	Payment acc=service.printTransactionDetails(ac.getMobile_no());
	assertNotNull(acc);
	} catch (PaymentException e) {
	//System.out.println(e.getMessage());
	}
	}*/
	
	@Test
	public void testPrinttransactionDetailsForMobile() {
		Payment ac=new Payment();
		ac.setMobile_no("89851");
		try {
		Payment acc=service.printTransactionDetails(ac.getMobile_no());
		} catch (PaymentException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	/*@Test
	public void testPrinttransactionDetailsForMobileDoesNotExist() {
		Payment ac=new Payment();
		ac.setMobile_no("1234567890");
		try {
		Payment acc=service.printTransactionDetails(ac.getMobile_no());
		} catch (PaymentException e) {
		assertEquals("the mobile number is not there in the data base",e.getMessage());
		}
	}*/
	
	@Test
	public void testFundTransferForFirstMobile() {
	Payment ac=new Payment();
	Payment ac2=new Payment();
	ac.setMobile_no("950592");
	ac2.setMobile_no("9848468242");
	try {
		service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(),230);
	} catch (PaymentException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	
	@Test
	public void testFundTransferForSecondMobile() {
	Payment ac=new Payment();
	Payment ac2=new Payment();
	ac.setMobile_no("9999999999");
	ac2.setMobile_no("9848");
	try {
		service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(),230);
	} catch (PaymentException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	
	/*@Test
	public void testFundTransferForFirstMobileExist() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("9999888888");
	ac2.setMobile_no("9999999999");
	try {
		service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(),230);
	} catch (AccountException e) {
		assertEquals("the mobile number is not there in the data base",e.getMessage());
	}
	}
	
	@Test
	public void testFundTransferForSecondMobileExist() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("9999999999");
	ac2.setMobile_no("8888888888");
	try {
		service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(),-230);
	} catch (AccountException e) {
		assertEquals("Amount should be greater than zero",e.getMessage());
	}
	}
	*/
	@Test
	public void testShowBalanceForMobileNo() {

	try {
	service.showBalance("36521");
	} catch (PaymentException e) {

	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	} 
	
	@Test
	public void testWithDrawForMobileNo() {
	Payment acc=new Payment();
	acc.setMobile_no("9505934");
	try {
	service.withdraw(acc.getMobile_no(), 230);
	} catch (PaymentException e) {
	// TODO Auto-generated catch block
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	} 
	
	@Test
	public void testDepositForDepositAmt1() {
	Payment acc=new Payment();
	acc.setMobile_no("9912365478");
	try {
	service.deposit(acc.getMobile_no(),-230);
	} catch (PaymentException e) {
	assertEquals("deposit amount must be greater than zero",e.getMessage());
	}
	} 
}
