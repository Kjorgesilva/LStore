package com.example.lstore.ui.register

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lstore.dataBase.DataBase
import com.example.lstore.model.Product
import com.example.lstore.model.User
import com.example.lstore.repository.UserRepository

class RegisterViewModel(dataBase: DataBase) : ViewModel() {

    private val _registerState = MutableLiveData<RegisterState>()
    val registerState = _registerState

    var productListLive: MutableLiveData<MutableList<Product>> = MutableLiveData()


    var registerRepository = UserRepository(dataBase.userDao)


    suspend fun addRegistry(
        name: String,
        email: String,
        password: String,
        birthDate: String,
        cpf: String,
        gender: String
    ) {
        if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && birthDate.isNotEmpty() && cpf.isNotEmpty() && gender.isNotEmpty()) {
            val user = User(
                name = name,
                email = email,
                password = password,
                birthDate = birthDate,
                cpf = cpf,
                gender = gender
            )
            Log.e("add", "Add User: $user")
            saveRegister(user)
        } else {
            _registerState.value = RegisterState.Empty
        }
    }

    private suspend fun saveRegister(user: User) {
        try {
            registerRepository.save(user)
            _registerState.value = RegisterState.Success
        } catch (e: Exception) {
            Log.e("Erro", "Mensagem: $e")
            _registerState.value = RegisterState.Error
        }
    }

    sealed class RegisterState {
        object Success : RegisterState()
        object Error : RegisterState()
        object Empty : RegisterState()
    }

    fun setProductList(product: Product) {
        val list = ArrayList<Product>()
        list.add(product)
        productListLive.value = list
    }

}