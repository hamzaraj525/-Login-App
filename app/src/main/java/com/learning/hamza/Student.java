package com.learning.hamza;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "users", indices = @Index(value = {"userId"}, unique = true))

/*@Entity(tableName = "users")*/
public class Student {


    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "userId")
    String userId;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "surname")
    String surname;
    @ColumnInfo(name = "birthYear")
    Integer birthYear;
    @ColumnInfo(name = "username")
    String username;
    @ColumnInfo(name = "password")
    String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
