package com.example.lstore.dataBase.Dao

import androidx.room.*
import com.example.lstore.model.User

@Dao
interface UserDao {
    companion object {
        const val QUERY_USER = "Select * from tab_user"
        const val QUERY_USER_ID = "Select * from tab_user where id = :key "
    }
    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Update
    suspend fun update(user: User)

    @Query(QUERY_USER)
    suspend fun getAllUser(): List<User>

    @Query(QUERY_USER_ID)
    fun getId(key: Int): User
}