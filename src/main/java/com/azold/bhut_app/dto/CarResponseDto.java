package com.azold.bhut_app.dto;

import java.io.Serializable;

public class CarResponseDto implements Serializable {

    private String _id;
    private String title;
    private String brand;
    private String price;
    private Integer age;
    private Integer __v;

    public CarResponseDto(String _id, String title, String brand, String price, Integer age) {
        this._id = _id;
        this.title = title;
        this.brand = brand;
        this.price = price;
        this.age = age;
        this.__v = 0;
    }

    public CarResponseDto(String title, String brand, String price, Integer age) {
        this.title = title;
        this.brand = brand;
        this.price = price;
        this.age = age;
        this.__v = 0;
    }

    public CarResponseDto() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }
}