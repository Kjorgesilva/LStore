package com.example.lstore.repository

import com.example.lstore.dataBase.Dao.UserDao
import com.example.lstore.model.User

class UserRepository(private val userDao: UserDao) {

    suspend fun save(newUser: User) {
        userDao.insert(newUser)
    }

    suspend fun update(user: User) {
        userDao.update(user)
    }

    suspend fun delete(user: User) {
        userDao.delete(user)
    }

    fun getId(user: User) {
        userDao.getId(user.id)
    }

    suspend fun getAllUsers(): List<User> {
        return userDao.getAllUser()
    }
}

