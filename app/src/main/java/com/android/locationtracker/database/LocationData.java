package com.android.locationtracker.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by hp pc on 17-06-2017.
 */
@Entity
public class LocationData {
    @Id(autoincrement = true)
    private Long id;
    private String time;
    private Double latitiude;
    private Double longitude;
    private int currTimeIntervel;
    private int nextTimeIntervel;
    @Generated(hash = 669705769)
    public LocationData(Long id, String time, Double latitiude, Double longitude,
            int currTimeIntervel, int nextTimeIntervel) {
        this.id = id;
        this.time = time;
        this.latitiude = latitiude;
        this.longitude = longitude;
        this.currTimeIntervel = currTimeIntervel;
        this.nextTimeIntervel = nextTimeIntervel;
    }
    @Generated(hash = 1606831457)
    public LocationData() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public Double getLatitiude() {
        return this.latitiude;
    }
    public void setLatitiude(Double latitiude) {
        this.latitiude = latitiude;
    }
    public Double getLongitude() {
        return this.longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public int getCurrTimeIntervel() {
        return this.currTimeIntervel;
    }
    public void setCurrTimeIntervel(int currTimeIntervel) {
        this.currTimeIntervel = currTimeIntervel;
    }
    public int getNextTimeIntervel() {
        return this.nextTimeIntervel;
    }
    public void setNextTimeIntervel(int nextTimeIntervel) {
        this.nextTimeIntervel = nextTimeIntervel;
    }
    
}
