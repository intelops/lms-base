package com.spring.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "email")
public class Email implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String toMail;
	@Column
	private String fromMail;
	
	public String getFromMail() {
		return fromMail;
	}


	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}


	@Column
	private String ccMail;
	@Column
	private String bccMail;
	@Column
	private String mailContent;
	@Column
	private String subject;
	@Column
	private String attachment;
	@Column
	private String contentType;
	@Column
	private String attachmentType;
	@Column
	private String fileName;
	@Column
	private int attachmentSize;
	//@CreationTimestamp
	//@Column(columnDefinition = "TIMESTAMP")
	//@Temporal(TemporalType.TIMESTAMP)
	//private Date date;
	//private String text;

	



	public String getBccMail() {
		return bccMail;
	}


	public int getAttachmentSize() {
		return attachmentSize;
	}


	public void setAttachmentSize(int attachmentSize) {
		this.attachmentSize = attachmentSize;
	}


	public void setBccMail(String bccMail) {
		this.bccMail = bccMail;
	}


	

	public String getContentType() {
		return contentType;
	}


	public String getAttachmentType() {
		return attachmentType;
	}


	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	

	public String getToMail() {
		return toMail;
	}


	public void setToMail(String toMail) {
		this.toMail = toMail;
	}


	public String getCcMail() {
		return ccMail;
	}


	public void setCcMail(String ccMail) {
		this.ccMail = ccMail;
	}


	
	public String getMailContent() {
		return mailContent;
	}


	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}


	public String getAttachment() {
		return attachment;
	}


	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	

}
