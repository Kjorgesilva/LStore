package com.example.lstore.repository

import com.example.lstore.dataBase.Dao.UserDao
import com.example.lstore.model.User

class UserRepository(val userDao: UserDao) {

    suspend fun save(newUser: User) {
        userDao.insert(newUser)
    }

    suspend fun update(registration: User) {
        userDao.update(registration)
    }

    suspend fun delete(registration: User) {
        userDao.delete(registration)
    }

    fun getId(registration: User) {
        userDao.getId(registration.id)
    }

    suspend fun getAllRegistrations(): List<User> {
        return userDao.getAllUser()
    }
}

