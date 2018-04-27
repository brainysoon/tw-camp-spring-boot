package com.thoughtworks.fireman.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {

    private int id;
    private String name;
    private int age;
    private int gender;

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getId() == ((Employee) obj).getId();
    }
}
