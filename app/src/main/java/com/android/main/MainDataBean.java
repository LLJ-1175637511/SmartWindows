package com.android.main;

import com.llj.baselib.IOTInterfaceId;

public class MainDataBean {

    @IOTInterfaceId("22755")
    private Float temp;

    @IOTInterfaceId("22973")
    private Float humi;

    @IOTInterfaceId("22759")
    private Float co2;

    @IOTInterfaceId("22756")
    private Float pm25;

    @IOTInterfaceId("22758")
    private Float voice;

    @IOTInterfaceId("22757")
    private Float isRained;

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getHumi() {
        return humi;
    }

    public void setHumi(Float humi) {
        this.humi = humi;
    }

    public Float getCo2() {
        return co2;
    }

    public void setCo2(Float co2) {
        this.co2 = co2;
    }

    public Float getPm25() {
        return pm25;
    }

    public void setPm25(Float pm25) {
        this.pm25 = pm25;
    }

    public Float getVoice() {
        return voice;
    }

    public void setVoice(Float voice) {
        this.voice = voice;
    }

    public Float getIsRained() {
        return isRained;
    }

    public void setIsRained(Float isRained) {
        this.isRained = isRained;
    }
}
