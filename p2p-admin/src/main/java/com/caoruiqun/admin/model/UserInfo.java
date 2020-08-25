package com.caoruiqun.admin.model;

import java.util.Date;
import java.util.List;

public class UserInfo {
    private Integer id;

    private String username;

    private String password;

    private Date createDate;

    private Date lastLoginTime;

    private Integer loginCount;

    private Integer staffId;

    private StaffInfo staffInfo;

    //当前用户拥有的所有菜单权限
    private List<PermissionInfo> menuPermissionInfoList;

    //当前用户拥有的所有按钮权限
    private List<PermissionInfo> buttonPermissionInfoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public StaffInfo getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
    }

    public List<PermissionInfo> getMenuPermissionInfoList() {
        return menuPermissionInfoList;
    }

    public void setMenuPermissionInfoList(List<PermissionInfo> menuPermissionInfoList) {
        this.menuPermissionInfoList = menuPermissionInfoList;
    }

    public List<PermissionInfo> getButtonPermissionInfoList() {
        return buttonPermissionInfoList;
    }

    public void setButtonPermissionInfoList(List<PermissionInfo> buttonPermissionInfoList) {
        this.buttonPermissionInfoList = buttonPermissionInfoList;
    }
}