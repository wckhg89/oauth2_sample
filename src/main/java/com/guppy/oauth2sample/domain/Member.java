package com.guppy.oauth2sample.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by kanghonggu on 2017. 7. 5..
 */
@Data
@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String username;
    private String remark;

    public Member() {}
    public Member(String name, String username, String remark) {
        this.name = name;
        this.username = username;
        this.remark = remark;
    }
}
