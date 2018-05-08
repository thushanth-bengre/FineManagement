package com.me.transport.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="appeal")
public class Appeal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appealId;
	
	@OneToOne(mappedBy ="appeal", cascade=CascadeType.ALL)    
	private Fine fine;
	
	@Column(columnDefinition = "TEXT")
	private String summary;
	
	@Enumerated(EnumType.STRING)
	private AppealStatus status;
	
	@Temporal(TemporalType.DATE)
	private Date hearingDate;
	private String court;
	private String filePath;
	//private CommonsMultipartFile file;
	
	
	public Appeal() {		
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



	public int getAppealId() {
		return appealId;
	}
	public void setAppealId(int appealId) {
		this.appealId = appealId;
	}
	public Fine getFine() {
		return fine;
	}
	public void setFine(Fine fine) {
		this.fine = fine;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public AppealStatus getStatus() {
		return status;
	}
	public void setStatus(AppealStatus status) {
		this.status = status;
	}
	public Date getHearingDate() {
		return hearingDate;
	}
	public void setHearingDate(Date hearingDate) {
		this.hearingDate = hearingDate;
	}
	public String getCourt() {
		return court;
	}
	public void setCourt(String court) {
		this.court = court;
	}
	
	
}
