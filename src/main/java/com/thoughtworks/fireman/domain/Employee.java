package com.thoughtworks.fireman.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {

    public static final String MAN = "男";
    public static final String WOMAN = "男";

    private int id = -1;
    private String name;
    private int age;
    private int gender;

    @Override
    public boolean equals(Object obj) {
        return obj != null && this.getId() == ((Employee) obj).getId();
    }

    public String getGender() {
        return gender > 0 ? MAN : WOMAN;
    }
}
