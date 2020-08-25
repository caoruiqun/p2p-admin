package com.caoruiqun.admin.model;

import java.util.Date;

public class SlideShow {
    private Integer id;

    private String slideTitle;

    private String slideUrl;

    private String slideImageUrl;

    private Date slideStartTime;

    private Date slideEndTime;

    private Integer slideStatus;

    private Date slideCreateTime;

    private Date slideUpdateTime;

    private String slideGroup;

    private String slideFilepath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlideTitle() {
        return slideTitle;
    }

    public void setSlideTitle(String slideTitle) {
        this.slideTitle = slideTitle;
    }

    public String getSlideUrl() {
        return slideUrl;
    }

    public void setSlideUrl(String slideUrl) {
        this.slideUrl = slideUrl;
    }

    public String getSlideImageUrl() {
        return slideImageUrl;
    }

    public void setSlideImageUrl(String slideImageUrl) {
        this.slideImageUrl = slideImageUrl;
    }

    public Date getSlideStartTime() {
        return slideStartTime;
    }

    public void setSlideStartTime(Date slideStartTime) {
        this.slideStartTime = slideStartTime;
    }

    public Date getSlideEndTime() {
        return slideEndTime;
    }

    public void setSlideEndTime(Date slideEndTime) {
        this.slideEndTime = slideEndTime;
    }

    public Integer getSlideStatus() {
        return slideStatus;
    }

    public void setSlideStatus(Integer slideStatus) {
        this.slideStatus = slideStatus;
    }

    public Date getSlideCreateTime() {
        return slideCreateTime;
    }

    public void setSlideCreateTime(Date slideCreateTime) {
        this.slideCreateTime = slideCreateTime;
    }

    public Date getSlideUpdateTime() {
        return slideUpdateTime;
    }

    public void setSlideUpdateTime(Date slideUpdateTime) {
        this.slideUpdateTime = slideUpdateTime;
    }

    public String getSlideGroup() {
        return slideGroup;
    }

    public void setSlideGroup(String slideGroup) {
        this.slideGroup = slideGroup;
    }

    public String getSlideFilepath() {
        return slideFilepath;
    }

    public void setSlideFilepath(String slideFilepath) {
        this.slideFilepath = slideFilepath;
    }
}