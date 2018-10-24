package com.spring.init.vo;

import javax.validation.constraints.NotNull;

public class UserInfoVO {

	private int uiNo;
	private String uiId;
	@NotNull
	private String uiName;
	private String uiPwd;
	private String uiHP;
	private int admin;
	
	public int getUiNo() {
		return uiNo;
	}
	public void setUiNo(int uiNo) {
		this.uiNo = uiNo;
	}
	public String getUiId() {
		return uiId;
	}
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}
	public String getUiName() {
		return uiName;
	}
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
	public String getUiPwd() {
		return uiPwd;
	}
	public void setUiPwd(String uiPwd) {
		this.uiPwd = uiPwd;
	}
	public String getUiHP() {
		return uiHP;
	}
	public void setUiHP(String uiHP) {
		this.uiHP = uiHP;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "UserInfoVO [uiNo=" + uiNo + ", uiId=" + uiId + ", uiName=" + uiName + ", uiPwd=" + uiPwd + ", uiHP="
				+ uiHP + ", admin=" + admin + "]";
	}
	

	
}
