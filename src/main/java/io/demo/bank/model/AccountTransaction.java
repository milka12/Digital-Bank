package io.demo.bank.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class AccountTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id", nullable=false, updatable=false)
	private Long id;
	private String description;
	private BigDecimal amount;
	private BigDecimal runningBalance;
	
	@Column(name="transactionNumber", nullable=false, unique=true)
	private Long transactionNumber;

	
	@JsonFormat(pattern="yyyy-MM-dd'T'hh:mm")
	@DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm")
	private Date transactionDate;
	
	@JsonIgnore
	@ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
	
	@ManyToOne (fetch = FetchType.EAGER)
    private TransactionType transactionType;
	
	@ManyToOne (fetch = FetchType.EAGER)
    private TransactionState transactionState;
	
	@ManyToOne (fetch = FetchType.EAGER)
    private TransactionCategory transactionCategory;
	
	public AccountTransaction() {
		
	}

	public AccountTransaction(Long id, String description, BigDecimal amount, BigDecimal runningBalance,
			Long transactionNumber, Date transactionDate, Account account, TransactionType transactionType,
			TransactionState transactionState, TransactionCategory transactionCategory) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.runningBalance = runningBalance;
		this.transactionNumber = transactionNumber;
		this.transactionDate = transactionDate;
		this.account = account;
		this.transactionType = transactionType;
		this.transactionState = transactionState;
		this.transactionCategory = transactionCategory;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		
		
		this.amount = new BigDecimal(amount.doubleValue()).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the type
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}
	
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the state
	 */
	public TransactionState getTransactionState() {
		return transactionState;
	}

	/**
	 * @param state the state to set
	 */
	public void setTransactionState(TransactionState transactionState) {
		this.transactionState = transactionState;
	}

	/**
	 * @return the runningBalance
	 */
	public BigDecimal getRunningBalance() {
		return runningBalance;
	}

	/**
	 * @param runningBalance the runningBalance to set
	 */
	public void setRunningBalance(BigDecimal runningBalance) {
		this.runningBalance = new BigDecimal(runningBalance.doubleValue()).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * @return the transactionNumber
	 */
	public Long getTransactionNumber() {
		return transactionNumber;
	}

	/**
	 * @param transactionNumber the transactionNumber to set
	 */
	public void setTransactionNumber(Long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	/**
	 * @return the category
	 */
	public TransactionCategory getTransactionCategory() {
		return transactionCategory;
	}

	/**
	 * @param category the category to set
	 */
	public void setTransactionCategory(TransactionCategory transactionCategory) {
		this.transactionCategory = transactionCategory;
	}

}
