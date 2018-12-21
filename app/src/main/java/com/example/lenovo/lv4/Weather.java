package com.example.lenovo.lv4;

import android.provider.ContactsContract;

import java.util.List;

public class Weather {
public Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
class Data{
    public Yesterday yesterday;
String city;
String aqi;
    public List<Forecast> forecast;
}
class Yesterday{
    String date;
    String high;
    String fx;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String Fx() {
        return fx;
    }

    public void setFx(String fengxiang) {
        this.fx = fengxiang;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fengli) {
        this.fl = fengli;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String low;
String fl;
String type;


}
class Forecast{
    String date;
    String high;
    String fengli;

    public Forecast(String date, String high, String fengli, String low, String fengxiang, String type) {
        this.date = date;
        this.high = high;
        this.fengli = fengli;
        this.low = low;
        this.fengxiang = fengxiang;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String low;
    String fengxiang;
    String type;

    public String toString() {

        return "风向=" + fengxiang+ "  "+ " 风力=" + fengli

                + " 高温=" + "  "+ high + ", 天气类型=" + "  "+ type + ", 低温=" + low+ "  "

                + "日期=" + date ;

    }
}
