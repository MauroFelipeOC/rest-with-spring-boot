package com.example.data.vo.v1;

import java.io.Serializable;

public class UploadFileResponseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String fileNameString;
	private String fileDownloadUri;
	private String fileSize;
	private long size;
	
	public UploadFileResponseVO() {
	}

	public UploadFileResponseVO(String fileNameString, String fileDownloadUri, String fileSize, long size) {
		this.fileNameString = fileNameString;
		this.fileDownloadUri = fileDownloadUri;
		this.fileSize = fileSize;
		this.size = size;
	}

	public String getFileNameString() {
		return fileNameString;
	}

	public void setFileNameString(String fileNameString) {
		this.fileNameString = fileNameString;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	
}
