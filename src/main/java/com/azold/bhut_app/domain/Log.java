package com.azold.bhut_app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String data_hora;
    private String car_id;

    public Log(){
    }

    public Log(String data_hora, String car_id) {
        this.data_hora = data_hora;
        this.car_id = car_id;
    }

    public Log(Integer id, String data_hora, String car_id) {
        this.id = id;
        this.data_hora = data_hora;
        this.car_id = car_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }
}
