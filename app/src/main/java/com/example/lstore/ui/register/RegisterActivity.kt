package com.example.lstore.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.lstore.R
import com.example.lstore.dataBase.DataBase
import com.example.lstore.databinding.ActivityRegisterBinding
import com.example.lstore.model.User
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {

    lateinit var dataBase: DataBase
    lateinit var viewModel: RegisterViewModel

    private val binding by lazy { ActivityRegisterBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        dataBase = DataBase.getInstance(this)
        viewModel = RegisterViewModel(dataBase)

        setupListeners()
        setupObservers()
        initOnClick()
    }

    private fun initOnClick() {
        binding.ibBackButton.setOnClickListener {
            this.finish()
        }
    }

    private fun setupListeners() = with(binding) {
        btnRegister.setOnClickListener {
            lifecycleScope.launch { addUser() }
        }
    }

    private fun setupObservers() {
        viewModel.registerState.observe(this, { registration ->
            when (registration) {
                RegisterViewModel.RegisterState.Success -> finish()
                RegisterViewModel.RegisterState.Error -> showError()
                RegisterViewModel.RegisterState.Empty-> showEmptyError()
            }
        })
    }

    private suspend fun addUser() {
        viewModel.addRegistry(
            name = binding.edtName.text.toString(),
            email = binding.edtEmail.text.toString(),
            password = binding.edtPassword.text.toString(),
            birthDate = binding.edtBirthdate.text.toString(),
            cpf = binding.edtCpf.text.toString(),
            gender = binding.edtGender.text.toString()
        )
    }

    private fun showError() {
        Toast.makeText(this, "Erro ao salvar no banco", Toast.LENGTH_LONG).show()
    }

    private fun showEmptyError() {
        Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
    }
}