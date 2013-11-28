package com.vincentko.financialstatement.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Calendar;
import java.util.Date;
import java.math.BigDecimal;


/**
 * PayCheck generated by hbm2java
 */
@Entity
@Table(name = "ft_paycheck")
public class PayCheck implements java.io.Serializable {

	private int paycheckId;
	private String title;
	private BigDecimal salary;
	private BigDecimal netPay;
	private BigDecimal taxes;
	private BigDecimal ferderalWithhold;
	private BigDecimal socialSecurity;
	private BigDecimal medicare;
	private BigDecimal stateWithhold;
	private BigDecimal deduction;
	private Calendar pubDate;

	public PayCheck() {
	}

	public PayCheck(int paycheckId) {
		this.paycheckId = paycheckId;
	}

	public PayCheck(int paycheckId, String title, BigDecimal salary, BigDecimal netPay,
			BigDecimal taxes, BigDecimal ferderalWithhold,
			BigDecimal socialSecurity, BigDecimal medicare,
			BigDecimal stateWithhold, BigDecimal deduction, Calendar pubDate) {
		this.paycheckId = paycheckId;
		this.title = title;
		this.netPay = netPay;
		this.taxes = taxes;
		this.ferderalWithhold = ferderalWithhold;
		this.socialSecurity = socialSecurity;
		this.medicare = medicare;
		this.stateWithhold = stateWithhold;
		this.deduction = deduction;
		this.pubDate = pubDate;
	}

	@Id
	@Column(name="paycheck_id")
	@GeneratedValue
	public int getPaycheckId() {
		return this.paycheckId;
	}

	public void setPaycheckId(int paycheckId) {
		this.paycheckId = paycheckId;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "salary", precision = 18)
	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Column(name = "net_pay", precision = 18)
	public BigDecimal getNetPay() {
		return this.netPay;
	}

	public void setNetPay(BigDecimal netPay) {
		this.netPay = netPay;
	}

	@Column(name = "taxes", precision = 18)
	public BigDecimal getTaxes() {
		return this.taxes;
	}

	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}

	@Column(name = "ferderal_withhold", precision = 18)
	public BigDecimal getFerderalWithhold() {
		return this.ferderalWithhold;
	}

	public void setFerderalWithhold(BigDecimal ferderalWithhold) {
		this.ferderalWithhold = ferderalWithhold;
	}

	@Column(name = "social_security", precision = 18)
	public BigDecimal getSocialSecurity() {
		return this.socialSecurity;
	}

	public void setSocialSecurity(BigDecimal socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	@Column(name = "medicare", precision = 18)
	public BigDecimal getMedicare() {
		return this.medicare;
	}

	public void setMedicare(BigDecimal medicare) {
		this.medicare = medicare;
	}

	@Column(name = "state_withhold", precision = 18)
	public BigDecimal getStateWithhold() {
		return this.stateWithhold;
	}

	public void setStateWithhold(BigDecimal stateWithhold) {
		this.stateWithhold = stateWithhold;
	}

	@Column(name = "deduction", precision = 18)
	public BigDecimal getDeduction() {
		return this.deduction;
	}

	public void setDeduction(BigDecimal deduction) {
		this.deduction = deduction;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pubDate", length = 23)
	public Calendar getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Calendar pubDate) {
		this.pubDate = pubDate;
	}

}
