package com.azold.bhut_app.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CarRequestDto {

    @NotNull(message = "O campo TITLE não pode ser nulo")
    @Length(min = 3, max = 50, message = "O campo TITLE deve ter entre 3 e 50 caracteres")
    private String title;

    @NotNull(message = "O campo BRAND não pode ser nulo")
    @Length(min = 3, max = 50, message = "O campo BRAND deve ter entre 3 e 50 caracteres")
    private String brand;

    @NotNull(message = "O campo PRICE não pode ser nulo")
    private String price;

    @NotNull(message = "O campo AGE não pode ser nulo")
    @Min(value = 500, message = "O campo AGE deve ser maior que 500")
    private Integer age;

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
}
