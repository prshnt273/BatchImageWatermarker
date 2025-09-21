package com.kokoa.entity.common;

import lombok.Data;


@Data
public class Account {
    int id;
    String email;
    String username;
    String password;
}