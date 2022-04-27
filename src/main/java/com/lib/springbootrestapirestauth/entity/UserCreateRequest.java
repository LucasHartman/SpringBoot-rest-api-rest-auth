package com.lib.springbootrestapirestauth.entity;

import lombok.Data;

/*
--  This Class
-   Bring data from REST controller to service
-
 */

@Data
public class UserCreateRequest {
    private String username;
    private String password;
}