package com.example.lstore.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tab_user")
data class User(

    //id.
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    //nome do usuario.
    @ColumnInfo(name = "name")
    var name: String,

    //senha do usuario.
    @ColumnInfo(name = "password")
    var password: String,

    //email do usuario, sera usado para fazer login.
    @ColumnInfo(name = "email")
    var email: String,

    //data de nacimento.
    @ColumnInfo(name = "birthDate")
    var birthDate: String,

    //genero do usuario.
    @ColumnInfo(name = "gender")
    var gender: String,

    //cpf do usuario.
    @ColumnInfo(name = "cpf")
    var cpf: String,

    //telefone do usuario.
    @ColumnInfo(name = "phoneNumber")
    var phoneNumber: String
)