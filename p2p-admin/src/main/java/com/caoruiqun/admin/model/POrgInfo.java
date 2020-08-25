package com.caoruiqun.admin.model;

/**
 * 组织机构信息对象
 * 
 * @author Felix
 *
 */
public class POrgInfo {
	
    private Integer pOrgId;

    private String pOrgName;

    private Integer ppid;

	public Integer getpOrgId() {
		return pOrgId;
	}

	public void setpOrgId(Integer pOrgId) {
		this.pOrgId = pOrgId;
	}

	public String getpOrgName() {
		return pOrgName;
	}

	public void setpOrgName(String pOrgName) {
		this.pOrgName = pOrgName;
	}

	public Integer getPpid() {
		return ppid;
	}

	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}
}