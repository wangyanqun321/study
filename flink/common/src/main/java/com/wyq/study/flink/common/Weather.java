package com.wyq.study.flink.common;

/**
 * @author 王艳群
 * @description com.wyq.study.flink.common.Weather
 * @date 2020/9/14
 */
public class Weather {

    private String weaid;

    private String cityid;

    private String area_1;

    private String area_2;

    private String area_3;

    private RealTime realTime;

    public String getWeaid() {
        return weaid;
    }

    public void setWeaid(String weaid) {
        this.weaid = weaid;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getArea_1() {
        return area_1;
    }

    public void setArea_1(String area_1) {
        this.area_1 = area_1;
    }

    public String getArea_2() {
        return area_2;
    }

    public void setArea_2(String area_2) {
        this.area_2 = area_2;
    }

    public String getArea_3() {
        return area_3;
    }

    public void setArea_3(String area_3) {
        this.area_3 = area_3;
    }

    public RealTime getRealTime() {
        return realTime;
    }

    public void setRealTime(RealTime realTime) {
        this.realTime = realTime;
    }

    @Override
    public String toString() {
        return "Weather{" +
            "weaid='" + weaid + '\'' +
            ", cityid='" + cityid + '\'' +
            ", area_1='" + area_1 + '\'' +
            ", area_2='" + area_2 + '\'' +
            ", area_3='" + area_3 + '\'' +
            ", realTime=" + realTime +
            '}';
    }
}
