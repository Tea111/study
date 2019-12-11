package com.example.demo.model;

import lombok.Data;

/**
 * @User: WMJ
 * @create: 2019/9/5
 * @Description: No Description
 */
@Data
public class TestModel {
    private String name;
    private Integer age;

    public TestModel() {
    }

    public TestModel(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
