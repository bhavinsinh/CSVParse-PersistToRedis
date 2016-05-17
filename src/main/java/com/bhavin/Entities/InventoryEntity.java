package com.bhavin.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by bhavinchauhan on 5/17/16.
 */

/**
 * Created by bhavinchauhan on 5/17/16.
 */


@Entity
@Table(name = "Inventory")
public class InventoryEntity {
    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column
    private int operator_id;
    @Column
    private Date trip_date;
    @Column
    private Date arrival_date;
    @Column
    private Date arrival_time;
    @Column
    private int route_id;
    @Column
    private int from_location_id;
    @Column
    private int to_location_id;
    @Column
    private int from_station_id;
    @Column
    private int to_station_id;
    @Column
    private String coach_type;
    @Column
    private int coach_id;
    @Column
    private String trip_status;


    public Date getTrip_date() {
        return trip_date;
    }

    public void setTrip_date(Date trip_date) {
        this.trip_date = trip_date;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public int getFrom_location_id() {
        return from_location_id;
    }

    public void setFrom_location_id(int from_location_id) {
        this.from_location_id = from_location_id;
    }

    public int getTo_location_id() {
        return to_location_id;
    }

    public void setTo_location_id(int to_location_id) {
        this.to_location_id = to_location_id;
    }

    public int getFrom_station_id() {
        return from_station_id;
    }

    public void setFrom_station_id(int from_station_id) {
        this.from_station_id = from_station_id;
    }

    public int getTo_station_id() {
        return to_station_id;
    }

    public void setTo_station_id(int to_station_id) {
        this.to_station_id = to_station_id;
    }

    public String getCoach_type() {
        return coach_type;
    }

    public void setCoach_type(String coach_type) {
        this.coach_type = coach_type;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public String getTrip_status() {
        return trip_status;
    }

    public void setTrip_status(String trip_status) {
        this.trip_status = trip_status;
    }
}
