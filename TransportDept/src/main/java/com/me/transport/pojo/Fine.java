package com.me.transport.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="fine")
public class Fine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fineId;
	private double amount;
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lpNumber")
	private LicensePlate licensePlate;	
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="appealId")
	private Appeal appeal;
	
	@Column(columnDefinition = "TEXT")
	private String summary;
	
	@Enumerated(EnumType.STRING)
	private FineStatus Status;
	private String filePath;
	//private CommonsMultipartFile file;	
	
	
	public Fine() {		
	}
	
	
	
	public LicensePlate getLicensePlate() {
		return licensePlate;
	}



	public void setLicensePlate(LicensePlate licensePlate) {
		this.licensePlate = licensePlate;
	}



	public Appeal getAppeal() {
		return appeal;
	}



	public void setAppeal(Appeal appeal) {
		this.appeal = appeal;
	}



	public int getFineId() {
		return fineId;
	}

	public void setFineId(int fineId) {
		this.fineId = fineId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public FineStatus getStatus() {
		return Status;
	}

	public void setStatus(FineStatus status) {
		Status = status;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/*public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}*/
	
	@Override
	public String toString() {
		return String.valueOf(Status);
	}
	
	
}
