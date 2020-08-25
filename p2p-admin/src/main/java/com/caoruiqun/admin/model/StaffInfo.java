package com.caoruiqun.admin.model;

import java.util.Date;

/**
 * 员工信息对象
 * 
 * @author Felix
 *
 */
public class StaffInfo {
	
    private Integer id;

    private String phone;

    private String email;

    private String realname;

    private Integer sex;

    private String staffno;

    private Integer orgid;

    private String jobtitle;

    private Date hiredate;
    
    private OrgInfo orgInfo;
	
	private POrgInfo pOrgInfo;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getStaffno() {
        return staffno;
    }

    public void setStaffno(String staffno) {
        this.staffno = staffno;
    }

    public Integer getOrgid() {
        return orgid;
    }

    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

	public OrgInfo getOrgInfo() {
		return orgInfo;
	}

	public void setOrgInfo(OrgInfo orgInfo) {
		this.orgInfo = orgInfo;
	}

	public POrgInfo getpOrgInfo() {
		return pOrgInfo;
	}

	public void setpOrgInfo(POrgInfo pOrgInfo) {
		this.pOrgInfo = pOrgInfo;
	}
}