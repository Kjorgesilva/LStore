package com.example.lstore.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lstore.dataBase.DataBase

class LoginViewModel(database: DataBase):ViewModel() {

    private val _checkRegistryStateState = MutableLiveData<CheckRegistryState>()
    val checkRegistryStateState = _checkRegistryStateState

    suspend fun checkRegistry (email: String, password: String){
        if (email.isNotEmpty() && password.isNotEmpty()){
            if (email.equals("k") && password.equals("k")){
                _checkRegistryStateState.value = CheckRegistryState.Success
            }else{
                _checkRegistryStateState.value = CheckRegistryState.Error
            }
        }else{
            _checkRegistryStateState.value = CheckRegistryState.Empty
        }
    }


    sealed class CheckRegistryState {
        object Success : CheckRegistryState()
        object Error : CheckRegistryState()
        object Empty : CheckRegistryState()
    }

}