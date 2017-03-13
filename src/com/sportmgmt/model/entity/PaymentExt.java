package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_EXT")
public class PaymentExt {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="PAYMENT_EXT_ID")
	private Integer paymentExtId;
	
	@Column(name="TRANSACTION_ID")
	private Integer transactionId;
	
	@Column(name="MERCHAND_KEY")
	private String merchantKey;
	
	@Column(name="PAYU_MONEY_ID")
	private String payuMoneyId;
	
	@Column(name="UN_MAPPED_STATUS")
	private String unMappedStatus;
	
	@Column(name="CARD_NUM")
	private String cardNum;
	
	@Column(name="NAME_ON_CARD")
	private String nameOnCard;
	
	@Column(name="HASH")
	private String hash;
	
	@Column(name="INC_PAY_MONEY_ID")
	private String incPayMoneyId;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="UDF1")
	private String udf1;
	
	@Column(name="UDF2")
	private String udf2;
	
	@Column(name="UDF3")
	private String udf3;
	
	@Column(name="UDF4")
	private String udf4;
	
	@Column(name="UDF5")
	private String udf5;
	
	@Column(name="UDF6")
	private String udf6;
	
	@Column(name="UDF7")
	private String udf7;
	
	@Column(name="UDF8")
	private String udf8;
	
	@Column(name="UDF9")
	private String udf9;
	
	@Column(name="UDF10")
	private String udf10;
	
	@Column(name="FIELD1")
	private String field1;
	
	@Column(name="FIELD2")
	private String field2;
	
	@Column(name="FIELD3")
	private String field3;
	
	@Column(name="FIELD4")
	private String field4;
	
	@Column(name="FIELD5")
	private String field5;
	
	@Column(name="FIELD6")
	private String field6;
	
	@Column(name="FIELD7")
	private String field7;
	
	@Column(name="FIELD8")
	private String field8;
	
	@Column(name="FIELD9")
	private String field9;
	
	@Column(name="FIELD10")
	private String field10;
	
	@Column(name="FIELD11")
	private String field11;

	public Integer getPaymentExtId() {
		return paymentExtId;
	}

	public void setPaymentExtId(Integer paymentExtId) {
		this.paymentExtId = paymentExtId;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getMerchantKey() {
		return merchantKey;
	}

	public void setMerchantKey(String merchantKey) {
		this.merchantKey = merchantKey;
	}

	public String getPayuMoneyId() {
		return payuMoneyId;
	}

	public void setPayuMoneyId(String payuMoneyId) {
		this.payuMoneyId = payuMoneyId;
	}

	public String getUnMappedStatus() {
		return unMappedStatus;
	}

	public void setUnMappedStatus(String unMappedStatus) {
		this.unMappedStatus = unMappedStatus;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getIncPayMoneyId() {
		return incPayMoneyId;
	}

	public void setIncPayMoneyId(String incPayMoneyId) {
		this.incPayMoneyId = incPayMoneyId;
	}

	public String getUdf1() {
		return udf1;
	}

	public void setUdf1(String udf1) {
		this.udf1 = udf1;
	}

	public String getUdf2() {
		return udf2;
	}

	public void setUdf2(String udf2) {
		this.udf2 = udf2;
	}

	public String getUdf3() {
		return udf3;
	}

	public void setUdf3(String udf3) {
		this.udf3 = udf3;
	}

	public String getUdf4() {
		return udf4;
	}

	public void setUdf4(String udf4) {
		this.udf4 = udf4;
	}

	public String getUdf5() {
		return udf5;
	}

	public void setUdf5(String udf5) {
		this.udf5 = udf5;
	}

	public String getUdf6() {
		return udf6;
	}

	public void setUdf6(String udf6) {
		this.udf6 = udf6;
	}

	public String getUdf7() {
		return udf7;
	}

	public void setUdf7(String udf7) {
		this.udf7 = udf7;
	}

	public String getUdf8() {
		return udf8;
	}

	public void setUdf8(String udf8) {
		this.udf8 = udf8;
	}

	public String getUdf9() {
		return udf9;
	}

	public void setUdf9(String udf9) {
		this.udf9 = udf9;
	}

	public String getUdf10() {
		return udf10;
	}

	public void setUdf10(String udf10) {
		this.udf10 = udf10;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getField5() {
		return field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	public String getField6() {
		return field6;
	}

	public void setField6(String field6) {
		this.field6 = field6;
	}

	public String getField7() {
		return field7;
	}

	public void setField7(String field7) {
		this.field7 = field7;
	}

	public String getField8() {
		return field8;
	}

	public void setField8(String field8) {
		this.field8 = field8;
	}

	public String getField9() {
		return field9;
	}

	public void setField9(String field9) {
		this.field9 = field9;
	}

	public String getField10() {
		return field10;
	}

	public void setField10(String field10) {
		this.field10 = field10;
	}

	public String getField11() {
		return field11;
	}

	public void setField11(String field11) {
		this.field11 = field11;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
