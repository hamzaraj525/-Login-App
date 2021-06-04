package com.learning.hamza;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    void registerUser(Student student);


    @Query("SELECT * FROM users where userId=(:userId) and password =(:password)")
    Student login(String userId, String password);
}





