package com.lib.springbootrestapirestauth.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
-- This Class
-   Representing data that can be persisted to the database table.
 */

@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor
public class ApiUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

}