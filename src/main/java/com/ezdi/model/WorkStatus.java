package com.ezdi.model;

public class WorkStatus {
	
	private String workName;
	private String workStatus;
	
	public WorkStatus(String wName, String wStatus) {
		workName = wName;
		workStatus = wStatus;
	}
	/**
	 * @return the workName
	 */
	public String getWorkName() {
		return workName;
	}
	/**
	 * @param workName the workName to set
	 */
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	/**
	 * @return the workStatus
	 */
	public String getWorkStatus() {
		return workStatus;
	}
	/**
	 * @param workStatus the workStatus to set
	 */
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

}
