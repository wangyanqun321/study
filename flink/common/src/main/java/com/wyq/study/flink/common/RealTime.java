package com.wyq.study.flink.common;

/**
 * @author 王艳群
 * @description com.wyq.study.flink.common.RealTime
 * @date 2020/9/14
 */
public class RealTime {

    private String week;

    private String wtId;

    private String wtNm;

    private String wtIcon;

    private String wtTemp;

    private String wtHumi;

    private String wtWindId;

    private String wtWindNm;

    private String wtWinp;

    private String wtWins;

    private String wtAqi;

    private String wtVisibility;

    private String wtRainfall;

    private String wtPressurel;

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWtId() {
        return wtId;
    }

    public void setWtId(String wtId) {
        this.wtId = wtId;
    }

    public String getWtNm() {
        return wtNm;
    }

    public void setWtNm(String wtNm) {
        this.wtNm = wtNm;
    }

    public String getWtIcon() {
        return wtIcon;
    }

    public void setWtIcon(String wtIcon) {
        this.wtIcon = wtIcon;
    }

    public String getWtTemp() {
        return wtTemp;
    }

    public void setWtTemp(String wtTemp) {
        this.wtTemp = wtTemp;
    }

    public String getWtHumi() {
        return wtHumi;
    }

    public void setWtHumi(String wtHumi) {
        this.wtHumi = wtHumi;
    }

    public String getWtWindId() {
        return wtWindId;
    }

    public void setWtWindId(String wtWindId) {
        this.wtWindId = wtWindId;
    }

    public String getWtWindNm() {
        return wtWindNm;
    }

    public void setWtWindNm(String wtWindNm) {
        this.wtWindNm = wtWindNm;
    }

    public String getWtWinp() {
        return wtWinp;
    }

    public void setWtWinp(String wtWinp) {
        this.wtWinp = wtWinp;
    }

    public String getWtWins() {
        return wtWins;
    }

    public void setWtWins(String wtWins) {
        this.wtWins = wtWins;
    }

    public String getWtAqi() {
        return wtAqi;
    }

    public void setWtAqi(String wtAqi) {
        this.wtAqi = wtAqi;
    }

    public String getWtVisibility() {
        return wtVisibility;
    }

    public void setWtVisibility(String wtVisibility) {
        this.wtVisibility = wtVisibility;
    }

    public String getWtRainfall() {
        return wtRainfall;
    }

    public void setWtRainfall(String wtRainfall) {
        this.wtRainfall = wtRainfall;
    }

    public String getWtPressurel() {
        return wtPressurel;
    }

    public void setWtPressurel(String wtPressurel) {
        this.wtPressurel = wtPressurel;
    }

    @Override
    public String toString() {
        return "RealTime{" +
            "week='" + week + '\'' +
            ", wtId='" + wtId + '\'' +
            ", wtNm='" + wtNm + '\'' +
            ", wtIcon='" + wtIcon + '\'' +
            ", wtTemp='" + wtTemp + '\'' +
            ", wtHumi='" + wtHumi + '\'' +
            ", wtWindId='" + wtWindId + '\'' +
            ", wtWindNm='" + wtWindNm + '\'' +
            ", wtWinp='" + wtWinp + '\'' +
            ", wtWins='" + wtWins + '\'' +
            ", wtAqi='" + wtAqi + '\'' +
            ", wtVisibility='" + wtVisibility + '\'' +
            ", wtRainfall='" + wtRainfall + '\'' +
            ", wtPressurel='" + wtPressurel + '\'' +
            '}';
    }
}
